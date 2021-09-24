package com.lcw.kt.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.lcw.kt.api.UnsplashRepository
import com.lcw.kt.api.UnsplashService
import com.lcw.kt.api.unsplash.UnsplashPhoto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: UnsplashRepository
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text


    private var currentQueryValue: String? = null
    private var currentSearchResult: Flow<PagingData<UnsplashPhoto>>? = null

    fun searchPictures(queryString: String): Flow<PagingData<UnsplashPhoto>> {
        currentQueryValue = queryString
        val newResult: Flow<PagingData<UnsplashPhoto>> =
            repository.getSearchResultStream(queryString).cachedIn(viewModelScope)
        currentSearchResult = newResult
        return newResult
    }
}