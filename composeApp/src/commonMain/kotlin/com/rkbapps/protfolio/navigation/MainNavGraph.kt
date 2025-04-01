package com.rkbapps.protfolio.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rkbapps.protfolio.screens.HomeScreen

@Composable
fun MainNavGraph(navController: NavHostController){
    NavHost(navController=navController,startDestination = HomePage){
        composable<HomePage> {
            HomeScreen(navController=navController)
        }
    }
}