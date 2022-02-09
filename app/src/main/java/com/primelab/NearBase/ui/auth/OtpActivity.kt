package com.primelab.NearBase.ui.auth

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.text.Editable
import android.view.KeyEvent
import androidx.activity.viewModels
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import androidx.core.widget.doAfterTextChanged
import com.primelab.NearBase.R
import com.primelab.NearBase.databinding.ActivityOtpBinding
import com.primelab.NearBase.extensions.viewBinding
import com.primelab.NearBase.ui.base.BaseActivity
import com.primelab.NearBase.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OtpActivity : BaseActivity() {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, OtpActivity::class.java)
        }
    }

    private val binding by viewBinding(ActivityOtpBinding::inflate)
    private val userViewModel : UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        listenToViewEvents()

        if (userViewModel.loginType == "email") {
            //binding.sentToMethod.text = getString(R.string.sent_code_email_current)
        } else {
            //binding.sentToMethod.text = getString(R.string.sent_code_phone_current)
        }

    }

    private fun listenToViewEvents() {
    }

    //
    fun AppCompatEditText.setOnFocusCleared(index: Int) {


        this.setOnClickListener {
            it.requestFocus()
        }
        this.doAfterTextChanged {
            it.checkAndHandle(index)
        }
        this.setOnKeyListener { v, keyCode, event ->
            if (event.keyCode == KeyEvent.KEYCODE_DEL) {
                if (getEditText(index).text?.isNotEmpty() == true) {
                    getEditText(index).text?.clear()
                    getEditText(index).requestFocus()
                } else {
                    if (index != 0) {
                        getEditText(index -1).requestFocus()
                    }
                }
                true
            } else {
                false
            }

        }
    }


    private fun Editable?.checkAndHandle(index: Int) {
        if (!this.isNullOrEmpty()) {

            if (index < 5) {
                getEditText(index + 1).requestFocus()
            } else {
                getEditText(5).clearFocus()

            }
        }

        if (index == 5) {
            /*binding.btnContinue.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(
                    this@OtpActivity,
                    if (this.isNullOrBlank()) R.color.btndisabled_color else R.color.dark_blue
                )
            )*/
        }
    }

    private fun getEditText(index: Int): AppCompatEditText {
        return when (index) {
            0 -> {
                binding.edt1
            }
            1 -> {
                binding.edt2
            }
            2 -> {
                binding.edt3
            }
            3 -> {
                binding.edt4
            }
            4 -> {
                binding.edt5
            }
            5 -> {
                binding.edt6
            }


            else -> {
                binding.edt6
            }
        }
    }
}