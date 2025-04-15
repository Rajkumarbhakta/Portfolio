package com.rkbapps.protfolio.screens.home_new

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.github.panpf.sketch.AsyncImage
import com.rkbapps.protfolio.screens.home_new.composables.CommonHeader
import com.rkbapps.protfolio.screens.home_new.composables.ProfileComposable

@Composable
fun HomeNewScreen (navController: NavHostController){
    Scaffold {
        Row(modifier = Modifier.fillMaxWidth().padding(it).padding(vertical = 8.dp, horizontal = 16.dp)) {
            ProfileComposable(modifier = Modifier.weight(40f))
            Column(modifier = Modifier.fillMaxHeight().weight(60f).verticalScroll(
                rememberScrollState()
            )) {
                CommonHeader(title = "Technologies")
                FlowRow (
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    repeat (20) {
                        KnownTechnologyItem(
                            uri = "https://icon.icepanel.io/Technology/svg/Kotlin.svg",
                            name = "Kotlin"
                        ) {

                        }
                    }
                }
                CommonHeader(title = "Tools")
                FlowRow (
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    repeat( 20) {
                        KnownTechnologyItem(
                            uri = "https://developer.android.com/static/studio/images/android-studio-stable.svg",
                            name = "Android Studio"
                        ) {

                        }
                    }
                }
                CommonHeader(title = "Projects")




            }
        }
    }

}



@Composable
fun KnownTechnologyItem(
    uri:String,
    name:String,
    onClick:()-> Unit
){
    OutlinedCard(
        onClick=onClick
    ) {
        Column(modifier = Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(
                uri = uri,
                contentDescription = name,
                modifier = Modifier.size(50.dp)
            )
            Text(name)
        }
    }
}





