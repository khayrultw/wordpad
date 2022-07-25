package com.khayrultw.wordpad.ui.presentations.home

import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.khayrultw.wordpad.MainActivity
import com.khayrultw.wordpad.R
import com.khayrultw.wordpad.databinding.FragmentHomeBinding
import com.khayrultw.wordpad.ui.adapter.ViewPagerAdapter
import com.khayrultw.wordpad.ui.presentations.base.BaseFragment
import com.khayrultw.wordpad.ui.presentations.words.NewWordsFragment
import com.khayrultw.wordpad.ui.presentations.words.OldWordsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val viewModel: HomeViewModel by viewModels()

    override fun getLayoutResource(): Int = R.layout.fragment_home

    override fun getToolbar(): Toolbar? = null

    override fun onBindData(view: View) {
        super.onBindData(view)
        val adapter = ViewPagerAdapter(listOf(NewWordsFragment.instance, OldWordsFragment.instance), requireActivity() as MainActivity)
        binding?.let {
            it.vpWords.adapter = adapter
            TabLayoutMediator(it.tlWords, it.vpWords) { tab, position ->
                when(position) {
                    0 -> {
                        tab.text = "New Words"
                    }
                    1 -> {
                        tab.text = "Old Word"
                    }
                }
            }
        }
    }
}