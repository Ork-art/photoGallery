package com.ork.photogallery.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LinksX(
    val followers: String,
    val following: String,
    val html: String,
    val likes: String,
    val photos: String,
    val portfolio: String,
    val self: String
):Parcelable