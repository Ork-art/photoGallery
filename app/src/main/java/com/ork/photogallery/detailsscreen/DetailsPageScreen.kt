package com.ork.photogallery.detailsscreen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ork.photogallery.model.UnSplashPhotoModel
import com.ork.photogallery.model.User
import com.ork.photogallery.viewmodel.PhotoGalleryViewModel
import com.ork.photogallery.viewmodel.UserProfileViewModel
import kotlin.math.log


@SuppressLint("RememberReturnType")
@Composable
fun DetailsPageScreen(navController: NavController = rememberNavController(), viewModel: UserProfileViewModel = hiltViewModel()){
    val userProfile = viewModel.userProfile.collectAsState().value
    val errorMessage = viewModel.errorMessage.collectAsState().value
    remember { viewModel.fetchUserProfile("username") }
    when {
        userProfile != null -> {
            // Display user profile data
            UserProfile(userProfile)
        }
        errorMessage != null -> {
            // Display error message
          //  Text(text = "Error: $errorMessage")
        }
        else -> {
            CircularProgressIndicator()
        }
    }

}

@Composable
fun UserProfile(userProfile: User) {

    Log.d("userprofile", "UserProfile: $userProfile")

    Column {



    }

}