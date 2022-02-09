package com.primelab.NearBase.ui.home;

import android.content.Context
import android.content.Intent
import android.os.Bundle;
import com.primelab.NearBase.databinding.ActivityHomeBinding
import com.primelab.NearBase.extensions.viewBinding
import com.primelab.NearBase.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity(){

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }

    private val binding by viewBinding(ActivityHomeBinding::inflate)

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