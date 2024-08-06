package com.rkbapps.protfolio.screens.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rkbapps.protfolio.models.Tabs

@Composable
fun AboutMePage(modifier: Modifier = Modifier) {
    Column {
        Text(Tabs.ABOUT_ME.title)
    }
}