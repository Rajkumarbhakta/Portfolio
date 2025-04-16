package com.rkbapps.protfolio.models

import org.jetbrains.compose.resources.DrawableResource

data class Project(
    val name:String,
    val image:String?=null,
    val drawableResource: DrawableResource?=null,
    val description:String,
    val playStoreLink:String?=null,
    val githubLink:String? = null,
    val pubDevLink:String? = null
)