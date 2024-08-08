package com.rkbapps.protfolio.screens


import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import cafe.adriel.voyager.core.screen.Screen
import com.rkbapps.protfolio.models.Tabs
import com.rkbapps.protfolio.screens.pages.*
import com.rkbapps.protfolio.theme.LocalThemeIsDark
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import protfolio.composeapp.generated.resources.Res
import protfolio.composeapp.generated.resources.ic_dark_mode
import protfolio.composeapp.generated.resources.ic_light_mode
import protfolio.composeapp.generated.resources.theme


class HomeScreen :Screen {

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3WindowSizeClassApi::class)
    @Composable
    override fun Content() {
        val widthSizeClass = calculateWindowSizeClass().widthSizeClass
        val isDialogOpen = rememberSaveable() {
            mutableStateOf(false)
        }

        val tabs = remember{
            mutableStateListOf(Tabs.HOME,Tabs.ABOUT_ME,Tabs.EDUCATION,Tabs.PROJECTS,Tabs.CONTACT_ME)
        }
        val selectedTab = rememberSaveable{
            mutableStateOf(Tabs.HOME.title)
        }

        Scaffold (topBar = {
            TopAppBar(
                title = {
                    Text("Portfolio")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        isDialogOpen.value = !isDialogOpen.value
                    }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                    }
                },
                actions = {
                    if (widthSizeClass!=WindowWidthSizeClass.Compact){
                        tabs.forEach {
                            TopBarActionButtons(it.title, isSelected = selectedTab.value == it.title){
                                selectedTab.value = it.title
                            }
                        }
                    }
                    var isDark by LocalThemeIsDark.current
                    val icon = remember(isDark) {
                        if (isDark) Res.drawable.ic_light_mode
                        else Res.drawable.ic_dark_mode
                    }
                    IconButton(
                        //modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp).widthIn(min = 200.dp),
                        onClick = { isDark = !isDark },
                        content = {
                            Icon(vectorResource(icon), contentDescription = null)
                        }
                    )
                }
            )
        }){innerPadding ->
            Box(modifier = Modifier.fillMaxSize()
                .windowInsetsPadding(WindowInsets.safeDrawing)
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 8.dp)
            ){
                when(selectedTab.value){
                    Tabs.HOME.title -> HomePage()
                    Tabs.ABOUT_ME.title -> AboutMePage()
                    Tabs.EDUCATION.title -> EducationPage()
                    Tabs.PROJECTS.title -> ProjectsPage()
                    Tabs.CONTACT_ME.title -> ContactMePage()
                }
            }

            if (isDialogOpen.value){
                Dialog(onDismissRequest = {isDialogOpen.value = false}){
                    ElevatedCard(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                        Box(modifier = Modifier.fillMaxWidth().padding(16.dp)){
                            IconButton(
                                modifier = Modifier.align(Alignment.TopEnd),
                                onClick = {
                                    isDialogOpen.value = false
                                }){
                                Icon(imageVector = Icons.Default.Close, contentDescription = null,)
                            }

                            Column (modifier = Modifier.fillMaxWidth().padding(top = 50.dp)){
                                tabs.forEach {
                                    DialogButton(it.title, isSelected = selectedTab.value == it.title){
                                        selectedTab.value = it.title
                                        isDialogOpen.value = false
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    @Composable
    fun TopBarActionButtons(title: String, isSelected: Boolean = false, onClick: () -> Unit) {
        Box(Modifier.padding(4.dp), contentAlignment = Alignment.Center) {
            if (isSelected) {
                Button(onClick = onClick) {
                    Text(title)
                }
            } else {
                TextButton(onClick = onClick) {
                    Text(title)
                }
            }
        }
    }


    @Composable
    fun DialogButton(title:String,isSelected: Boolean=false, onClick: () -> Unit) {
        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = animateColorAsState(targetValue = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface,animationSpec = tween(300)).value,
                containerColor =animateColorAsState(targetValue = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,animationSpec = tween(300)).value ,
            ),
            onClick = onClick){
            Text(title)
        }
    }

}