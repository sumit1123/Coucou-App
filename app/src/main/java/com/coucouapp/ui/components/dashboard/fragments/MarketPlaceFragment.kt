package com.coucouapp.ui.components.dashboard.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.coucouapp.R
import com.coucouapp.databinding.FragmentMarketPlaceBinding
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.ui.components.dashboard.DashBoardScreen
import com.coucouapp.ui.components.dashboard.adapters.CreaditCardAdapter
import com.coucouapp.ui.components.dashboard.adapters.InvestementAdapter
import com.coucouapp.ui.components.dashboard.adapters.LoanProductAdapter
import com.coucouapp.viewmodel.ProfileDetailViewModel


class MarketPlaceFragment : BaseFragment<ProfileDetailViewModel, FragmentMarketPlaceBinding>() {

    lateinit var fragmentMarketPlaceBinding: FragmentMarketPlaceBinding

    override fun getLayout(): Int = R.layout.fragment_market_place

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMarketPlaceBinding = FragmentMarketPlaceBinding.inflate(inflater, container, false)
        return fragmentMarketPlaceBinding.root
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
        (activity as DashBoardScreen).setToolbarBackImage(View.VISIBLE, R.color.primary)
        (activity as DashBoardScreen).setToolbarTitle(
            View.VISIBLE,
            R.color.darkGray,
            getString(R.string.market_place)
        )
        (activity as DashBoardScreen).setToolbarBackground(R.color.market_gray)
        (activity as DashBoardScreen).setToolbarNotificationIcon(R.color.darkGray, View.VISIBLE)
    }

    private fun setRecyclerViews() {
        fragmentMarketPlaceBinding.recyclerviewCreditCard.layoutManager =
            LinearLayoutManager(requireContext())
        fragmentMarketPlaceBinding.recyclerviewCreditCard.adapter = CreaditCardAdapter()

        fragmentMarketPlaceBinding.recyclerviewInvestment.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        fragmentMarketPlaceBinding.recyclerviewInvestment.adapter = InvestementAdapter()

        fragmentMarketPlaceBinding.recyclerviewLoanProduct.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        fragmentMarketPlaceBinding.recyclerviewLoanProduct.adapter = LoanProductAdapter()
    }

    override fun getViewModelClass(): Class<ProfileDetailViewModel> {
        return ProfileDetailViewModel::class.java
    }
}