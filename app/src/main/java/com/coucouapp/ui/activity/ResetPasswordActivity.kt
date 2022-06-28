package com.coucouapp.ui.activity

import android.content.Intent
import android.os.Bundle
import com.coucouapp.R
import com.coucouapp.databinding.ActivityResetPasswordBinding
import com.coucouapp.ui.base.BaseActivity
import com.coucouapp.utils.Constants
import com.coucouapp.viewmodel.ResetPasswordViewModel
import kotlinx.android.synthetic.main.activity_reset_password.*

class ResetPasswordActivity  :
    BaseActivity<ResetPasswordViewModel, ActivityResetPasswordBinding>() {
    private val TAG = ResetPasswordActivity::class.simpleName

    override fun getLayout(): Int = R.layout.activity_reset_password

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        initViews()
    }

    private fun initViews() {
        tvResetUserPassword.setOnClickListener {
            val intent = Intent(this, UserVerifiedActivity::class.java)
            intent.putExtra(Constants.USER_VERIFICATION, Constants.FROM_RESET_PASSWORD)
            startActivity(intent)
        }
    }

    override fun showMsg(msgId: Int) {
        TODO("Not yet implemented")
    }

    override fun showMsg(msg: String) {
        TODO("Not yet implemented")
    }

    override fun getViewModelClass(): Class<ResetPasswordViewModel> {
        return ResetPasswordViewModel::class.java
    }
}