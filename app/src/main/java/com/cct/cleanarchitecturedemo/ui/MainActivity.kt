package com.cct.cleanarchitecturedemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cct.cleanarchitecturedemo.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //region variables

    //endregion

    //region events
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //endregion

    //region helper functions

    //endregion
}