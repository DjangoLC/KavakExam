package com.example.kavakexam.presentation.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kavakexam.core.usescase.gnome.GetGnomes
import com.example.kavakexam.presentation.gnome.list.GnomeViewModel
import kotlinx.coroutines.CoroutineDispatcher
import java.lang.Exception
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val getGnomes: GetGnomes,
    private val uiDispatcher: CoroutineDispatcher
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(GnomeViewModel::class.java)) {
            return GnomeViewModel(getGnomes, uiDispatcher) as T
        }

        return Exception("class is not supported") as T

    }


}