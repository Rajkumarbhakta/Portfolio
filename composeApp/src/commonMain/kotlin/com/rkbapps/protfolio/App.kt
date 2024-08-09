package com.rkbapps.protfolio

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import protfolio.composeapp.generated.resources.*
import com.rkbapps.protfolio.theme.AppTheme
import com.rkbapps.protfolio.screens.HomeScreen


@Composable
internal fun App() = AppTheme {
    Navigator(screen = HomeScreen()){
        SlideTransition(it)
    }
}
