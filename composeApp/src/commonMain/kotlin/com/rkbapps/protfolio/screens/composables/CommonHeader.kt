package com.rkbapps.protfolio.screens.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.rkbapps.protfolio.models.Tabs
import org.jetbrains.compose.resources.Font
import protfolio.composeapp.generated.resources.IndieFlower_Regular
import protfolio.composeapp.generated.resources.Res

@Composable
fun CommonHeader(tab: Tabs,widthSizeClass: WindowWidthSizeClass,content: @Composable () -> Unit){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(if (widthSizeClass != WindowWidthSizeClass.Compact) 50.dp else 0.dp))
        Text(
            tab.title,
            modifier = Modifier.fillMaxWidth(),
            fontFamily = FontFamily(Font(Res.font.IndieFlower_Regular)),
            style = MaterialTheme.typography.displayLarge,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(10.dp))
        content()
    }
}