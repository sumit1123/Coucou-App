package com.coucouapp.ui.components

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.coucouapp.R
import com.coucouapp.databinding.ActivityLogInBinding
import com.coucouapp.ui.base.BaseActivity
import com.coucouapp.ui.components.dashboard.DashBoardScreen
import com.coucouapp.viewmodel.LogInViewModel
import kotlinx.android.synthetic.main.activity_log_in.*

class LogInActivity : BaseActivity<LogInViewModel, ActivityLogInBinding>(), View.OnClickListener {
    private val TAG = LogInActivity::class.simpleName

    override fun getLayout(): Int = R.layout.activity_log_in

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        tvLoginUser.setOnClickListener(this)
        tvForgottenPassword.setOnClickListener(this)
    }

    private fun isValidate(): Boolean {
        var isValid = true

        if (edEmail.text!!.trim().isEmpty()) {
            tilEmail.error = getString(R.string.msg_empty_email)
            isValid = false
        } else {
            tilEmail.error = null
        }

        if (edPassword.text!!.trim().isEmpty()) {
            tilPassword.error = getString(R.string.msg_empty_password)
            isValid = false
        } else {
            tilPassword.error = null
        }

        return isValid
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

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.tvLoginUser -> {
                if (isValidate()) {
                    val intent = Intent(this, DashBoardScreen::class.java)
                    startActivity(intent)
                }
            }
            R.id.tvForgottenPassword -> {
                val intent = Intent(this, ForgotPasswordActivity::class.java)
                startActivity(intent)
            }
        }
    }
}