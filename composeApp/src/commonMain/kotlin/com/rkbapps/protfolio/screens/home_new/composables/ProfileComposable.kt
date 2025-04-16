package com.rkbapps.protfolio.screens.home_new.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.vectorResource
import protfolio.composeapp.generated.resources.Res
import protfolio.composeapp.generated.resources.android
import protfolio.composeapp.generated.resources.android_studio
import protfolio.composeapp.generated.resources.github_mark
import protfolio.composeapp.generated.resources.google_play_outlined
import protfolio.composeapp.generated.resources.ic_cyclone
import protfolio.composeapp.generated.resources.instagram
import protfolio.composeapp.generated.resources.linkdin
import protfolio.composeapp.generated.resources.my_image

@Composable
fun ProfileComposable(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(vertical = 8.dp, horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Image(
            painter = painterResource(Res.drawable.my_image),
            contentDescription = "Profile Image",
            modifier = Modifier.size(180.dp).clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Text(
            text = "Rajkumar Bhakta",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold)
        )

        Text(
            text = "Rajkumar Bhakta is an enthusiastic Android developer with a deep passion for creating innovative and user-friendly mobile applications. His dedication to mastering the Android platform and staying up-to-date with the latest technologies drives his work, making him a valuable contributor to the ever-evolving world of mobile development. Rajkumar's commitment to excellence is evident in every project he undertakes, as he strives to deliver high-quality, impactful solutions that meet user needs and exceed expectations."
            ,color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.SemiBold),
            textAlign = TextAlign.Justify
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val uriHandler = LocalUriHandler.current
            SocialItems(icon = vectorResource(Res.drawable.github_mark)){
                uriHandler.openUri("https://github.com/Rajkumarbhakta")
            }
            SocialItems(icon = vectorResource(Res.drawable.linkdin)){
                uriHandler.openUri("https://www.linkedin.com/in/rajkumar-bhakta")
            }
            SocialItems(icon = vectorResource(Res.drawable.google_play_outlined)){
                uriHandler.openUri("https://play.google.com/store/apps/dev?id=8595458926248803860")
            }
            SocialItems(icon = vectorResource(Res.drawable.instagram)){
                uriHandler.openUri("https://www.instagram.com/rkbapps/")
            }
        }

    }
}

@Composable
fun SocialItems(icon: ImageVector, colorIcon: Boolean=false, onClick: () -> Unit){
    Card(
        onClick = onClick,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        if (colorIcon){
            Image(
                imageVector = icon,
                contentDescription = "Social Icon",
                modifier = Modifier.padding(8.dp).size(24.dp)
            )
        }else{
            Icon(
                imageVector = icon,
                contentDescription = "Social Icon",
                modifier = Modifier.padding(8.dp).size(24.dp)
            )
        }
    }
}