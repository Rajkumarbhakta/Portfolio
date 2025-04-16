package com.rkbapps.protfolio.screens.home_new

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.rkbapps.protfolio.screens.home_new.composables.ProfileComposable
import com.rkbapps.protfolio.screens.home_new.composables.TechnicalDetailsComposable
import com.rkbapps.protfolio.theme.LocalThemeIsDark
import com.rkbapps.protfolio.utils.getWindowSize
import org.jetbrains.compose.resources.vectorResource
import protfolio.composeapp.generated.resources.Res
import protfolio.composeapp.generated.resources.ic_dark_mode
import protfolio.composeapp.generated.resources.ic_light_mode

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeNewScreen(navController: NavHostController) {

    val windowSizeClass = getWindowSize().widthSizeClass

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                actions = {
                    var isDark by LocalThemeIsDark.current
                    val icon = remember(isDark) {
                        if (isDark) Res.drawable.ic_light_mode
                        else Res.drawable.ic_dark_mode
                    }
                    IconButton(
                        onClick = { isDark = !isDark },
                        content = {
                            Icon(vectorResource(icon), contentDescription = null)
                        }
                    )
                }
            )
        }
    ) {
        if (windowSizeClass == WindowWidthSizeClass.Expanded) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(it)
                    .padding(vertical = 8.dp, horizontal = 16.dp)
            ) {
                ProfileComposable(
                    modifier = Modifier.fillMaxHeight().weight(40f)
                        .verticalScroll(rememberScrollState())
                )
                TechnicalDetailsComposable(
                    modifier = Modifier.fillMaxHeight().weight(60f)
                        .verticalScroll(rememberScrollState())
                )
            }
        } else {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Column(
                    modifier = Modifier.fillMaxWidth(0.8f)
                        .padding(it)
                        .padding(vertical = 8.dp, horizontal = 16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    ProfileComposable()
                    TechnicalDetailsComposable()
                }
            }
        }
    }

}



















