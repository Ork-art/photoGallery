package com.ork.photogallery.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class Social(
    val instagram_username: String,
    val paypal_email: Any,
    val portfolio_url: String,
    val twitter_username: String
)