package com.primelab.NearBase.ui.splash

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.primelab.NearBase.R
import com.primelab.NearBase.extensions.startNewActivityWithDefaultAnimation
import com.primelab.NearBase.ui.auth.CreateAccActivity
import com.primelab.NearBase.ui.home.HomeActivity
import com.primelab.NearBase.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private val userViewModel : UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if(!userViewModel.loggedIn){
            startNewActivityWithDefaultAnimation(CreateAccActivity.getIntent(this))
        }else{
            startNewActivityWithDefaultAnimation(HomeActivity.getIntent(this))
        }

    }
}