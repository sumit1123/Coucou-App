package com.coucouapp.ui.components.introscreen

import android.os.Bundle
import com.coucouapp.R
import com.coucouapp.databinding.ActivityIntroductionBinding
import com.coucouapp.ui.base.BaseActivity
import com.coucouapp.viewmodel.IntroScreenViewModel
import kotlinx.android.synthetic.main.activity_introduction.*

class IntroductionActivity : BaseActivity<IntroScreenViewModel, ActivityIntroductionBinding>() {

    override fun getLayout(): Int = R.layout.activity_introduction
    var layoutarray = arrayOf(R.layout.intro_screen_one , R.layout.intro_screen_two , R.layout.intro_screen_three)
    lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewPagerAdapter = ViewPagerAdapter(this , layoutarray)
        viewDataBinding.viewPager.adapter = viewPagerAdapter
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
}