package com.coucouapp.ui.components

import android.os.Bundle
import com.coucouapp.R
import com.coucouapp.databinding.ActivityUserVerifiedBinding
import com.coucouapp.ui.base.BaseActivity
import com.coucouapp.viewmodel.UserVerifiedViewModel

class UserVerifiedActivity : BaseActivity<UserVerifiedViewModel, ActivityUserVerifiedBinding>() {

    private val TAG = UserVerifiedActivity::class.simpleName

    override fun getLayout(): Int = R.layout.activity_user_verified

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_verified)
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