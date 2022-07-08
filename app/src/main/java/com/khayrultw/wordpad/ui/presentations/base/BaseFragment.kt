package com.khayrultw.wordpad.ui.presentations.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.khayrultw.wordpad.R
import com.khayrultw.wordpad.ui.presentations.base.viewModel.ViewModel

abstract class BaseFragment<T: ViewDataBinding>: Fragment() {
    protected lateinit var navController: NavController
    protected abstract val viewModel: ViewModel
    private lateinit var appBarConfiguration: AppBarConfiguration
    protected var binding: T? = null

    abstract fun getLayoutResource(): Int

    abstract fun getToolbar(): Toolbar?

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
        appBarConfiguration = AppBarConfiguration(navController.graph)
        binding = DataBindingUtil.bind(view)
        binding?.lifecycleOwner = this

        getToolbar()?.setupWithNavController(navController, appBarConfiguration)
        getToolbar()?.setNavigationIcon(R.drawable.ic_back)
        getToolbar()?.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    protected open fun onBindData(view: View) {}

    protected fun navigateBack() {
        val successful = navController.popBackStack()
        if (!successful) {
            requireActivity().finish()
        }
    }
}