package com.khayrultw.wordpad.ui.presentations.wordDetails.viewModel

import androidx.lifecycle.MutableLiveData
import com.khayrultw.wordpad.ui.presentations.base.viewModel.BaseViewModel

abstract class BaseWordDetailsViewModel(): BaseViewModel(), WordDetailsViewModel {
    override val wordTitle: MutableLiveData<String> = MutableLiveData()
    override val wordMeanings: MutableLiveData<String> = MutableLiveData()
    override val wordDescription: MutableLiveData<String> = MutableLiveData()
}