package com.khayrultw.wordpad.ui.presentations.word.add.viewModel

import androidx.lifecycle.viewModelScope
import com.khayrultw.wordpad.data.apis.model.Word
import com.khayrultw.wordpad.data.repository.WordRepository
import com.khayrultw.wordpad.ui.presentations.word.base.viewModel.BaseAddEditWordViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddWordViewModelImpl @Inject constructor(private val wordRepository: WordRepository) :
    BaseAddEditWordViewModel(), AddWordViewModel {
    override val title: String = "Add New Word"

    override fun onSaveButtonClicked() {
        viewModelScope.launch {
            val word = Word(
                null,
                wordTitle.value ?: "",
                wordMeaning.value ?: "",
                wordDetails.value ?: "",
                "new",
                0L
            )
            wordRepository.insertWord(word)
            _finish.emit(Unit)
        }
    }
}