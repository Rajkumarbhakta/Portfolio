package com.rkbapps.protfolio.screens.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
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
fun EducationPage() {
    val widthSizeClass = getWindowSize().widthSizeClass
    val educationList = remember {
        mutableStateListOf(
            EducationData("B.Tech in CSE","GMIT","2024","80%"),
            EducationData("XII","Balichak Bhajahari Institution","2020","85%"),
            EducationData("X","Gopinathpur Devayatan Vidyapith","2018","85%"),
        )
    }
    CommonHeader(
        tab = Tabs.EDUCATION,
        widthSizeClass = widthSizeClass
    ) {
        Box(modifier = Modifier.fillMaxWidth(if(widthSizeClass!= WindowWidthSizeClass.Compact) 0.6f else 1.0f), contentAlignment = Alignment.Center){
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 250.dp),
            ){
                items(educationList.size){
                    EducationCards(educationList[it])
                }
            }
        }
    }
}

@Composable
fun EducationCards(education:EducationData) {
    OutlinedCard(
        modifier = Modifier.padding(8.dp),
        onClick = {}){
        Column (modifier = Modifier.height(200.dp).padding(16.dp), verticalArrangement = Arrangement.Center){
            Text(education.duration,style = MaterialTheme.typography.labelMedium)
            Text(education.title,style = MaterialTheme.typography.displaySmall)
            Text(education.institute,style = MaterialTheme.typography.labelMedium)
            Text(education.percentage,style = MaterialTheme.typography.labelMedium)
        }
    }


}

@Immutable
@Stable
data class EducationData(
    val title:String,
    val institute:String,
    val duration:String,
    val percentage:String
)