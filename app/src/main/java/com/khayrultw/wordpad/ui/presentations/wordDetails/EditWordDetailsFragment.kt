package com.khayrultw.wordpad.ui.presentations.wordDetails

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.viewModels
import com.khayrultw.wordpad.R
import com.khayrultw.wordpad.databinding.FragmentAddEditWordDetailsBinding
import com.khayrultw.wordpad.ui.presentations.base.BaseFragment
import com.khayrultw.wordpad.ui.presentations.wordDetails.viewModel.EditWordDetailsViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditWordDetailsFragment : BaseFragment<FragmentAddEditWordDetailsBinding>() {

    override val viewModel: EditWordDetailsViewModelImpl by viewModels()

    override fun getLayoutResource(): Int = R.layout.fragment_add_edit_word_details

    override fun getToolbar(): Toolbar? = binding?.appbar?.toolbar

    override fun onBindView(view: View, savedInstanceState: Bundle?) {
        super.onBindView(view, savedInstanceState)

        binding?.viewModel = viewModel
    }
}