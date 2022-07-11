package com.coucouapp.ui.fragment

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

class PaymentHistoryFragment : BaseFragment<DashboardViewModel, FragmentPaymentHistoryBinding>(){

    lateinit var fragmentPaymentHistoryBinding: FragmentPaymentHistoryBinding

    override fun getLayout(): Int = R.layout.fragment_market_place

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentPaymentHistoryBinding = FragmentPaymentHistoryBinding.inflate(inflater, container, false)
        return fragmentPaymentHistoryBinding.root
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
            getString(R.string.payment_his)
        )
        (activity as DashBoardActivity).setToolbarBackground(R.color.snowGray)
        (activity as DashBoardActivity).setToolbarNotificationIcon(R.color.darkGray, View.VISIBLE)
    }

    private fun setRecyclerViews() {
        fragmentPaymentHistoryBinding.recyclerviewPaymentHistory.layoutManager =
            LinearLayoutManager(requireContext())
        fragmentPaymentHistoryBinding.recyclerviewPaymentHistory.adapter = PaymentHistoryAdapter()
       
    }

    override fun getViewModelClass(): Class<DashboardViewModel> {
        return DashboardViewModel::class.java
    }

  }