package com.khayrultw.wordpad.ui.presentations.word.base.viewModel

import androidx.lifecycle.MutableLiveData
import com.khayrultw.wordpad.ui.presentations.base.viewModel.BaseViewModel

abstract class BaseWordViewModel(): BaseViewModel(), WordViewModel {
    override val wordTitle: MutableLiveData<String> = MutableLiveData()
    override val wordMeaning: MutableLiveData<String> = MutableLiveData()
    override val wordDetails: MutableLiveData<String> = MutableLiveData()
}