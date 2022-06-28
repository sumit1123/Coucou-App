package com.coucouapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.coucouapp.R
import com.coucouapp.databinding.FragmentInvestmentBinding
import com.coucouapp.ui.activity.DashBoardActivity
import com.coucouapp.ui.adapter.InvestementFullAdapter
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.viewmodel.DashboardViewModel

class InvestmentFragment : BaseFragment<DashboardViewModel, FragmentInvestmentBinding>(),
    View.OnClickListener {
    lateinit var fragmentInvestmentBinding: FragmentInvestmentBinding

    override fun getLayout(): Int = R.layout.fragment_investment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentInvestmentBinding = FragmentInvestmentBinding.inflate(inflater, container, false)
        return fragmentInvestmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        setRecyclerView()
    }

    private fun initViews() {
        fragmentInvestmentBinding.layoutFilter.tvFilterDetail.text =
            getString(R.string.investment_title)
    }

    private fun setRecyclerView() {
        fragmentInvestmentBinding.recyclerviewInvestment.layoutManager =
            LinearLayoutManager(requireContext())
        fragmentInvestmentBinding.recyclerviewInvestment.adapter = InvestementFullAdapter()
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
            getString(R.string.investment)
        )
        (activity as DashBoardActivity).setToolbarBackground(R.color.primary)
        (activity as DashBoardActivity).setToolbarNotificationIcon(R.color.white, View.VISIBLE)
    }

    override fun getViewModelClass(): Class<DashboardViewModel> {
        return DashboardViewModel::class.java
    }

    override fun onClick(v: View?) {

    }
}