package com.cct.cleanarchitecturedemo.util

sealed class DataState<out R> {
    object Loading : DataState<Nothing>()
    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val exceptionMessage:String):DataState<Nothing>()
}