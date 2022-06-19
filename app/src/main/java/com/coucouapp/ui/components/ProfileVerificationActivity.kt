package com.coucouapp.ui.components

import android.os.Bundle
import com.coucouapp.R
import com.coucouapp.databinding.ActivityProfileVerificationBinding
import com.coucouapp.ui.base.BaseActivity
import com.coucouapp.viewmodel.ProfileVerificationViewModel

class ProfileVerificationActivity : BaseActivity<ProfileVerificationViewModel, ActivityProfileVerificationBinding>() {
    private val TAG = ProfileVerificationActivity::class.simpleName

    override fun getLayout(): Int = R.layout.activity_profile_verification
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_verification)
    }

    override fun showMsg(msgId: Int) {
        TODO("Not yet implemented")
    }

    override fun showMsg(msg: String) {
        TODO("Not yet implemented")
    }

    override fun getViewModelClass(): Class<ProfileVerificationViewModel> {
        return ProfileVerificationViewModel::class.java

    }
}