package com.khayrultw.wordpad.ui.presentations.word.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import com.khayrultw.wordpad.R
import com.khayrultw.wordpad.databinding.FragmentViewWordBinding
import com.khayrultw.wordpad.ui.constants.ExtraCodes
import com.khayrultw.wordpad.ui.constants.RequestCodes
import com.khayrultw.wordpad.ui.presentations.base.BaseFragment
import com.khayrultw.wordpad.ui.presentations.word.view.viewModel.ViewWordViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ViewWordFragment : BaseFragment<FragmentViewWordBinding>() {

    override val viewModel: ViewWordViewModelImpl by viewModels()

    override fun getLayoutResource(): Int = R.layout.fragment_view_word

    override fun getToolbar(): Toolbar? = binding?.appbar?.toolbar

    override fun onBindView(view: View, savedInstanceState: Bundle?) {
        super.onBindView(view, savedInstanceState)

        binding?.viewModel = viewModel
    }

    override fun onBindData(view: View) {
        super.onBindData(view)

        viewModel.navigateToEditWord.asLiveData().observe(viewLifecycleOwner) {
            val action = ViewWordFragmentDirections.actionNavigationViewWordToEditWord(it)
            navController.navigate(action)
        }
    }

    override fun onFragmentResult() {
        super.onFragmentResult()

        setFragmentResultListener(RequestCodes.EDIT_WORD_FINISH) { _, bundle ->
            val result = bundle.getBoolean(ExtraCodes.EXTRA_REFRESH)
            if(result) {
                viewModel.onRefresh()
            }
        }
    }
}