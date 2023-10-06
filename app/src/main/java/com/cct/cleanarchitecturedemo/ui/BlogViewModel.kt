package com.cct.cleanarchitecturedemo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cct.cleanarchitecturedemo.domain.models.BlogEntity
import com.cct.cleanarchitecturedemo.domain.usecases.GetBlogsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class BlogViewModel @Inject constructor(private val getBlogsUseCase: GetBlogsUseCase) :
    ViewModel() {

    private var _blogList = MutableLiveData<List<BlogEntity>>()

    val blogList: LiveData<List<BlogEntity>> get() = _blogList

    init {
        getBlogsData()
    }

    private fun getBlogsData() {
        viewModelScope.launch {
            _blogList.postValue(getBlogsUseCase.invoke())
        }
    }


}
