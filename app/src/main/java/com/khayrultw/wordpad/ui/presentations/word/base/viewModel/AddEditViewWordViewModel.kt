package com.khayrultw.wordpad.ui.presentations.word.base.viewModel

import kotlinx.coroutines.flow.SharedFlow

interface AddEditViewWordViewModel: WordViewModel {
    val finish: SharedFlow<Unit>

    fun onSaveButtonClicked()
}