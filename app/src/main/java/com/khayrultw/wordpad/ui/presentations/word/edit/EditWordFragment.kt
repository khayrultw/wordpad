package com.khayrultw.wordpad.ui.presentations.word.edit

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import com.khayrultw.wordpad.R
import com.khayrultw.wordpad.databinding.FragmentAddEditWordBinding
import com.khayrultw.wordpad.ui.constants.ExtraCodes
import com.khayrultw.wordpad.ui.constants.RequestCodes
import com.khayrultw.wordpad.ui.presentations.base.BaseFragment
import com.khayrultw.wordpad.ui.presentations.word.edit.viewModel.EditWordViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditWordFragment : BaseFragment<FragmentAddEditWordBinding>() {

    override val viewModel: EditWordViewModelImpl by viewModels()

    override fun getLayoutResource(): Int = R.layout.fragment_add_edit_word

    override fun getToolbar(): Toolbar? = binding?.appbar?.toolbar

    override fun onBindView(view: View, savedInstanceState: Bundle?) {
        super.onBindView(view, savedInstanceState)

        binding?.viewModel = viewModel
    }

    override fun onBindData(view: View) {
        super.onBindData(view)

        viewModel.finish.asLiveData().observe(viewLifecycleOwner) {
            val bundle = Bundle()
            bundle.putBoolean(ExtraCodes.EXTRA_REFRESH, true)
            setFragmentResult(RequestCodes.EDIT_WORD_FINISH, bundle)
            navigateBack()
        }
    }
}