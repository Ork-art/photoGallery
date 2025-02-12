package com.ork.photogallery.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class UnSplashPhotoModel(
    val alt_description: String,
    val alternative_slugs: AlternativeSlugs,
    val asset_type: String,
    val blur_hash: String,
    val breadcrumbs: List<Any?>,
    val color: String,
    val created_at: String,
    val current_user_collections: List<Any?>,
    val description: Any,
    val height: Int,
    val id: String,
    val liked_by_user: Boolean,
    val likes: Int,
    val links: Links,
    val promoted_at: Any,
    val slug: String,
    val sponsorship: Sponsorship,
    val topic_submissions: TopicSubmissions,
    val updated_at: String,
    val urls: Urls,
    val user: User,
    val width: Int
)