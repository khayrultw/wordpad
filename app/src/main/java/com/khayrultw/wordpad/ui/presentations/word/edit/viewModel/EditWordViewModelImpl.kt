package com.khayrultw.wordpad.ui.presentations.word.edit.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.khayrultw.wordpad.data.apis.model.Word
import com.khayrultw.wordpad.data.repository.WordRepository
import com.khayrultw.wordpad.ui.constants.ExtraCodes
import com.khayrultw.wordpad.ui.presentations.word.add.viewModel.AddWordViewModel
import com.khayrultw.wordpad.ui.presentations.word.base.viewModel.BaseAddEditWordViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditWordViewModelImpl @Inject constructor(private val wordRepository: WordRepository, private val savedStateHandle: SavedStateHandle) :
    BaseAddEditWordViewModel(), AddWordViewModel
{
    private val id: Int = savedStateHandle.get<Int>(ExtraCodes.EXTRA_ID) ?: -1
    override val title: String = "Update Word"

    override fun onCreateView() {
        super.onCreateView()
        viewModelScope.launch {
            val word = wordRepository.getWordById(id)
            word?.let {
                wordTitle.value = it.title
                wordMeaning.value = it.meaning
                wordDetails.value = it.details
            }
        }
    }

    override fun onSaveButtonClicked() {
        viewModelScope.launch {
            val word = Word(
                id,
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