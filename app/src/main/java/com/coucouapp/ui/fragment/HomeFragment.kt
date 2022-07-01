package com.coucouapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.coucouapp.R
import com.coucouapp.databinding.FragmentHomeBinding
import com.coucouapp.ui.activity.DashBoardActivity
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.viewmodel.DashboardViewModel

class HomeFragment : BaseFragment<DashboardViewModel, FragmentHomeBinding>(), View.OnClickListener {
    lateinit var homeBinding: FragmentHomeBinding

    override fun getLayout(): Int = R.layout.fragment_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeBinding.imgMarketPlace.setOnClickListener(this)
        homeBinding.imgSavingGroup.setOnClickListener(this)
        homeBinding.imgManageCredit.setOnClickListener(this)

    }

    override fun getViewModelClass(): Class<DashboardViewModel> {
        return DashboardViewModel::class.java
    }

    override fun onResume() {
        super.onResume()
        setToolbar()
    }

    private fun setToolbar() {
        (activity as DashBoardActivity).setToolbarBackImage(View.GONE, R.color.white)
        (activity as DashBoardActivity).setToolbarTitle(View.GONE, R.color.white, "")
        (activity as DashBoardActivity).setToolbarBackground(R.color.primary)
        (activity as DashBoardActivity).setToolbarNotificationIcon(R.color.white, View.VISIBLE)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.img_market_place -> {
                findNavController().navigate(R.id.marketPlaceFragment)
            }

            R.id.img_manage_credit -> {
                findNavController().navigate(R.id.creditCardReportFragment)
            }

            R.id.img_saving_group -> {
                findNavController().navigate(R.id.fragment_saving_group)
            }
        }
    }
}