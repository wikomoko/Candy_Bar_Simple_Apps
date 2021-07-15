package com.example.candybar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.candybar.databinding.ActivitySuccessPageBinding

class successPage : AppCompatActivity() {
    private lateinit var binding:ActivitySuccessPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_success_page)

        binding.btnFinish.setOnClickListener { finishAffinity() }
    }
}