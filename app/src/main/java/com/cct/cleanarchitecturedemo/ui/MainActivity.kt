package com.cct.cleanarchitecturedemo.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.cct.cleanarchitecturedemo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //region variables
    private lateinit var binding: ActivityMainBinding
    //endregion

    //region events
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        init()

    }


    //endregion

    //region helper functions
    private fun init() {

    }


    //endregion

    companion object {
        private const val TAG = "MainActivity"
    }
}