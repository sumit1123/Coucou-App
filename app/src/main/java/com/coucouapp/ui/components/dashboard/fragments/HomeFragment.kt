package com.coucouapp.ui.components.dashboard.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.*
import com.coucouapp.R
import com.coucouapp.databinding.FragmentHomeBinding
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.ui.components.dashboard.*
import com.coucouapp.ui.components.dashboard.viewmodel.DashboardViewModel
import kotlinx.android.synthetic.main.toolbar_dashboard.view.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : BaseFragment<DashboardViewModel, FragmentHomeBinding>(), View.OnClickListener {
    private var param1: String? = null
    private var param2: String? = null
    lateinit var homeBinding: FragmentHomeBinding
    
    override fun getLayout(): Int = R.layout.fragment_home
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
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
    }
    
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    
    
    override fun getViewModelClass(): Class<DashboardViewModel> {
        return DashboardViewModel::class.java
    }
    
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.img_market_place -> {
                findNavController().navigate(R.id.marketPlaceFragment)
            }
            
            R.id.img_manage_credit -> {
            
            }
            
            R.id.img_saving_group -> {
                findNavController().navigate(R.id.fragment_saving_group)
            }
        }
    }
    
}