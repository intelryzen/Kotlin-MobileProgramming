package com.example.lastmidtest.graph
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.lastmidtest.components.WssDetailScreen
import com.example.lastmidtest.components.WssHomeScreen
import com.example.lastmidtest.model.WssRoute

@Composable
fun WssGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = WssRoute.WssHome.route) {
        composable(route = WssRoute.WssHome.route) {
            WssHomeScreen(
                onNavigate = { name, phone, count ->
                    navController.navigate(WssRoute.WssDetail.route + "/${name}/${phone}/$count")
                },
            )
        }
        composable(
            route = WssRoute.WssDetail.route + "/{name}/{phone}/{count}",
            arguments = listOf(
                navArgument(name = "name") {
                    type = NavType.StringType
                },
                navArgument(name = "phone") {
                    type = NavType.StringType
                },
                navArgument(name = "count") {
                    type = NavType.IntType
                }
            ),
        ) {
            WssDetailScreen(
                it.arguments?.getString("name"),
                it.arguments?.getString("phone"),
                it.arguments?.getInt("count")
            )
        }
    }
}