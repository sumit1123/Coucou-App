package com.coucouapp.ui.activity

import android.graphics.*
import android.os.*
import android.view.*
import androidx.core.content.*
import androidx.recyclerview.widget.*
import com.coucouapp.*
import com.coucouapp.R
import com.coucouapp.databinding.*
import com.coucouapp.ui.adapter.*
import com.coucouapp.ui.base.*
import com.coucouapp.viewmodel.*
import com.google.android.material.snackbar.*
import it.xabaras.android.recyclerview.swipedecorator.*
import java.util.*
import kotlin.math.*


class AllNotificationsFragment :
    BaseFragment<DashboardViewModel, FragmentAllNotificationsBinding>() {
    
    lateinit var fragmentAllNotificationsBinding: FragmentAllNotificationsBinding
    
    override fun getLayout(): Int = R.layout.fragment_all_notifications
    private lateinit var dragHelper: ItemTouchHelper
    private lateinit var swipeHelper: ItemTouchHelper
    lateinit var allNotificationsAdapter: AllNotificationsAdapter
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentAllNotificationsBinding =
            FragmentAllNotificationsBinding.inflate(inflater, container, false)
        return fragmentAllNotificationsBinding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerViews()
        setRightSwipe()
    }
    
    private fun setRightSwipe() {
    
    }
    
    override fun onResume() {
        super.onResume()
        setToolbar()
    }
    
    private fun setToolbar() {
        (activity as DashBoardActivity).setToolbarBackImage(View.VISIBLE, R.color.primary)
        (activity as DashBoardActivity).setToolbarTitle(
            View.VISIBLE,
            R.color.primary,
            getString(R.string.all_notific)
        )
        (activity as DashBoardActivity).setToolbarBackground(R.color.snowGray)
        (activity as DashBoardActivity).setToolbarNotificationIcon(R.color.darkGray, View.VISIBLE)
    }
    
    private fun setRecyclerViews() {
        fragmentAllNotificationsBinding.recyclerviewAllNotifications.layoutManager =
            LinearLayoutManager(requireContext())
        allNotificationsAdapter = AllNotificationsAdapter()
        fragmentAllNotificationsBinding.recyclerviewAllNotifications.adapter = allNotificationsAdapter
        
    }
    
    override fun getViewModelClass(): Class<DashboardViewModel> {
        return DashboardViewModel::class.java
    }
    
}