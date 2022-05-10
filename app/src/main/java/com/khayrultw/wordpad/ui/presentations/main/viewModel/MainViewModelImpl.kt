package com.khayrultw.wordpad.ui.presentations.main.viewModel

import androidx.lifecycle.viewModelScope
import com.khayrultw.wordpad.data.repository.WordRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import com.khayrultw.wordpad.ui.presentations.base.viewModel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModelImpl @Inject constructor(private val wordRepository: WordRepository): MainViewModel, BaseViewModel(){
    private val _navigateToAddWord: MutableSharedFlow<Unit> = MutableSharedFlow()
    override val navigateToAddWord: SharedFlow<Unit> = _navigateToAddWord

    private val _navigateToEditWord: MutableSharedFlow<Unit> = MutableSharedFlow()
    override val navigateToEditWord: SharedFlow<Unit> = _navigateToEditWord

    override fun onAddButtonClicked() {
        viewModelScope.launch {
            _navigateToAddWord.emit(Unit)
        }
    }
}