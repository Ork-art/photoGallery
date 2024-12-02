package com.ork.photogallery.navigation

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TopAppBar
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomToolbar(
    title: String,
    onBackButtonClicked: (() -> Unit)? = null
) {
    TopAppBar(
        title = {
            Text(text = title, color = Color.White)
        },
        navigationIcon = onBackButtonClicked?.let {
            {
                IconButton(onClick = it) {
//                    Icon(
//                        imageVector = Icons.Default.ArrowBack, // Back icon
//                        contentDescription = "Back",
//                        tint = Color.White
//                    )
                }
            }
        },
        backgroundColor = Color.Gray,
        contentColor = Color.White,
        elevation = 4.dp,
        modifier = Modifier

    )
}