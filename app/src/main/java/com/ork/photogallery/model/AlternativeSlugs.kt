package com.ork.photogallery.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AlternativeSlugs(
    val de: String,
    val en: String,
    val es: String,
    val fr: String,
    val `it`: String,
    val ja: String,
    val ko: String,
    val pt: String
):Parcelable