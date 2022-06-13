package com.coucouapp.ui.components

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.coucouapp.R
import com.coucouapp.databinding.ActivityLogInBinding
import com.coucouapp.ui.base.BaseActivity
import com.coucouapp.viewmodel.LogInViewModel
import kotlinx.android.synthetic.main.activity_log_in.*

class LogInActivity : BaseActivity<LogInViewModel, ActivityLogInBinding>() {
    private val TAG = LogInActivity::class.simpleName

    override fun getLayout(): Int = R.layout.activity_log_in

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        initViews()
    }

    private fun initViews() {
        tvLoginUser.setOnClickListener {
            isValidate()
        }

        tvForgottenPassword.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isValidate() {
        if (edEmail.text.trim().isEmpty()) {
            showErrorMsg(getString(R.string.msg_empty_email))
            return
        }

        if (edPassword.text.trim().isEmpty()) {
            showErrorMsg(getString(R.string.msg_empty_password))
            return
        }

        tvError.visibility = View.GONE

    }

    private fun showErrorMsg(msg: String) {
        tvError.visibility = View.VISIBLE
        tvError.text = msg
        tvError.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_error, 0, 0, 0);
        tvError.compoundDrawablePadding = 8
    }

    override fun showMsg(msgId: Int) {
        TODO("Not yet implemented")
    }

    override fun showMsg(msg: String) {
        TODO("Not yet implemented")
    }

    override fun getViewModelClass(): Class<LogInViewModel> {
        return LogInViewModel::class.java
    }
}