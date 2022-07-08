package com.khayrultw.wordpad.ui.presentations.word.view.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.khayrultw.wordpad.data.repository.WordRepository
import com.khayrultw.wordpad.ui.constants.ExtraCodes
import com.khayrultw.wordpad.ui.presentations.word.base.viewModel.BaseWordViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewWordViewModelImpl @Inject constructor(
    private val wordRepository: WordRepository,
    private val savedStateHandle: SavedStateHandle
) :
    BaseWordViewModel(), ViewWordViewModel {
    private val id: Int = savedStateHandle.get<Int>(ExtraCodes.EXTRA_ID) ?: -1
    override val title: String = "Word Details"

    private val _navigateToEditWord: MutableSharedFlow<Int> = MutableSharedFlow()
    override val navigateToEditWord: SharedFlow<Int> = _navigateToEditWord

    override fun onCreateView() {
        super.onCreateView()
        getWord()
    }

    private fun getWord() {
        viewModelScope.launch {
            val word = wordRepository.getWordById(id)
            word?.let {
                wordTitle.value = it.title
                wordMeaning.value = it.meaning
                wordDetails.value = it.details
            }
        }
    }

    override fun onStatusChanged() {

    }

    override fun onEditClicked() {
        viewModelScope.launch {
            _navigateToEditWord.emit(id)
        }
    }

    override fun onDeleteClicked() {

    }

    override fun onRefresh() {
        getWord()
    }
}