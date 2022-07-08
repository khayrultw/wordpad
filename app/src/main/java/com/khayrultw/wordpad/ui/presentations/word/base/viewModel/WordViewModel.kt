package com.khayrultw.wordpad.ui.presentations.word.base.viewModel

import androidx.lifecycle.MutableLiveData
import com.khayrultw.wordpad.ui.presentations.base.viewModel.ViewModel

interface WordViewModel: ViewModel {
    val wordTitle: MutableLiveData<String>
    val wordMeaning: MutableLiveData<String>
    val wordSynonym: MutableLiveData<String>
    val wordDetails: MutableLiveData<String>
}