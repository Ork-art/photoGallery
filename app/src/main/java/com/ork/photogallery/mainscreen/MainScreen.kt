package com.ork.photogallery.mainscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.ork.photogallery.model.ImageItemModel
import com.ork.photogallery.model.UnSplashPhotoModel
import com.ork.photogallery.viewmodel.PhotoGalleryViewModel

@Composable
fun MainScreen(navController: NavController, viewModel: PhotoGalleryViewModel = hiltViewModel()) {
    val stateList by viewModel.state.collectAsState()
    val imageItemList = arrayListOf<ImageItemModel>()

    if (stateList.size > 3) {
        stateList.take(3).forEach {
            imageItemList.add(ImageItemModel(imageUrl = it.urls.regular, isBlur = false))
        }.also {
            imageItemList.add(ImageItemModel(imageUrl = stateList[2].urls.regular, isBlur = true))
        }
    }

    LazyColumn() {
        items(stateList) { item ->
            UnSplashPhoto(navController, itemUnsplash = item, imageItemsList = imageItemList, itemSize = stateList.size)
        }
    }
}


@Composable
fun UnSplashPhoto(
    navController: NavController,
    itemUnsplash: UnSplashPhotoModel,
    itemSize: Int = 5,
    imageItemsList: ArrayList<ImageItemModel>
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .padding(16.dp)
            .background(Color.Transparent)
    ) {
        Text(
            modifier = Modifier
                .padding(12.dp)
                .background(color = Color.Unspecified),
            text = itemUnsplash.user.name,
            style = MaterialTheme.typography.bodyLarge
        )
        AsyncImage(
            model = itemUnsplash.urls.regular,
            contentDescription = "Main Image from URL",
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.height(12.dp)) // Boşluk ekleme

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
           items(imageItemsList){ imageItem->
               ImageItem(navController, imageItem = imageItem, size = itemSize, itemUnsplash)
           }
        }
    }
}

