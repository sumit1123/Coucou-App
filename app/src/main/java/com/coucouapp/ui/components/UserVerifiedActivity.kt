package com.coucouapp.ui.components

import android.os.Bundle
import android.util.Log
import com.coucouapp.R
import com.coucouapp.databinding.ActivityUserVerifiedBinding
import com.coucouapp.ui.base.BaseActivity
import com.coucouapp.utils.Constants
import com.coucouapp.viewmodel.UserVerifiedViewModel
import kotlinx.android.synthetic.main.activity_user_verified.*

class UserVerifiedActivity : BaseActivity<UserVerifiedViewModel, ActivityUserVerifiedBinding>() {

    private val TAG = UserVerifiedActivity::class.simpleName
    private var userVerification = ""

    override fun getLayout(): Int = R.layout.activity_user_verified

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_verified)

        initViews()
    }

    private fun initViews() {
        userVerification = intent.getStringExtra(Constants.USER_VERIFICATION).toString()
        if (userVerification == Constants.FROM_OTP_VERIFICATION) {
            setData(getString(R.string.user_verified), getString(R.string.user_verified_details))
        } else if (userVerification == Constants.FROM_RESET_PASSWORD) {
            setData(
                getString(R.string.password_changed_successfully),
                getString(R.string.password_changed_successfully_details)
            )
        }
        Log.e(TAG, userVerification)
    }

    private fun setData(text: String, details: String) {
        tvUserVerified.text = text
        tvUserVerifiedDetails.text = details
    }

    override fun showMsg(msgId: Int) {
        TODO("Not yet implemented")
    }

    override fun showMsg(msg: String) {
        TODO("Not yet implemented")
    }

    override fun getViewModelClass(): Class<UserVerifiedViewModel> {
        return UserVerifiedViewModel::class.java
    }
}