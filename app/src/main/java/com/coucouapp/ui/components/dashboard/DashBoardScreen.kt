package com.coucouapp.ui.components.dashboard

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.coucouapp.R
import com.coucouapp.databinding.ActivityDashboardScreenBinding
import com.coucouapp.ui.base.BaseActivity
import com.coucouapp.ui.components.dashboard.viewmodel.DashboardViewModel
import kotlinx.android.synthetic.main.activity_dashboard_screen.*
import kotlinx.android.synthetic.main.toolbar.view.*


class DashBoardScreen : BaseActivity<DashboardViewModel, ActivityDashboardScreenBinding>() {

    override fun getLayout(): Int = R.layout.activity_dashboard_screen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
    }

    private fun initView() {
        setUpFragmentNavigation()
    }

    fun setToolbarBackImage(visibility: Int, color: Int) {
        dashboardToolbar.ivToolbarBack.visibility = visibility
        DrawableCompat.setTint(
            DrawableCompat.wrap(dashboardToolbar.ivToolbarBack.drawable),
            ContextCompat.getColor(this, color)
        )
    }

    fun setToolbarTitle(visibility: Int, color: Int, title: String) {
        dashboardToolbar.tvToolbarTitle.text = title
        dashboardToolbar.tvToolbarTitle.visibility = visibility
        dashboardToolbar.tvToolbarTitle.setTextColor(ContextCompat.getColor(this, color))
    }

    fun setToolbarBackground(color: Int) {
        dashboardToolbar.toolbar.setBackgroundResource(color)
    }

    fun setToolbarNotificationIcon(color: Int, visibility: Int){
        dashboardToolbar.ivNotification.visibility = visibility
        DrawableCompat.setTint(
            DrawableCompat.wrap(dashboardToolbar.ivNotification.drawable),
            ContextCompat.getColor(this, color)
        )
    }

    private fun setUpFragmentNavigation() {
        val navController: NavController =
            Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(
            viewDataBinding.activityMainBottomNavigationView,
            navController
        )
    }

    override fun showMsg(msgId: Int) {
        TODO("Not yet implemented")
    }

    override fun showMsg(msg: String) {
        TODO("Not yet implemented")
    }

    override fun getViewModelClass(): Class<DashboardViewModel> {
        return DashboardViewModel::class.java
    }
}