package com.coucouapp.ui.components.introscreen

import android.content.*
import android.os.Bundle
import android.view.*
import com.coucouapp.R
import com.coucouapp.databinding.ActivityIntroductionBinding
import com.coucouapp.ui.base.BaseActivity
import com.coucouapp.ui.components.*
import com.coucouapp.viewmodel.IntroScreenViewModel

class IntroductionActivity : BaseActivity<IntroScreenViewModel, ActivityIntroductionBinding>() , View.OnClickListener {

    override fun getLayout(): Int = R.layout.activity_introduction
    var layoutarray =
        arrayOf(R.layout.intro_screen_one, R.layout.intro_screen_two, R.layout.intro_screen_three)
    lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewPagerAdapter = ViewPagerAdapter(this, layoutarray)
        viewDataBinding.viewPager.adapter = viewPagerAdapter
        viewDataBinding.btSkip.setOnClickListener(this)
    }

    override fun showMsg(msgId: Int) {
        TODO("Not yet implemented")
    }

    override fun showMsg(msg: String) {
        TODO("Not yet implemented")
    }

    override fun getViewModelClass(): Class<IntroScreenViewModel> {
        return IntroScreenViewModel::class.java
    }
    
    override fun onClick(view: View?) {
        when(view!!.id)
        {
            R.id.bt_skip ->
            {
                    val intent = Intent(this , WelcomeActivity::class.java)
                    startActivity(intent)
            }
        }
    }
}