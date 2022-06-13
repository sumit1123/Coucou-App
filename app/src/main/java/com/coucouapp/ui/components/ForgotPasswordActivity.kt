package com.coucouapp.ui.components

import android.content.Intent
import android.os.Bundle
import com.coucouapp.R
import com.coucouapp.databinding.ActivityForgotPasswordBinding
import com.coucouapp.ui.base.BaseActivity
import com.coucouapp.viewmodel.ForgotPasswordViewModel
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPasswordActivity :
    BaseActivity<ForgotPasswordViewModel, ActivityForgotPasswordBinding>() {
    private val TAG = ForgotPasswordActivity::class.simpleName

    override fun getLayout(): Int = R.layout.activity_forgot_password

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        initViews()
    }

    private fun initViews() {
        tvSend.setOnClickListener {
            val intent = Intent(this, ResetPasswordActivity::class.java)
            startActivity(intent)
        }
    }

    override fun showMsg(msgId: Int) {
        TODO("Not yet implemented")
    }

    override fun showMsg(msg: String) {
        TODO("Not yet implemented")
    }

    override fun getViewModelClass(): Class<ForgotPasswordViewModel> {
        return ForgotPasswordViewModel::class.java

    }
}