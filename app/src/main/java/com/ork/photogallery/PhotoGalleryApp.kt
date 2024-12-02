package com.ork.photogallery

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PhotoGalleryApp:Application() {
    override fun onCreate() {
        super.onCreate()
    }
}