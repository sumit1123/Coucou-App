package com.coucouapp.ui.components.dashboard

import android.os.*
import androidx.navigation.*
import androidx.navigation.ui.*
import com.coucouapp.*
import com.coucouapp.R
import com.coucouapp.databinding.*
import com.coucouapp.ui.base.*
import com.coucouapp.ui.components.dashboard.viewmodel.*


class DashBoardScreen : BaseActivity<DashboardViewModel,ActivityDashboardScreenBinding>() {
    
    override fun getLayout(): Int = R.layout.activity_dashboard_screen
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpFragmentNavigation()
        
    }
    
    private fun setUpFragmentNavigation() {
        val navController: NavController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(viewDataBinding.activityMainBottomNavigationView, navController);
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