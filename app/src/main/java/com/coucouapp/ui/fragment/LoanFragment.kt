package com.coucouapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.coucouapp.R
import com.coucouapp.databinding.FragmentLoanBinding
import com.coucouapp.ui.activity.DashBoardActivity
import com.coucouapp.ui.adapter.*
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.viewmodel.DashboardViewModel

class LoanFragment : BaseFragment<DashboardViewModel, FragmentLoanBinding>(),
    View.OnClickListener {
    lateinit var fragmentLoanBinding: FragmentLoanBinding

    override fun getLayout(): Int = R.layout.fragment_loan

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentLoanBinding = FragmentLoanBinding.inflate(inflater, container, false)
        return fragmentLoanBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        setRecyclerView()
    }

    private fun initViews() {
        fragmentLoanBinding.layoutFilter.tvFilterDetail.text = getString(R.string.investment_title)
        fragmentLoanBinding.layoutFilter.llFilter.setOnClickListener(this)
    }

    private fun setRecyclerView() {
    
        fragmentLoanBinding.layoutFilter.recyclerviewYourLoan.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        fragmentLoanBinding.layoutFilter.recyclerviewYourLoan.adapter = YourLoanAdapter(requireActivity())
        
        fragmentLoanBinding.recyclerviewLoan.layoutManager = LinearLayoutManager(requireContext())
        fragmentLoanBinding.recyclerviewLoan.adapter = LoanInstrumentAdapter(requireActivity())
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
            getString(R.string.loan_instrument)
        )
        (activity as DashBoardActivity).setToolbarBackground(R.color.primary)
        (activity as DashBoardActivity).setToolbarNotificationIcon(R.color.white, View.VISIBLE)
    }

    override fun getViewModelClass(): Class<DashboardViewModel> {
        return DashboardViewModel::class.java
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.llFilter -> {
                findNavController().navigate(R.id.filterBottomSheetLoanDialog)
            }
        }
    }
}