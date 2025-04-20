package com.example.bweek07b.example02.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.bweek07b.example02.model.Routes
import com.example.bweek07b.example02.uicomponents.LoginScreen
import com.example.bweek07b.example02.uicomponents.Register
import com.example.bweek07b.example02.uicomponents.WelcomeScreen


@Composable
fun LoginNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Routes.Login.route) {
        composable(route = Routes.Login.route) {
            LoginScreen(
                onWelcomeNavigate = { userId ->
                    navController.navigate(Routes.Welcome.route + "/${userId}")
                },
                onRegisterNavigate = { userId, userPasswd ->
                    if (userId.isNotEmpty())
                        navController.navigate(Routes.Register.route + "?userID=${userId}&passWD=${userPasswd}")
                    else
                        navController.navigate(Routes.Register.route)
                }
            )
        }

        composable(
            route = Routes.Welcome.route + "/{userID}",
            arguments = listOf(
                navArgument(name = "userID") {
                    type = NavType.StringType
                }
            )
        ) {
            WelcomeScreen(
                it.arguments?.getString("userID")
            )
        }

        composable(
            route = Routes.Register.route + "?userID={userID}&passWD={passWD}",
            arguments = listOf(
                navArgument(name = "userID") {
                    type = NavType.StringType
                    defaultValue = "User"
                },
                navArgument(name = "passWD") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            Register(
                it.arguments?.getString("userID"),
                it.arguments?.getString("passWD")
            )
        }
    }
}