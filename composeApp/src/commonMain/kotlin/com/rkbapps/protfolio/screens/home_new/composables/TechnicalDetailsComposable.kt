package com.rkbapps.protfolio.screens.home_new.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.rkbapps.protfolio.models.KnownTechnology
import com.rkbapps.protfolio.models.Project
import com.rkbapps.protfolio.utils.knownTechnology
import com.rkbapps.protfolio.utils.knownTools
import com.rkbapps.protfolio.utils.libraries
import com.rkbapps.protfolio.utils.projects
import protfolio.composeapp.generated.resources.Res
import protfolio.composeapp.generated.resources.android
import protfolio.composeapp.generated.resources.android_studio
import protfolio.composeapp.generated.resources.bloc
import protfolio.composeapp.generated.resources.canvas_logo
import protfolio.composeapp.generated.resources.compose_multiplatform
import protfolio.composeapp.generated.resources.dart
import protfolio.composeapp.generated.resources.firebase
import protfolio.composeapp.generated.resources.flutter
import protfolio.composeapp.generated.resources.g_dealz
import protfolio.composeapp.generated.resources.git_icon
import protfolio.composeapp.generated.resources.github_mark
import protfolio.composeapp.generated.resources.intellij_idea
import protfolio.composeapp.generated.resources.java
import protfolio.composeapp.generated.resources.jetpack_compose
import protfolio.composeapp.generated.resources.kotlin
import protfolio.composeapp.generated.resources.makut
import protfolio.composeapp.generated.resources.neetflix
import protfolio.composeapp.generated.resources.physics_galaxy
import protfolio.composeapp.generated.resources.pixy
import protfolio.composeapp.generated.resources.spring_boot
import protfolio.composeapp.generated.resources.square_retrofit
import protfolio.composeapp.generated.resources.tooai
import protfolio.composeapp.generated.resources.visual_studio_code


@Composable
fun TechnicalDetailsComposable(
    modifier: Modifier = Modifier
) {

    val projects = remember { projects }
    val libraries = remember { libraries }
    val knownTechnology = remember { knownTechnology }
    val knownTools = remember { knownTools }


    Column(modifier = modifier) {
        CommonHeader(title = "Technologies")
        FlowRow(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            knownTechnology.forEach {
                KnownTechnologyItem(
                    image = it.image,
                    name = it.name
                ) {}
            }
        }
        CommonHeader(title = "Tools")
        FlowRow(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            knownTools.forEach {
                KnownTechnologyItem(
                    image = it.image,
                    name = it.name,
                    colorFilter = if (it.name == "Github") ColorFilter.tint(MaterialTheme.colorScheme.onSurface) else null
                ) {}
            }
        }
        CommonHeader(title = "Projects")

        FlowRow(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            projects.forEach {
                ProjectItem(project = it) {}
            }
        }
        CommonHeader(title = "Libraries")
        FlowRow(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            libraries.forEach {
                ProjectItem(project = it) {

                }
            }
        }

    }

}