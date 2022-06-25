package com.coucouapp.ui.components

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.coucouapp.R
import com.coucouapp.databinding.ActivityCreateAccountBinding
import com.coucouapp.ui.base.BaseActivity
import com.coucouapp.viewmodel.CreateAccountViewModel
import kotlinx.android.synthetic.main.activity_create_account.*

class CreateAccountActivity : BaseActivity<CreateAccountViewModel, ActivityCreateAccountBinding>(),
    View.OnClickListener {

    private val TAG = CreateAccountActivity::class.simpleName

    override fun getLayout(): Int = R.layout.activity_create_account

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        initViews()
    }

    private fun initViews() {
        tvSignUp.setOnClickListener(this)
        tvAlreadyHaveAccount.setOnClickListener(this)
    }

    private fun isValidate(): Boolean {
        var isValid = true

        if (edEmail.text!!.trim().isEmpty()) {
            tilEmail.error = getString(R.string.msg_empty_email)
            isValid = false
        } else {
            tilEmail.error = null
        }

        if (edPhoneNumber.text!!.trim().isEmpty()) {
            tilPhoneNumber.error = getString(R.string.msg_empty_phone)
            isValid = false
        } else {
            tilPhoneNumber.error = null
        }

        if (edPassword.text!!.trim().isEmpty()) {
            tilPassword.error = getString(R.string.msg_empty_password)
            isValid = false
        } /*else if (edPassword.text!!.length <= 5) {
            tilPassword.error = getString(R.string.error_password_length)
            isValid = false
        } */ else {
            tilPassword.error = null
        }

        if (edConfirmPassword.text!!.trim().isEmpty()) {
            tilConfirmPassword.error = getString(R.string.msg_empty_confirm_password)
            isValid = false
        } else {
            tilConfirmPassword.error = null
        }

        /*if (edPassword.text!!.trim() != edConfirmPassword.text!!.trim()) {
            tvError.visibility = View.VISIBLE
            tvError.text = getString(R.string.msg_password_must_be_same)
            tvError.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_error, 0, 0, 0);
            tvError.compoundDrawablePadding = 8
            isValid = false
        } else {
            tvError.visibility = View.GONE
        }*/

        return isValid
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

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.tvSignUp -> {
                if(isValidate()){
                    val intent = Intent(this, OtpVerificationActivity::class.java)
                    startActivity(intent)
                }
            }
            R.id.tvAlreadyHaveAccount -> {
                val intent = Intent(this, LogInActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}