package com.khayrultw.wordpad.ui.presentations.wordDetails.viewModel

import com.khayrultw.wordpad.data.repository.WordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewWordDetailsViewModelImpl @Inject constructor(private val wordRepository: WordRepository) :
    BaseWordDetailsViewModel(), ViewWordDetailsViewModel {

}