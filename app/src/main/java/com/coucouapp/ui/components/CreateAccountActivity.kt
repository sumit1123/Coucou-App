package com.coucouapp.ui.components

import android.os.Bundle
import com.coucouapp.R
import com.coucouapp.databinding.ActivityCreateAccountBinding
import com.coucouapp.ui.base.BaseActivity
import com.coucouapp.viewmodel.CreateAccountViewModel

class CreateAccountActivity : BaseActivity<CreateAccountViewModel, ActivityCreateAccountBinding>() {
    override fun getLayout(): Int = R.layout.activity_create_account

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
    }

    override fun showMsg(msgId: Int) {
        TODO("Not yet implemented")
    }

    override fun showMsg(msg: String) {
        TODO("Not yet implemented")
    }

    override fun getViewModelClass(): Class<CreateAccountViewModel> {
        TODO("Not yet implemented")
    }
}