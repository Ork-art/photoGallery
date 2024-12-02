package com.ork.photogallery.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ork.photogallery.model.UnSplashPhotoModel
import com.ork.photogallery.model.User
import com.ork.photogallery.repository.UserProfileRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class UserProfileViewModel @Inject constructor(private val repository: UserProfileRepository): ViewModel(){

    private val _userProfile = MutableStateFlow<User?>(null)
    val userProfile: StateFlow<User?> get() = _userProfile

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> get() = _errorMessage

    fun fetchUserProfile(userId: String) {
        viewModelScope.launch {
            try {
                _userProfile.value = repository.getUserProfile("username")
            } catch (e: Exception) {
                _errorMessage.value = e.message
            }
        }
    }
}