package com.ork.photogallery.mainscreen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.ork.photogallery.model.ImageItemModel
import com.ork.photogallery.model.UnSplashPhotoModel
import com.ork.photogallery.utils.AppRoute

@Composable
fun ImageItem(navController: NavController = rememberNavController(), imageItem: ImageItemModel, size: Int = 5, upSplashPhotoModel: UnSplashPhotoModel) {

    Box(
        modifier = Modifier
            .size(80.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFF5EAD7)),
        contentAlignment = Alignment.Center
    ) {

        if (imageItem.isBlur) {
            AsyncImage(
                model = imageItem.imageUrl,
                contentDescription = "Background Image",

                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .blur(10.dp)
                    .clickable {
                        navController.navigate(AppRoute.Details.route)
                    }
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,

                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
            ) {
                Text(
                    text = "${size}",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge
                )
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Arrow",
                    tint = Color.White,
                    modifier = Modifier
                        .size(24.dp)
                        .padding(start = 4.dp)
                )
            }

        } else {
            AsyncImage(
                model = imageItem.imageUrl,
                contentDescription = "Thumbnail Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }

    }
}
