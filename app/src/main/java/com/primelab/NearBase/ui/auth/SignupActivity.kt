package com.primelab.NearBase.ui.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.primelab.NearBase.databinding.ActivitySignupBinding
import com.primelab.NearBase.ui.base.BaseActivity
import com.primelab.NearBase.viewmodel.UserViewModel
import com.primelab.NearBase.extensions.viewBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SignupActivity : BaseActivity() {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, SignupActivity::class.java)
        }
    }

    private val binding by viewBinding(ActivitySignupBinding::inflate)

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