package com.khayrultw.wordlearner.ui.presentations.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.khayrultw.wordlearner.ui.presentations.base.viewModel.ViewModel

abstract class BaseFragment<T: ViewDataBinding>: Fragment() {
    protected lateinit var navController: NavController
    protected abstract val viewModel: ViewModel
    protected var binding: T? = null

    abstract fun getLayoutResource(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launchWhenResumed {
            viewModel.onCreateView()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutResource(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onFragmentResult()
        onBindView(view, savedInstanceState)
        onBindData(view)
    }

    protected open fun onFragmentResult() {}

    protected open fun onBindView(view: View, savedInstanceState: Bundle?) {
        navController = NavHostFragment.findNavController(this)
        binding = DataBindingUtil.bind(view)
        binding?.lifecycleOwner = this
    }

    protected open fun onBindData(view: View) {}
}