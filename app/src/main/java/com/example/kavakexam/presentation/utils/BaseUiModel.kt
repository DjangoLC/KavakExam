package com.example.kavakexam.presentation.utils

sealed class BaseUiModel<out T> {
    object Loading : BaseUiModel<Nothing>()
    class Success<T>(val data: T) : BaseUiModel<T>()
    class Error(val error: String) : BaseUiModel<Nothing>()
    class ErrorEx(val data: Exception) : BaseUiModel<Nothing>()

    fun peekContent(): T {
        return if (this is Success) this.data else null as T
    }

}