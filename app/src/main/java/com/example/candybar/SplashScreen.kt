package com.example.candybar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.databinding.DataBindingUtil
import com.example.candybar.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    private lateinit var binding:ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding=DataBindingUtil.setContentView(this,R.layout.activity_splash_screen)

        Handler().postDelayed({
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        },2000)
    }
}