package com.ork.photogallery.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class Sponsorship(
    val impression_urls: List<String>,
    val sponsor: Sponsor,
    val tagline: String,
    val tagline_url: String
)