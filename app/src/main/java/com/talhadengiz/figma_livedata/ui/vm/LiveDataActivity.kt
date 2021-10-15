package com.talhadengiz.figma_livedata.ui.vm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.talhadengiz.figma_livedata.databinding.ActivityLiveDataBinding
import java.util.*

class LiveDataActivity : AppCompatActivity() {

    private lateinit var viewModel: LiveDataActivityVM
    private lateinit var binding: ActivityLiveDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLiveDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[LiveDataActivityVM::class.java]

        observeLiveData()
        initClickListener()
    }

    private fun observeLiveData() {
        viewModel.getCurrentDate()?.observe(this, {
            it.let {
                binding.tvDate.text = it.toString()
            }
        })
    }

    private fun initClickListener() {
        binding.btnShow.setOnClickListener {
            viewModel.getCurrentDate()!!.setValue(Date().toString())
        }
    }

}