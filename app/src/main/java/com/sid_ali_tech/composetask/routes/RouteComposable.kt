package com.sid_ali_tech.composetask.routes

import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sid_ali_tech.composetask.routes.Routes
import com.sid_ali_tech.composetask.ui.screens.auth.LoginPage
import com.sid_ali_tech.composetask.ui.screens.dashboard.DashboardScreen

@Composable
fun RoutesComposable(){
    val navController= rememberNavController()

    NavHost(navController = navController, startDestination = Routes.LoginPage.route ){
        composable(Routes.LoginPage.route){
            LoginPage(navController= navController)
        }
        composable(Routes.DashboardScreen.route , arguments = listOf(
            navArgument(name = "userName") {
                type = NavType.StringType
            },

        )){navEntry->
            val userName=navEntry.arguments?.getString("userName")
            userName?.let {
                DashboardScreen(navHostController = navController,userName)
            }
        }
    }
}