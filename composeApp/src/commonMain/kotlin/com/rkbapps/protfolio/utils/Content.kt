package com.rkbapps.protfolio.utils

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.rkbapps.protfolio.models.KnownTechnology
import com.rkbapps.protfolio.models.Project
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

val projects = listOf(
        Project(
            name = "TooAi",
            drawableResource = Res.drawable.tooai,
            description = "TooAI is a AI based android application that helps you to do Ai tasks withing the device.",
            githubLink = "https://github.com/Rajkumarbhakta/TooAi",
            playStoreLink = "https://play.google.com/store/apps/details?id=com.rkbapps.tooai"
        ),
        Project(
            name = "Physics Galaxy",
            drawableResource = Res.drawable.physics_galaxy,
            description = "A Educational android application with payment and batch functionality.",
            playStoreLink = "https://play.google.com/store/apps/details?id=com.rkbapps.physicsgalaxy"
        ),
        Project(
            name = "G Dealz",
            drawableResource = Res.drawable.g_dealz,
            description = "Get the Best PC Game Deals & Free Games – All in One Ad-Free App! Looking to save money on your favorite PC games? Our app helps you find the best deals, discounts, and free games from all major stores like Steam, Epic Games, GOG, Humble Store, and more—without any annoying ads.",
            playStoreLink = "https://play.google.com/store/apps/details?id=com.rkbapps.gdealz",
            githubLink = "https://github.com/Rajkumarbhakta/GDealz",
        ),
        Project(
            name = "CGPA Calculator - MAKAUT",
            drawableResource = Res.drawable.makut,
            description = "\"CGPA Calculator - MAKAUT\" is a simple application that can help you to calculate all types of grade if you are a MAKAUT student for fill up the Scholarship Applications.",
            playStoreLink = "https://play.google.com/store/apps/details?id=com.rkbapps.makautsgpaygpacalculator"
        ),
        Project(
            name = "Canvas",
            drawableResource = Res.drawable.canvas_logo,
            description = "A simple canvas drawing application using compose multiplatform",
            playStoreLink = "https://play.google.com/store/apps/details?id=com.rkbapps.canvas",
            webLink = "https://me.rkbapps.in/canvas_build",
            githubLink = "https://github.com/Rajkumarbhakta/Canvas"
        ),
        Project(
            name = "Neetflix",
            drawableResource = Res.drawable.neetflix,
            description = "A movie tv series list android application consuming TMDB api. ",
            githubLink = "https://github.com/Rajkumarbhakta/Neetflix",
        ),
        Project(
            name = "Pixy",
            drawableResource = Res.drawable.pixy,
            description = "A wallpaper application consuming unsplash application.",
            githubLink = "https://github.com/Rajkumarbhakta/Pixy",
        ),

        )

val libraries = listOf(Project(
            name = "Nested Menu Bar",
            drawableResource = Res.drawable.dart,
            description = "Nested Menu Bar is a horizontal menu bar for flutter.Based on PlutoMenuBar.",
            githubLink = "https://github.com/Rajkumarbhakta/nested_menu_bar",
            pubDevLink = "https://pub.dev/packages/nested_menu_bar"
        ))

val knownTechnology = listOf(
        KnownTechnology(
            name = "Kotlin",
            image = Res.drawable.kotlin
        ),
        KnownTechnology(
            name = "Java",
            image = Res.drawable.java
        ),
        KnownTechnology(
            name = "Android",
            image = Res.drawable.android
        ),
        KnownTechnology(
            name = "Jetpack Compose",
            image = Res.drawable.jetpack_compose
        ),
        KnownTechnology(
            name = "Compose Multiplatform",
            image = Res.drawable.compose_multiplatform
        ),
        KnownTechnology(
            name = "Kotlin Multiplatform",
            image = Res.drawable.kotlin
        ),
        KnownTechnology(
            name = "Retrofit",
            image = Res.drawable.square_retrofit
        ),
        KnownTechnology(
            name = "Firebase Suite",
            image = Res.drawable.firebase
        ),
        KnownTechnology(
            name = "Spring Boot",
            image = Res.drawable.spring_boot
        ),
        KnownTechnology(
            name = "Dart",
            image = Res.drawable.dart
        ),
        KnownTechnology(
            name = "Flutter",
            image = Res.drawable.flutter
        ),
        KnownTechnology(
            name = "Flutter Bloc",
            image = Res.drawable.bloc
        ),
    )

val knownTools = listOf(
        KnownTechnology(
            name = "Android Studio",
            image = Res.drawable.android_studio
        ),
        KnownTechnology(
            name = "IntelliJ Idea",
            image = Res.drawable.intellij_idea
        ),
        KnownTechnology(
            name = "VS code",
            image = Res.drawable.visual_studio_code
        ),
        KnownTechnology(
            name = "Git",
            image = Res.drawable.git_icon
        ),
        KnownTechnology(
            name = "Github",
            image = Res.drawable.github_mark
        ),
        KnownTechnology(
            name = "Firebase",
            image = Res.drawable.firebase
        ),
    )
