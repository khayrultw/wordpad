package com.khayrultw.wordpad.ui.presentations.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.khayrultw.wordpad.R
import com.khayrultw.wordpad.data.apis.model.Word
import com.khayrultw.wordpad.databinding.FragmentMainBinding
import com.khayrultw.wordpad.ui.adapter.WordsAdapter
import com.khayrultw.wordpad.ui.constants.ExtraCodes
import com.khayrultw.wordpad.ui.constants.RequestCodes
import com.khayrultw.wordpad.ui.presentations.base.BaseFragment
import com.khayrultw.wordpad.ui.presentations.main.viewModel.MainViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>() {
    override val viewModel by viewModels<MainViewModelImpl>()
    private lateinit var adapter: WordsAdapter

    override fun getLayoutResource(): Int = R.layout.fragment_main

    override fun getToolbar(): Toolbar? = null

    override fun onBindView(view: View, savedInstanceState: Bundle?) {
        super.onBindView(view, savedInstanceState)
        binding?.viewModel = viewModel
        setupAdapter()
    }

    override fun onBindData(view: View) {
        super.onBindData(view)

        viewModel.words.observe(viewLifecycleOwner) {
            adapter.setModels(it)
        }

        viewModel.navigateToAddWord.asLiveData().observe(viewLifecycleOwner) {
            val action = MainFragmentDirections.actionNavigationMainToAddWord()
            navController.navigate(action)
        }

        viewModel.navigateToWordDetails.asLiveData().observe(viewLifecycleOwner) {
            val action = MainFragmentDirections.actionNavigationMainToViewWord(it)
            navController.navigate(action)
        }
    }

    private fun setupAdapter() {
        adapter = WordsAdapter(listOf())
        val layoutManager = LinearLayoutManager(requireContext())
        binding?.rvWords?.layoutManager = layoutManager
        adapter.listener = object: WordsAdapter.Listener {
            override fun onItemClicked(id: Int) {
                viewModel.onItemClicked(id)
            }
        }
        binding?.rvWords?.adapter = adapter
    }

    override fun onFragmentResult() {
        super.onFragmentResult()

        setFragmentResultListener(RequestCodes.ADD_WORD_FINISH) { _, bundle ->
            val result = bundle.getBoolean(ExtraCodes.EXTRA_REFRESH)
            if(result) {
                viewModel.onRefresh()
            }
        }
    }
}