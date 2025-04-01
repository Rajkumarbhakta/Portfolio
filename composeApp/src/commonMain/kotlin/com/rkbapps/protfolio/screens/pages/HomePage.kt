package com.rkbapps.protfolio.screens.pages

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.rkbapps.protfolio.theme.LocalThemeIsDark
import com.rkbapps.protfolio.utils.getWindowSize
import kotlinx.coroutines.isActive
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import protfolio.composeapp.generated.resources.IndieFlower_Regular
import protfolio.composeapp.generated.resources.Res
import protfolio.composeapp.generated.resources.hello_there
import protfolio.composeapp.generated.resources.ic_cyclone
import protfolio.composeapp.generated.resources.ic_dark_mode
import protfolio.composeapp.generated.resources.ic_light_mode
import protfolio.composeapp.generated.resources.name
import protfolio.composeapp.generated.resources.open_github
import protfolio.composeapp.generated.resources.theme

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun HomePage() {
    val widthSizeClass = getWindowSize().widthSizeClass
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var isRotating by remember { mutableStateOf(false) }

        val rotate = remember { Animatable(0f) }
        val target = 360f
        if (isRotating) {
            LaunchedEffect(Unit) {
                while (isActive) {
                    val remaining = (target - rotate.value) / target
                    rotate.animateTo(target, animationSpec = tween((1_000 * remaining).toInt(), easing = LinearEasing))
                    rotate.snapTo(0f)
                }
            }
        }

        if (widthSizeClass!= WindowWidthSizeClass.Compact){
            Row(modifier = Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.Center) {
                Box(){
                    Image(
                        modifier = Modifier
                            .size(250.dp)
                            .padding(16.dp)
                            .run { rotate(rotate.value) }
                            .clickable {
                                isRotating = !isRotating
                            },
                        imageVector = vectorResource(Res.drawable.ic_cyclone),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                        contentDescription = null
                    )
                }
                Column() {
                    Text(stringResource(Res.string.hello_there))
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = stringResource(Res.string.name),
                        fontFamily = FontFamily(Font(Res.font.IndieFlower_Regular)),
                        style = MaterialTheme.typography.displayLarge
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text("Android | Kotlin | Java | Flutter",style = MaterialTheme.typography.titleMedium)
                }
            }
        }else{
            Column(modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Box(){
                    Image(
                        modifier = Modifier
                            .size(250.dp)
                            .padding(16.dp)
                            .run { rotate(rotate.value) }
                            .clickable {
                                isRotating = !isRotating
                            },
                        imageVector = vectorResource(Res.drawable.ic_cyclone),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                        contentDescription = null
                    )
                }
                Text(stringResource(Res.string.hello_there))
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = stringResource(Res.string.name),
                    fontFamily = FontFamily(Font(Res.font.IndieFlower_Regular)),
                    style = if (widthSizeClass!= WindowWidthSizeClass.Compact)MaterialTheme.typography.displayLarge else MaterialTheme.typography.displayMedium
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text("Android | Kotlin | Java | Flutter",style = MaterialTheme.typography.titleMedium)
            }
        }

        var isDark by LocalThemeIsDark.current
        val icon = remember(isDark) {
            if (isDark) Res.drawable.ic_light_mode
            else Res.drawable.ic_dark_mode
        }

        OutlinedButton(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp).widthIn(min = 200.dp),
            onClick = { isDark = !isDark },
            content = {
                Icon(vectorResource(icon), contentDescription = null)
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(stringResource(Res.string.theme))
            }
        )

        val uriHandler = LocalUriHandler.current
        OutlinedButton(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp).widthIn(min = 200.dp),
            onClick = { uriHandler.openUri("https://github.com/Rajkumarbhakta") },
        ) {
            Text(stringResource(Res.string.open_github))
        }
    }
}