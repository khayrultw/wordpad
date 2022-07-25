package com.khayrultw.wordpad.ui.presentations.words

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import com.khayrultw.wordpad.ui.presentations.words.viewModel.NewWordsViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewWordsFragment : BaseWordsFragment() {
    override val viewModel by viewModels<NewWordsViewModelImpl>()

    override fun onBindData(view: View) {
        super.onBindData(view)

        viewModel.navigateToAddWord.asLiveData().observe(viewLifecycleOwner) {
            val action = NewWordsFragmentDirections.actionNavigationMainToAddWord()
            navController.navigate(action)
        }

        viewModel.navigateToWordDetails.asLiveData().observe(viewLifecycleOwner) {
            val action = NewWordsFragmentDirections.actionNavigationMainToViewWord(it)
            navController.navigate(action)
        }
    }
}