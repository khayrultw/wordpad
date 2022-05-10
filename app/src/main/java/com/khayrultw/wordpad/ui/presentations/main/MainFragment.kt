package com.khayrultw.wordpad.ui.presentations.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.khayrultw.wordpad.R
import com.khayrultw.wordpad.data.apis.model.Word
import com.khayrultw.wordpad.databinding.FragmentMainBinding
import com.khayrultw.wordpad.ui.adapter.WordsAdapter
import com.khayrultw.wordpad.ui.presentations.base.BaseFragment
import com.khayrultw.wordpad.ui.presentations.main.viewModel.MainViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>() {
    override val viewModel by viewModels<MainViewModelImpl>()

    override fun getLayoutResource(): Int = R.layout.fragment_main

    override fun getToolbar(): Toolbar? = null

    override fun onBindView(view: View, savedInstanceState: Bundle?) {
        super.onBindView(view, savedInstanceState)
        binding?.viewModel = viewModel
        setupAdapter()
    }

    override fun onBindData(view: View) {
        super.onBindData(view)
        viewModel.navigateToAddWord.asLiveData().observe(viewLifecycleOwner) {
            val action = MainFragmentDirections.actionFragmentMainToFragmentB()
            navController.navigate(action)
        }
    }

    private fun setupAdapter() {
        val adapter = WordsAdapter(listOf(
            Word(null, "hello", "hello", " ", 0L),
            Word(null, "hello", "hello", " ", 0L),
            Word(null, "hello", "hello", " ", 0L)))
        val layoutManager = LinearLayoutManager(requireContext())
        binding?.rvWords?.layoutManager = layoutManager
        adapter.listener = object: WordsAdapter.Listener {
            override fun onItemClicked() {

            }
        }
        binding?.rvWords?.adapter = adapter
    }
}