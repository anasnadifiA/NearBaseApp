package com.primelab.NearBase.ui.base

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.primelab.NearBase.R
import com.primelab.NearBase.util.AlertDialogUtil

open class BaseActivity : AppCompatActivity() {

    private var progressDialog: AlertDialog? = null

    fun showProgressDialog(){
        if(progressDialog == null){
            progressDialog = AlertDialogUtil.getAndShowProgressDialog(this, false)
        } else {
            progressDialog?.show()
        }
    }

    fun dismissProgressDialog(){
        progressDialog?.dismiss()
        progressDialog = null
    }

}