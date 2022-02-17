package com.khayrultw.wordlearner.ui.presentations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.khayrultw.wordlearner.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}