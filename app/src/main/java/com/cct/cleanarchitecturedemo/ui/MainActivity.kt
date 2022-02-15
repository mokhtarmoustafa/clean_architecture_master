package com.cct.cleanarchitecturedemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cct.cleanarchitecturedemo.databinding.ActivityMainBinding
import com.cct.cleanarchitecturedemo.model.Blog
import com.cct.cleanarchitecturedemo.util.DataState
import com.cct.cleanarchitecturedemo.util.ViewModelState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //region variables
    private  val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    //endregion

    //region events
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        viewModel.setState(ViewModelState.getBlogs)
        getBlogs()

    }

    //endregion

    //region helper functions
    private fun getBlogs() {
        viewModel.blogs.observe(this, Observer { dataState ->
            when (dataState) {
                is DataState.Success<List<Blog>> -> {
                    showProgress(false)
                    getData(dataState.data)
                }
                is DataState.Error -> {
                    showProgress(false)
                    showErrorMessage(dataState.exceptionMessage as String)
                }
                is DataState.Loading -> {
                    showProgress(true)
                }
            }
        })
    }

    private fun getData(data: List<Blog>) {
        val builder = StringBuilder()
        data.let { blogs ->
            if (blogs.isNotEmpty()) {
                blogs.forEach { builder.appendLine(it.title) }
            }
            binding.tvData.text = builder.toString()
        }
    }

    private fun showErrorMessage(message: String) {
        binding.tvData.text = message
    }

    private fun showProgress(show: Boolean) {
        binding.progress.visibility = if (show) View.VISIBLE else View.INVISIBLE
    }
    //endregion

    companion object {
        private const val TAG = "MainActivity"
    }
}