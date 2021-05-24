package com.example.kavakexam.presentation.gnome.list

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kavakexam.core.data.Resource
import com.example.kavakexam.core.domain.Gnome
import com.example.kavakexam.core.usescase.gnome.GetGnomes
import com.example.kavakexam.presentation.utils.BaseUiModel
import com.example.kavakexam.presentation.utils.Event
import com.example.kavakexam.presentation.utils.ScopedViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

class GnomeViewModel @ViewModelInject constructor(
    val getGnomes: GetGnomes,
    override val uiDispatcher: CoroutineDispatcher
) : ScopedViewModel(uiDispatcher) {

    private val _gnomes = MutableLiveData<Event<BaseUiModel<List<Gnome>>>>()
    val gnomes: LiveData<Event<BaseUiModel<List<Gnome>>>>
        get() = _gnomes

    fun getGnomes() {

        _gnomes.value = Event(BaseUiModel.Loading)

        launch {

            _gnomes.value = when (val result = getGnomes.invoke()) {
                is Resource.Success -> Event(BaseUiModel.Success(result.value))
                is Resource.ErrorBody -> Event(BaseUiModel.Error(result.errorBody))
                is Resource.ErrorException -> Event(BaseUiModel.ErrorEx(result.exception))
            }

        }

    }

}