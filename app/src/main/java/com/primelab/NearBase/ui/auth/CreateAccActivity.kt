package com.primelab.NearBase.ui.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.primelab.NearBase.databinding.ActivityLoginBinding
import com.primelab.NearBase.extensions.viewBinding
import com.primelab.NearBase.ui.base.BaseActivity
import com.primelab.NearBase.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateAccActivity : BaseActivity() {


    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, CreateAccActivity::class.java)
        }
    }

    private val binding by viewBinding(ActivityLoginBinding::inflate)
    private val userViewModel : UserViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViews()
        listenToViewEvents()
    }

    private fun initViews(){
    }

    private fun listenToViewEvents() {
    }

}