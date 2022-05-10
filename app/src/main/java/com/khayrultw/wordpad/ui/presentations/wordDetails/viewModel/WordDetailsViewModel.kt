package com.khayrultw.wordpad.ui.presentations.wordDetails.viewModel

import androidx.lifecycle.MutableLiveData
import com.khayrultw.wordpad.ui.presentations.base.viewModel.ViewModel

interface WordDetailsViewModel: ViewModel {
    val wordTitle: MutableLiveData<String>
    val wordMeanings: MutableLiveData<String>
    val wordDescription: MutableLiveData<String>
}