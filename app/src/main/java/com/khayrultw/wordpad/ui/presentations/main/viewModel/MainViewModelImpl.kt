package com.khayrultw.wordpad.ui.presentations.main.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.khayrultw.wordpad.data.apis.model.Word
import com.khayrultw.wordpad.data.repository.WordRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import com.khayrultw.wordpad.ui.presentations.base.viewModel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModelImpl @Inject constructor(private val wordRepository: WordRepository): MainViewModel, BaseViewModel(){
    private val _words: MutableLiveData<List<Word>> = MutableLiveData()
    override val words: LiveData<List<Word>> = _words

    private val _navigateToAddWord: MutableSharedFlow<Unit> = MutableSharedFlow()
    override val navigateToAddWord: SharedFlow<Unit> = _navigateToAddWord

    private val _navigateToWordDetails: MutableSharedFlow<Int> = MutableSharedFlow()
    override val navigateToWordDetails: SharedFlow<Int> = _navigateToWordDetails

    override fun onCreateView() {
        super.onCreateView()
        getWords()
    }

    private fun getWords() {
        viewModelScope.launch {
            val res = wordRepository.getWords()
            _words.value = res
        }
    }

    override fun onAddButtonClicked() {
        viewModelScope.launch {
            _navigateToAddWord.emit(Unit)
        }
    }

    override fun onItemClicked(id: Int) {
        viewModelScope.launch {
            _navigateToWordDetails.emit(id)
        }
    }

    override fun onRefresh() {
        getWords()
    }
}