package com.example.week09.example02.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.week09.example02.navigation.BottomNavigationBar
import com.example.week09.example02.navigation.NavGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen2(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "20000 홍길동") }
            )
        },
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) {
            NavGraph(navController = navController)
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MaterialTheme {
        MainScreen2()
    }
}