package com.khayrultw.wordpad.ui.presentations.wordDetails.viewModel

import com.khayrultw.wordpad.data.repository.WordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddWordDetailsViewModelImpl @Inject constructor(private val wordRepository: WordRepository) :
    BaseAddEditWordDetailsViewModel(), AddViewWordDetailsViewModel
{
    override val title: String = "Add New Word"
    override fun onSaveButtonClicked() {

    }
}