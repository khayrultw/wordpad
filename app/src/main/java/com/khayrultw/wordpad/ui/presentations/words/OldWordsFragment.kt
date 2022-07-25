package com.khayrultw.wordpad.ui.presentations.words

import androidx.fragment.app.viewModels
import com.khayrultw.wordpad.ui.presentations.words.viewModel.OldWordsViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OldWordsFragment : BaseWordsFragment() {
    override val viewModel: OldWordsViewModelImpl by viewModels()

    companion object {
        val instance = OldWordsFragment()
    }
}