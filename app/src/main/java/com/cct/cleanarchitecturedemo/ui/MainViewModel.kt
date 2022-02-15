package com.cct.cleanarchitecturedemo.ui

import androidx.lifecycle.*
import com.cct.cleanarchitecturedemo.model.Blog
import com.cct.cleanarchitecturedemo.repository.BlogRepository
import com.cct.cleanarchitecturedemo.util.DataState
import com.cct.cleanarchitecturedemo.util.ViewModelState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val repository: BlogRepository): ViewModel() {
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



}
