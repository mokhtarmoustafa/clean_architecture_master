package com.cct.cleanarchitecturedemo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cct.cleanarchitecturedemo.domain.models.BlogEntity
import com.cct.cleanarchitecturedemo.domain.usecases.GetBlogsUseCase
import com.cct.cleanarchitecturedemo.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject


@HiltViewModel
class BlogViewModel @Inject constructor(private val getBlogsUseCase: GetBlogsUseCase) :
    ViewModel() {

    private var _blogList = MutableLiveData<DataState<List<BlogEntity>>>()

    val blogList: LiveData<DataState<List<BlogEntity>>> get() = _blogList

     init {
        getBlogsData()
    }

    private fun getBlogsData() {
        viewModelScope.launch {
            _blogList.postValue(DataState.Loading)
            try {
                _blogList.postValue(DataState.Success(getBlogsUseCase.invoke()))
            }
            catch (ex:Exception)
            {
                _blogList.postValue(DataState.Error(ex.message!!))
            }
        }
    }


}
