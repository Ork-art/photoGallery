package com.ork.photogallery.repository

import com.ork.photogallery.di.api.PhotoGalleryApi
import com.ork.photogallery.model.User
import javax.inject.Inject

class PhotoGalleryRepository @Inject constructor(private val api: PhotoGalleryApi) {
    suspend fun getUnSplashPhoto() = api.getPhotoApi()
}


class UserProfileRepository @Inject constructor(private val userProfileAbout:PhotoGalleryApi){
    suspend fun getUserProfile(userId:String) :User{
        return userProfileAbout.getUserProfile(userId)
    }
}