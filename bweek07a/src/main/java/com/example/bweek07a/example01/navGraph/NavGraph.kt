package com.example.bweek07a.example01.navGraph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bweek07a.example01.model.Routes
import com.example.bweek07a.example01.uicomponents.HomeScreen
import com.example.bweek07a.example01.uicomponents.Screen_A
import com.example.bweek07a.example01.uicomponents.Screen_B
import com.example.bweek07a.example01.uicomponents.Screen_C
import com.example.bweek07a.example01.uicomponents.Screen_D

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = Routes.Home.route) {

        composable(route = Routes.Home.route) {
            HomeScreen(
                onNavigateA = { navController.navigate(Routes.ScreenA.route) },
                onNavigateB = { navController.navigate(Routes.ScreenB.route) }
            )
        }

        composable(route = Routes.ScreenA.route) {
            Screen_A(
                onNavigateC = { navController.navigate(Routes.ScreenC.route) },
                onNavigateD = { navController.navigate(Routes.ScreenD.route) })
        }

        composable(route = Routes.ScreenB.route) {
            Screen_B()
        }

        composable(route = Routes.ScreenC.route) {
            Screen_C(onNavigate = {
                // Home.route 이동하기 전에 스택의 위에서부터
                // 아래로 Home.route 전까지 다 Pop 함
                // inclusive = true 옵션이 있으면 Home.route 도 pop
                // launchSingleTop = true => Home.route가 이미 백스택 최상단에 있으면 새로 추가하지 않고, 기존 인스턴스를 재사용

                navController.navigate(Routes.Home.route) {
                    popUpTo(Routes.Home.route) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }
            })
        }

        composable(route = Routes.ScreenD.route) {
            Screen_D(onNavigate = { navController.navigate(Routes.ScreenC.route) })
        }
    }
}