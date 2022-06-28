package com.coucouapp.ui.activity

import android.content.Intent
import android.os.Bundle
import com.coucouapp.R
import com.coucouapp.databinding.ActivityOtpVerificationBinding
import com.coucouapp.ui.base.BaseActivity
import com.coucouapp.utils.Constants
import com.coucouapp.viewmodel.OtpVerificationViewModel
import kotlinx.android.synthetic.main.activity_otp_verification.*

class OtpVerificationActivity :
    BaseActivity<OtpVerificationViewModel, ActivityOtpVerificationBinding>() {

    private val TAG = OtpVerificationActivity::class.simpleName

    override fun getLayout(): Int = R.layout.activity_otp_verification

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_verification)

        initViews()
    }

    private fun initViews() {
        tvContinue.setOnClickListener {
            val intent = Intent(this, UserVerifiedActivity::class.java)
            intent.putExtra(Constants.USER_VERIFICATION, Constants.FROM_OTP_VERIFICATION)
            startActivity(intent)
        }
    }

    override fun showMsg(msgId: Int) {
        TODO("Not yet implemented")
    }

    override fun showMsg(msg: String) {
        TODO("Not yet implemented")
    }

    override fun getViewModelClass(): Class<OtpVerificationViewModel> {
        return OtpVerificationViewModel::class.java
    }
}