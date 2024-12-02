package com.ork.photogallery.di.api

import com.ork.photogallery.model.UnSplashPhotoModel
import com.ork.photogallery.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface PhotoGalleryApi {
    @GET("photos")
    suspend fun getPhotoApi():List<UnSplashPhotoModel>

    @GET("users/{username}")
    suspend fun getUserProfile(
        @Path("username") username: String,
    ): User
}