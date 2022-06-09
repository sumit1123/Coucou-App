package com.coucouapp.ui.components

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.coucouapp.R
import com.coucouapp.databinding.ActivityCreateAccountBinding
import com.coucouapp.ui.base.BaseActivity
import com.coucouapp.viewmodel.CreateAccountViewModel
import kotlinx.android.synthetic.main.activity_create_account.*

class CreateAccountActivity : BaseActivity<CreateAccountViewModel, ActivityCreateAccountBinding>() {

    private val TAG = CreateAccountActivity::class.simpleName

    override fun getLayout(): Int = R.layout.activity_create_account

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        initViews()
    }

    private fun initViews() {
        tvSignUp.setOnClickListener {
            //isValidate()  //TODO: Remove Comment
            val intent = Intent(this, OtpVerificationActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isValidate() {
        if (edUsername.text.trim().isEmpty()) {
            showErrorMsg(getString(R.string.msg_empty_name))
            return
        }
        if (edEmail.text.trim().isEmpty()) {
            showErrorMsg(getString(R.string.msg_empty_email))
            return
        }
        if (edPhoneNumber.text.trim().isEmpty()) {
            showErrorMsg(getString(R.string.msg_empty_phone))
            return
        }
        if (edPassword.text.trim().isEmpty()) {
            showErrorMsg(getString(R.string.msg_empty_password))
            return
        }
        if (edConfirmPassword.text.trim().isEmpty()) {
            showErrorMsg(getString(R.string.msg_empty_confirm_password))
            return
        }
        if (edPassword.text.trim() != edConfirmPassword.text.trim()) {
            showErrorMsg(getString(R.string.msg_password_must_be_same))
            return
        }

        tvError.visibility = View.GONE

        val intent = Intent(this, OtpVerificationActivity::class.java)
        startActivity(intent)
        finish()
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

    override fun getViewModelClass(): Class<CreateAccountViewModel> {
        return CreateAccountViewModel::class.java
    }
}