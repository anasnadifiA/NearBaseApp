package com.primelab.NearBase.ui.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.primelab.NearBase.R
import com.primelab.NearBase.databinding.ActivityLoginBinding
import com.primelab.NearBase.extensions.viewBinding
import com.primelab.NearBase.ui.base.BaseActivity
import com.primelab.NearBase.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint





@AndroidEntryPoint
class LoginActivity : BaseActivity() {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
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

    private fun login() {

    }

    override fun onBackPressed() {
        startActivity(CreateAccActivity.getIntent(this))
        overridePendingTransition(R.anim.nav_default_enter_anim, R.anim.nav_default_exit_anim)    }
}