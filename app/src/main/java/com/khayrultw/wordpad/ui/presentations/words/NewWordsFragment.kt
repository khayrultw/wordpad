package com.khayrultw.wordpad.ui.presentations.words

import androidx.fragment.app.viewModels
import com.khayrultw.wordpad.ui.presentations.words.viewModel.NewWordsViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewWordsFragment : BaseWordsFragment() {
    override val viewModel by viewModels<NewWordsViewModelImpl>()

    companion object {
        val instance = NewWordsFragment()
    }
}