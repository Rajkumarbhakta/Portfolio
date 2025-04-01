package com.rkbapps.protfolio.screens.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
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
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.rkbapps.protfolio.models.Tabs
import com.rkbapps.protfolio.screens.composables.CommonHeader
import com.rkbapps.protfolio.utils.getWindowSize
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import protfolio.composeapp.generated.resources.IndieFlower_Regular
import protfolio.composeapp.generated.resources.Res
import protfolio.composeapp.generated.resources.github_mark
import protfolio.composeapp.generated.resources.google_play


@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun ProjectsPage(modifier: Modifier = Modifier) {
    val widthSizeClass = getWindowSize().widthSizeClass

    val projectList = remember {
        mutableStateListOf(
            ProjectData(title = "TooAi", description = "TooAI is a AI based android application that helps you to do Ai tasks withing the device.", githubLink = "https://github.com/Rajkumarbhakta/TooAi", playStoreLink = "https://play.google.com/store/apps/details?id=com.rkbapps.tooai", time = "2024"),
            ProjectData(title = "Physics Galaxy", description = "A Educational android application with payment and batch functionality.", githubLink = null, playStoreLink = "https://play.google.com/store/apps/details?id=com.rkbapps.physicsgalaxy", time = "2022"),
            ProjectData(title = "Neetflix", description = "A movie tv series list android application consuming TMDB api. ", githubLink = "https://github.com/Rajkumarbhakta/Neetflix", playStoreLink = null, time = "2023"),
            ProjectData(title = "Pixy", description = "A wallpaper application consuming unsplash application.", githubLink = "https://github.com/Rajkumarbhakta/Pixy", playStoreLink = null, time = "2023"),
        )
    }

    CommonHeader(
        tab = Tabs.PROJECTS,
        widthSizeClass = widthSizeClass
    ) {
        Box(modifier = Modifier.fillMaxWidth(if(widthSizeClass!= WindowWidthSizeClass.Compact) 0.6f else 1.0f), contentAlignment = Alignment.Center){
            LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 250.dp),){
                items(projectList.size){
                    ProjectCards(projectList[it])
                }
            }
        }
    }
}


@Composable
fun ProjectCards(projectData:ProjectData) {
    val uriHandler = LocalUriHandler.current
    OutlinedCard(modifier = Modifier.padding(8.dp), onClick = {}){
        Box(modifier = Modifier.padding(16.dp).fillMaxWidth().height(200.dp),){
            Column(modifier = Modifier.padding(bottom = 60.dp),){
                Text(projectData.time,style = MaterialTheme.typography.labelMedium)
                Text(projectData.title,style = MaterialTheme.typography.displaySmall)
                Text(projectData.description,style = MaterialTheme.typography.labelSmall)
            }
            Card(modifier = Modifier.align(Alignment.BottomEnd).padding(horizontal = 8.dp)) {
                Row (modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
                    projectData.playStoreLink?.let {
                        Image(
                            painter = painterResource(Res.drawable.google_play),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp).clickable {
                                uriHandler.openUri(it)
                            }
                        )
                        projectData.githubLink?.let {
                            Spacer(modifier = Modifier.size(8.dp))
                        }
                    }
                    projectData.githubLink?.let {
                        Icon(
                            painter = painterResource(Res.drawable.github_mark),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp).clickable{
                                uriHandler.openUri(it)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Immutable
@Stable
data class ProjectData(
    val title:String,
    val description:String,
    val githubLink:String?,
    val playStoreLink:String?,
    val time:String,
)