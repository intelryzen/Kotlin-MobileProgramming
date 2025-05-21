package com.example.week11.example012

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup

class SongViewModel : ViewModel() {

    private val _songList = mutableStateListOf<SongData>()
    val songList = _songList

    private val _isLoading = mutableStateOf(
        false
    )
    val isLoading = _isLoading

    fun fetchSongs() {
        isLoading.value = true;
        viewModelScope.launch {
            try {
                val fetchedSongs = getSongs()
                _songList.clear()
                _songList.addAll(fetchedSongs)
            } catch (e: Exception) {
                Log.e("error", "fetch 관련 오류 발생", e)
            } finally {
                _isLoading.value = false
            }
        }
    }

    private suspend fun getSongs(): List<SongData> = withContext(Dispatchers.IO) {
        val doc = Jsoup.connect("https://www.melon.com/chart/index.htm")
            .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/136.0.0.0 Safari/537.36")
            .referrer("https://www.google.com")
            .timeout(10000)
            .get()

        val table = doc.select("tbody>tr")

        table.mapIndexedNotNull { index, tr ->
            // 6번째 td
            val songTd = tr.selectFirst("td:nth-of-type(6)") ?: return@mapIndexedNotNull null

            // td 안에 div > div 구조
            val infoDiv = songTd.selectFirst("div > div") ?: return@mapIndexedNotNull null

            // div 안의 두 개 a 태그
            val links = infoDiv.select("div > span > a")
            if (links.size < 2) return@mapIndexedNotNull null

            val songTitle = links[0].text().trim()
            val artistName = links[1].text().trim()

            SongData(index + 1, songTitle, artistName)
        }
//        headlines.mapNotNull { li ->
//            val a = li.selectFirst("a") ?: return@mapNotNull null
//            val title = a.select("strong.tit_txt").text()
//            val link = a.absUrl("href")
//            NewsData(title.toString(), link)
//        }
    }
}