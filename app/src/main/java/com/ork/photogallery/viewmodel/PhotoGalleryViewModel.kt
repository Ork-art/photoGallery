package com.ork.photogallery.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ork.photogallery.model.UnSplashPhotoModel
import com.ork.photogallery.repository.PhotoGalleryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoGalleryViewModel @Inject constructor( private val repository: PhotoGalleryRepository):ViewModel() {

    private var _state = MutableStateFlow(emptyList<UnSplashPhotoModel>())
    val state: StateFlow<List<UnSplashPhotoModel>>
        get() = _state

   init {
       viewModelScope.launch {
           _state.value = repository.getUnSplashPhoto()
       }

       viewModelScope.launch {

       }
   }



}