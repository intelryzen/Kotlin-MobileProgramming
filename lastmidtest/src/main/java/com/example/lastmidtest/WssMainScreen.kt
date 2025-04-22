package com.example.lastmidtest
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.lastmidtest.graph.WssGraph

@Composable
fun WssMainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    WssGraph(navController= navController)
}