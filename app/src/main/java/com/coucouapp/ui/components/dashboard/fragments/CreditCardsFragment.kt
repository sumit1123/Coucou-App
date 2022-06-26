package com.coucouapp.ui.components.dashboard.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coucouapp.R
import com.coucouapp.databinding.FragmentCreditCardsBinding
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.ui.components.dashboard.DashBoardScreen
import com.coucouapp.viewmodel.MarketPlaceViewModel

class CreditCardsFragment: BaseFragment<MarketPlaceViewModel, FragmentCreditCardsBinding>() {

    lateinit var fragmentCreditCardsBinding: FragmentCreditCardsBinding

    override fun getLayout(): Int = R.layout.fragment_credit_cards

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentCreditCardsBinding = FragmentCreditCardsBinding.inflate(inflater, container, false)
        return fragmentCreditCardsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        setToolbar()
    }

    private fun setToolbar() {
        (activity as DashBoardScreen).setToolbarBackImage(View.VISIBLE, R.color.white)
        (activity as DashBoardScreen).setToolbarTitle(
            View.VISIBLE,
            R.color.white,
            getString(R.string.credit_cards)
        )
        (activity as DashBoardScreen).setToolbarBackground(R.color.primary)
        (activity as DashBoardScreen).setToolbarNotificationIcon(R.color.white, View.VISIBLE)
    }

    override fun getViewModelClass(): Class<MarketPlaceViewModel> {
        return MarketPlaceViewModel::class.java
    }


}