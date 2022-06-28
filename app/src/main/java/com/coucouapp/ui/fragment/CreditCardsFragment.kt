package com.coucouapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.coucouapp.R
import com.coucouapp.databinding.FragmentCreditCardsBinding
import com.coucouapp.ui.activity.DashBoardActivity
import com.coucouapp.ui.adapter.AllCreditCardAdapter
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.viewmodel.MarketPlaceViewModel

class CreditCardsFragment : BaseFragment<MarketPlaceViewModel, FragmentCreditCardsBinding>(),
    View.OnClickListener {

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

        initViews()
        setRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        setToolbar()
    }

    private fun setToolbar() {
        (activity as DashBoardActivity).setToolbarBackImage(View.VISIBLE, R.color.white)
        (activity as DashBoardActivity).setToolbarTitle(
            View.VISIBLE,
            R.color.white,
            getString(R.string.credit_cards)
        )
        (activity as DashBoardActivity).setToolbarBackground(R.color.primary)
        (activity as DashBoardActivity).setToolbarNotificationIcon(R.color.white, View.VISIBLE)
    }

    private fun initViews() {
        fragmentCreditCardsBinding.layoutFilter.ivFilter.setOnClickListener(this)
    }

    private fun setRecyclerView() {
        fragmentCreditCardsBinding.rvCreditCards.layoutManager =
            LinearLayoutManager(requireContext())
        fragmentCreditCardsBinding.rvCreditCards.adapter = AllCreditCardAdapter()
    }

    override fun getViewModelClass(): Class<MarketPlaceViewModel> {
        return MarketPlaceViewModel::class.java
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.ivFilter -> {
                findNavController().navigate(R.id.filterBottomSheetDialog)
            }
        }
    }
}