package com.coucouapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.coucouapp.R
import com.coucouapp.databinding.FragmentPublicGroupBinding
import com.coucouapp.ui.activity.DashBoardActivity
import com.coucouapp.ui.adapter.PublicGroupAdapter
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.viewmodel.DashboardViewModel

class PublicGroupFragment : BaseFragment<DashboardViewModel, FragmentPublicGroupBinding>() {
    lateinit var publicGroupBinding: FragmentPublicGroupBinding

    override fun getLayout(): Int = R.layout.fragment_public_group

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        publicGroupBinding = FragmentPublicGroupBinding.inflate(inflater, container, false)
        setRecyclerViews()
        return publicGroupBinding.root
    }

    override fun onResume() {
        super.onResume()
        setToolbar()
    }

    private fun setToolbar() {
        (activity as DashBoardActivity).setToolbarBackImage(View.VISIBLE, R.color.primary)
        (activity as DashBoardActivity).setToolbarTitle(
            View.VISIBLE,
            R.color.darkGray,
            getString(R.string.public_group)
        )
        (activity as DashBoardActivity).setToolbarBackground(R.color.snowGray)
        (activity as DashBoardActivity).setToolbarNotificationIcon(R.color.darkGray, View.VISIBLE)
    }

    private fun setRecyclerViews() {
        publicGroupBinding.recyclerviewPublicGroup.layoutManager =
            LinearLayoutManager(requireContext())
        publicGroupBinding.recyclerviewPublicGroup.adapter = PublicGroupAdapter()
    }

    override fun getViewModelClass(): Class<DashboardViewModel> {
        return DashboardViewModel::class.java
    }

}