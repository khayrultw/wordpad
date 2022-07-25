package com.khayrultw.wordpad.ui.presentations.words.viewModel

import com.khayrultw.wordpad.data.repository.WordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewWordsViewModelImpl @Inject constructor(wordRepository: WordRepository): NewWordsViewModel, BaseWordsViewModel(wordRepository){

}