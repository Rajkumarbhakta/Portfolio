package com.rkbapps.protfolio.screens.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import com.rkbapps.protfolio.screens.composables.CommonHeader
import com.rkbapps.protfolio.utils.getWindowSize
import org.jetbrains.compose.resources.Font
import protfolio.composeapp.generated.resources.IndieFlower_Regular
import protfolio.composeapp.generated.resources.Res

@Composable
fun SkillsPage(){
    val widthSizeClass = getWindowSize().widthSizeClass
    CommonHeader(
        tab = Tabs.SKILLS,
        widthSizeClass = widthSizeClass
    ) {
        Box(modifier = Modifier.fillMaxWidth(if(widthSizeClass!= WindowWidthSizeClass.Compact) 0.6f else 1.0f), contentAlignment = Alignment.Center){
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 250.dp),
            ){

            }
        }
    }
}