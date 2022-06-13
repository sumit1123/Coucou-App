package com.coucouapp.ui.components

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.coucouapp.R
import com.coucouapp.databinding.ActivitySplashBinding
import com.coucouapp.ui.base.BaseActivity
import com.coucouapp.ui.components.introscreen.*
import com.coucouapp.viewmodel.SplashViewModel

class SplashActivity : BaseActivity<SplashViewModel, ActivitySplashBinding>() {

    override fun getLayout(): Int = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)  
        setScreenNavigation()
    }

    private fun setScreenNavigation() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, IntroductionActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }

    override fun showMsg(msgId: Int) {
        TODO("Not yet implemented")
    }

    override fun showMsg(msg: String) {
        TODO("Not yet implemented")
    }

    override fun getViewModelClass(): Class<SplashViewModel> {
        return SplashViewModel::class.java
    }

}