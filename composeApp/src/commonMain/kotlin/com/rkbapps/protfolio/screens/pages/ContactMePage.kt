package com.rkbapps.protfolio.screens.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rkbapps.protfolio.models.Tabs
import com.rkbapps.protfolio.screens.composables.CommonHeader
import com.rkbapps.protfolio.utils.getWindowSize


@Composable
fun ContactMePage(modifier: Modifier = Modifier) {
    val widthSizeClass = getWindowSize().widthSizeClass
    CommonHeader(
        tab = Tabs.CONTACT_ME,
        widthSizeClass = widthSizeClass
    ) {
        Text("Contact Me")

    }
}