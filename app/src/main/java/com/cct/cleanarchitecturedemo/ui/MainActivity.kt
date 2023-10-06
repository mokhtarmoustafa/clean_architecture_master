package com.cct.cleanarchitecturedemo.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.cct.cleanarchitecturedemo.databinding.ActivityMainBinding
import com.cct.cleanarchitecturedemo.domain.models.BlogEntity
import com.cct.cleanarchitecturedemo.util.DataState
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
            viewModel.blogList.observe(this@MainActivity) { result ->
                when (result) {
                    is DataState.Loading -> {
                        binding.tvData.text="Loading...."
                    }
                    is DataState.Success -> getBlogs(result)
                    is DataState.Error -> { binding.tvData.text=result.exceptionMessage}
                }
            }
        }
    }

    private fun getBlogs(result: DataState.Success<List<BlogEntity>>) {
        val builder = StringBuilder()
        result.data.map {
            builder.appendLine(it.title)
        }
        binding.tvData.text = builder.toString()
    }


    //endregion

    companion object {
        private const val TAG = "MainActivity"
    }
}