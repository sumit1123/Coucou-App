package com.coucouapp.ui.components.dashboard.fragments

import android.os.*
import android.view.*
import androidx.navigation.fragment.*
import com.coucouapp.R
import com.coucouapp.databinding.*
import com.coucouapp.ui.base.*
import com.coucouapp.ui.components.dashboard.*
import com.coucouapp.ui.components.dashboard.viewmodel.*
import com.coucouapp.ui.components.fragments.*

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
        (activity as DashBoardScreen).setToolbarBackImage(View.GONE, R.color.white)
        (activity as DashBoardScreen).setToolbarTitle(View.GONE, R.color.white, "")
        (activity as DashBoardScreen).setToolbarBackground(R.color.primary)
        (activity as DashBoardScreen).setToolbarNotificationIcon(R.color.white, View.VISIBLE)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.img_market_place -> {
                findNavController().navigate(R.id.marketPlaceFragment)
            }

            R.id.img_manage_credit -> {
                findNavController().navigate(R.id.creditCardsFragment)
            }

            R.id.img_saving_group -> {
                findNavController().navigate(R.id.fragment_saving_group)
            }
        }
    }

}