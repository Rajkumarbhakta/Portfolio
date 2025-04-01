package com.rkbapps.protfolio.utils

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable

@Composable
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
actual fun getWindowSize():  WindowSizeClass {
    return calculateWindowSizeClass();
}