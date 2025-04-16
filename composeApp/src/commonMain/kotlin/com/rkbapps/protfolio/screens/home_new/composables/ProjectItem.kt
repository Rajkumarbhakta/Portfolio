package com.rkbapps.protfolio.screens.home_new.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.github.panpf.sketch.AsyncImage
import com.rkbapps.protfolio.models.Project
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.vectorResource
import protfolio.composeapp.generated.resources.Res
import protfolio.composeapp.generated.resources.dart
import protfolio.composeapp.generated.resources.github_mark
import protfolio.composeapp.generated.resources.google_play
import protfolio.composeapp.generated.resources.web

@Composable
fun ProjectItem(
    project: Project,
    onClick: () -> Unit
) {
    OutlinedCard(
        modifier = Modifier.widthIn(max = 200.dp),
        onClick = onClick,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            if (project.drawableResource != null) {
                Image(
                    painter = painterResource(project.drawableResource),
                    contentDescription = project.name,
                    modifier = Modifier.size(width = 200.dp, height = 150.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(color = Color.White),

                    contentScale = ContentScale.Crop
                )
            } else {
                AsyncImage(
                    uri = project.image,
                    contentDescription = project.name,
                    modifier = Modifier.size(width = 200.dp, height = 150.dp)
                        .background(color = Color.White)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                project.name,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                ),
                maxLines = 1, overflow = TextOverflow.Ellipsis
            )
            Text(
                project.description,
                maxLines = 2,
                style = MaterialTheme.typography.titleSmall,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                val uriHandler = LocalUriHandler.current
                project.playStoreLink?.let {
                    SocialItems(icon = vectorResource(Res.drawable.google_play), colorIcon = true) {
                        uriHandler.openUri(it)
                    }
                }
                project.webLink?.let {
                    SocialItems(icon = vectorResource(Res.drawable.web), colorIcon = false) {
                        uriHandler.openUri(it)
                    }
                }
                project.githubLink?.let {
                    SocialItems(
                        icon = vectorResource(Res.drawable.github_mark),
                        colorIcon = false
                    ) {
                        uriHandler.openUri(it)
                    }
                }
                project.pubDevLink?.let {
                    SocialItems(icon = vectorResource(Res.drawable.dart), colorIcon = true) {
                        uriHandler.openUri(it)
                    }
                }
            }
        }
    }
}