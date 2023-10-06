package com.cct.cleanarchitecturedemo.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.cct.cleanarchitecturedemo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //region variables
    private lateinit var binding: ActivityMainBinding
    private val viewModel: BlogViewModel by viewModels()
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
        lifecycleScope.launch {
            viewModel.blogList.observe(this@MainActivity,  {result->
                when(result)
                {

                }
            })
        }
    }


    //endregion

    companion object {
        private const val TAG = "MainActivity"
    }
}