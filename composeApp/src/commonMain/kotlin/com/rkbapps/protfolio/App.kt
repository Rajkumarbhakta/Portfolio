package com.rkbapps.protfolio


import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rkbapps.protfolio.navigation.MainNavGraph
import com.rkbapps.protfolio.theme.AppTheme


@Composable
internal fun App(navController: NavHostController = rememberNavController()) = AppTheme {
    MainNavGraph(navController)
}
