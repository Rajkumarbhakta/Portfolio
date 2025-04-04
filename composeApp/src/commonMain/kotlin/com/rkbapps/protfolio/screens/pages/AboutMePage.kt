package com.rkbapps.protfolio.screens.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.rkbapps.protfolio.models.Tabs
import com.rkbapps.protfolio.screens.composables.CommonHeader
import com.rkbapps.protfolio.utils.getWindowSize
import org.jetbrains.compose.resources.Font
import protfolio.composeapp.generated.resources.IndieFlower_Regular
import protfolio.composeapp.generated.resources.Res

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun AboutMePage() {
    val widthSizeClass = getWindowSize().widthSizeClass
    CommonHeader(
        tab = Tabs.ABOUT_ME,
        widthSizeClass = widthSizeClass
    ) {
        Text("Rajkumar Bhakta is an enthusiastic Android developer with a deep passion for creating innovative and user-friendly mobile applications. His dedication to mastering the Android platform and staying up-to-date with the latest technologies drives his work, making him a valuable contributor to the ever-evolving world of mobile development. Rajkumar's commitment to excellence is evident in every project he undertakes, as he strives to deliver high-quality, impactful solutions that meet user needs and exceed expectations.",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.fillMaxWidth(if(widthSizeClass!= WindowWidthSizeClass.Compact) 0.6f else 1.0f),
            textAlign = TextAlign.Justify,
        )
    }
}