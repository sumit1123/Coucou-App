package com.coucouapp.ui.components

import android.os.Bundle
import android.util.Log
import com.coucouapp.R
import com.coucouapp.databinding.ActivityUserVerifiedBinding
import com.coucouapp.ui.base.BaseActivity
import com.coucouapp.utils.Constants
import com.coucouapp.viewmodel.UserVerifiedViewModel
import kotlinx.android.synthetic.main.activity_user_verified.*

class CreateGroupVerificationActivity : BaseActivity<UserVerifiedViewModel, ActivityUserVerifiedBinding>() {

    private val TAG = CreateGroupVerificationActivity::class.simpleName
    private var userVerification = ""

    override fun getLayout(): Int = R.layout.activity_user_verified

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_verified)
        initViews()
    }

    private fun initViews() {
        userVerification = intent.getStringExtra(Constants.USER_VERIFICATION).toString()
        setData(getString(R.string.create_group), getString(R.string.create_group_description))
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