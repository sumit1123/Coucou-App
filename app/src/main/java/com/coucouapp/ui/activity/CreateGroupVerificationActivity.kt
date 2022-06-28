package com.coucouapp.ui.activity

import android.os.Bundle
import com.coucouapp.R
import com.coucouapp.databinding.ActivityUserVerifiedBinding
import com.coucouapp.ui.base.BaseActivity
import com.coucouapp.utils.Constants
import com.coucouapp.viewmodel.UserVerifiedViewModel
import kotlinx.android.synthetic.main.activity_user_verified.*

class CreateGroupVerificationActivity : BaseActivity<UserVerifiedViewModel, ActivityUserVerifiedBinding>() {

    private val TAG = CreateGroupVerificationActivity::class.simpleName
    private var userVerification = ""
    private var title : String = ""
    private var description : String = ""

    override fun getLayout(): Int = R.layout.activity_user_verified

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_verified)
        title = intent.getStringExtra(Constants.TITLE)!!
        description = intent.getStringExtra(Constants.DESCRIPTION)!!
        initViews()
    }

    private fun initViews() {
        userVerification = intent.getStringExtra(Constants.USER_VERIFICATION).toString()
        setData(title, description)
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