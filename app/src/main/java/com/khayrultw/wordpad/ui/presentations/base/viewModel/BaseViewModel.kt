package com.khayrultw.wordpad.ui.presentations.base.viewModel

abstract class BaseViewModel: ViewModel, androidx.lifecycle.ViewModel() {
    override val title: String = "Word Pad"

    override fun onCreateView() {}
}