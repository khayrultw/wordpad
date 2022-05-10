package com.khayrultw.wordpad.ui.presentations.wordDetails.viewModel

import com.khayrultw.wordpad.data.repository.WordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EditWordDetailsViewModelImpl @Inject constructor(private val wordRepository: WordRepository) :
    BaseAddEditWordDetailsViewModel(), AddViewWordDetailsViewModel
{
    override val title: String = "Update Word"

    override fun onSaveButtonClicked() {

    }
}