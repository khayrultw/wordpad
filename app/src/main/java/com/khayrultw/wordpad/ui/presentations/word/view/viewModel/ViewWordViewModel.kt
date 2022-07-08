package com.khayrultw.wordpad.ui.presentations.word.view.viewModel

import com.khayrultw.wordpad.ui.presentations.word.base.viewModel.WordViewModel
import kotlinx.coroutines.flow.SharedFlow

interface ViewWordViewModel: WordViewModel {
    val navigateToEditWord: SharedFlow<Int>

    fun onStatusChanged()
    fun onEditClicked()
    fun onDeleteClicked()
    fun onRefresh()
}