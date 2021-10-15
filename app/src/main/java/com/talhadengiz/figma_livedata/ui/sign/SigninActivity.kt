package com.talhadengiz.figma_livedata.ui.sign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.talhadengiz.figma_livedata.R
import com.talhadengiz.figma_livedata.databinding.ActivitySigninBinding
import com.talhadengiz.figma_livedata.removeStatus
import com.talhadengiz.figma_livedata.showDialog
import com.talhadengiz.figma_livedata.ui.home.HomeActivity

class SigninActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySigninBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Hidden status bar
        removeStatus(this)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickListener()

        showDialog(
            getString(R.string.selam_dostum),
            getString(R.string.sign_to_home),
            this
        )
    }

    private fun initClickListener() {
        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}