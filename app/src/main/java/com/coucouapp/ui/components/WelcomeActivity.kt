package com.coucouapp.ui.components

import android.content.Intent
import android.os.Bundle
import com.coucouapp.R
import com.coucouapp.databinding.ActivityWelcomeBinding
import com.coucouapp.ui.base.BaseActivity
import com.coucouapp.viewmodel.WelcomeViewModel
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : BaseActivity<WelcomeViewModel, ActivityWelcomeBinding>() {

    override fun getLayout(): Int = R.layout.activity_welcome

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        initView()
    }

    private fun initView() {
        tvLogIn.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }

        tvSignUp.setOnClickListener {
            val intent = Intent(this, CreateAccountActivity::class.java)
            startActivity(intent)
        }
    }

    override fun showMsg(msgId: Int) {
        TODO("Not yet implemented")
    }

    override fun showMsg(msg: String) {
        TODO("Not yet implemented")
    }

    override fun getViewModelClass(): Class<WelcomeViewModel> {
        return WelcomeViewModel::class.java
    }
}
