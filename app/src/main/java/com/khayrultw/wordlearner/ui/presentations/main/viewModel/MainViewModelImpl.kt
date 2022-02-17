package com.khayrultw.wordlearner.ui.presentations.main.viewModel

import androidx.lifecycle.viewModelScope
import com.khayrultw.wordlearner.data.repository.WordRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import com.khayrultw.wordlearner.ui.presentations.base.viewModel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModelImpl @Inject constructor(private val wordRepository: WordRepository): MainViewModel, BaseViewModel(){
    private val _navigateToFragmentB: MutableSharedFlow<Unit> = MutableSharedFlow()
    override val navigateToFragmentB: SharedFlow<Unit> = _navigateToFragmentB

    override fun onClickButton() {
        viewModelScope.launch {
            _navigateToFragmentB.emit(Unit)
        }
    }
}