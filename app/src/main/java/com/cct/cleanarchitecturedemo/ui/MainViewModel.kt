package com.cct.cleanarchitecturedemo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cct.cleanarchitecturedemo.model.Blog
import com.cct.cleanarchitecturedemo.repository.BlogRepository
import com.cct.cleanarchitecturedemo.util.DataState
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@ViewModelScoped
class MainViewModel @Inject constructor(val repository: BlogRepository): ViewModel() {
    private var _blogs = MutableLiveData< DataState<List<Blog>>>()
    val blogs: LiveData<DataState<List<Blog>>> get() = _blogs

    fun setState(dataState: ViewModelState) {
        viewModelScope.launch {
            when (dataState)
            {
                is ViewModelState.getBlogs ->
                {
                 repository.getBlogs().collect { blogsData->
                     _blogs.value=blogsData
                 }
                }
            }
        }

    }

    sealed class ViewModelState {
        object getBlogs : ViewModelState()
    }

}