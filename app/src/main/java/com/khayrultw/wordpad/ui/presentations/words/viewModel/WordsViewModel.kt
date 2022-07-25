package com.khayrultw.wordpad.ui.presentations.words.viewModel

import androidx.lifecycle.LiveData
import com.khayrultw.wordpad.data.apis.model.Word
import com.khayrultw.wordpad.ui.presentations.base.viewModel.ViewModel
import kotlinx.coroutines.flow.SharedFlow

interface WordsViewModel: ViewModel {
    val words: LiveData<List<Word>>
    val emptyScreen: LiveData<Boolean>
    val navigateToAddWord: SharedFlow<Unit>
    val navigateToWordDetails: SharedFlow<Int>

    fun onRefresh()
    fun onAddButtonClicked()
    fun onItemClicked(id: Int)
}