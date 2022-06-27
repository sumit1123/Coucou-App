package com.coucouapp.ui.components.dashboard.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.coucouapp.R
import com.coucouapp.databinding.FragmentMarketPlaceBinding
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.ui.components.dashboard.DashBoardScreen
import com.coucouapp.ui.components.dashboard.adapters.CreaditCardAdapter
import com.coucouapp.ui.components.dashboard.adapters.InvestementAdapter
import com.coucouapp.ui.components.dashboard.adapters.LoanProductAdapter
import com.coucouapp.viewmodel.MarketPlaceViewModel


class MarketPlaceFragment : BaseFragment<MarketPlaceViewModel, FragmentMarketPlaceBinding>(),
    View.OnClickListener {

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
        initViews()
        setRecyclerViews()
    }

    private fun initViews() {
        fragmentMarketPlaceBinding.tvCreditCardViewAll.setOnClickListener(this)
        fragmentMarketPlaceBinding.tvLoanViewAll.setOnClickListener(this)
        fragmentMarketPlaceBinding.tvInvestmentViewAll.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        setToolbar()
    }

    private fun setToolbar() {
        (activity as DashBoardScreen).setToolbarBackImage(View.VISIBLE, R.color.primary)
        (activity as DashBoardScreen).setToolbarTitle(
            View.VISIBLE,
            R.color.primary,
            getString(R.string.investment)
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

    override fun getViewModelClass(): Class<MarketPlaceViewModel> {
        return MarketPlaceViewModel::class.java
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.tv_credit_card_view_all -> {
                findNavController().navigate(R.id.creditCardsFragment)
            }
            R.id.tv_investment_view_all -> {
                findNavController().navigate(R.id.investmentFragment)
            }
            R.id.tv_loan_view_all -> {
            }

        }
    }
}