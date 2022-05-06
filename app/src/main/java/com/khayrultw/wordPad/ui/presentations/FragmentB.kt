package com.khayrultw.wordPad.ui.presentations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.khayrultw.wordPad.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentB : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }
}