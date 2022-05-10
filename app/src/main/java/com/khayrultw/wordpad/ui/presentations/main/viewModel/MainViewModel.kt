package com.khayrultw.wordpad.ui.presentations.main.viewModel

import com.khayrultw.wordpad.ui.presentations.base.viewModel.ViewModel
import kotlinx.coroutines.flow.SharedFlow

interface MainViewModel: ViewModel {
    val navigateToAddWord: SharedFlow<Unit>
    val navigateToEditWord: SharedFlow<Unit>

    fun onAddButtonClicked()
}