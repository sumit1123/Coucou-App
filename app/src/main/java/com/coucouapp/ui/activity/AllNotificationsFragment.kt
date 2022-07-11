package com.coucouapp.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.coucouapp.R
import com.coucouapp.databinding.*
import com.coucouapp.ui.activity.DashBoardActivity
import com.coucouapp.ui.adapter.*
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.viewmodel.*

class AllNotificationsFragment : BaseFragment<DashboardViewModel, FragmentAllNotificationsBinding>(){

    lateinit var fragmentAllNotificationsBinding: FragmentAllNotificationsBinding

    override fun getLayout(): Int = R.layout.fragment_all_notifications

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentAllNotificationsBinding = FragmentAllNotificationsBinding.inflate(inflater, container, false)
        return fragmentAllNotificationsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerViews()
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
        fragmentAllNotificationsBinding.recyclerviewAllNotifications.adapter = AllNotificationsAdapter()
       
    }

    override fun getViewModelClass(): Class<DashboardViewModel> {
        return DashboardViewModel::class.java
    }

  }