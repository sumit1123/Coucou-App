package com.coucouapp.ui.components.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.*
import androidx.recyclerview.widget.*
import com.coucouapp.R
import com.coucouapp.databinding.*
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.ui.components.dashboard.DashBoardScreen
import com.coucouapp.ui.components.dashboard.adapters.*
import com.coucouapp.ui.components.dashboard.viewmodel.DashboardViewModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class LoanFragment : BaseFragment<DashboardViewModel, FragmentLoanBinding>(),
    View.OnClickListener {
    private var param1: String? = null
    private var param2: String? = null
    lateinit var fragmentLoanBinding: FragmentLoanBinding

    override fun getLayout(): Int = R.layout.fragment_loan

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
        fragmentLoanBinding = FragmentLoanBinding.inflate(inflater, container, false)
        return fragmentLoanBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentLoanBinding.layoutFilter.tvFilter.text  = getString(R.string.investement_title)
        fragmentLoanBinding.layoutFilter.imgFilter.setOnClickListener(this)
        setRecyclerView()
    }
    
    private fun setRecyclerView() {
        fragmentLoanBinding.recyclerviewLoan.layoutManager =
            LinearLayoutManager(requireContext())
        fragmentLoanBinding.recyclerviewLoan.adapter = LoanInstrumentAdapter(requireActivity())
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
            getString(R.string.loan_instrument)
        )
        (activity as DashBoardScreen).setToolbarBackground(R.color.market_gray)
        (activity as DashBoardScreen).setToolbarNotificationIcon(R.color.darkGray, View.VISIBLE)
    }

    override fun getViewModelClass(): Class<DashboardViewModel> {
        return DashboardViewModel::class.java
    }

    override fun onClick(v: View?) {
        when(v!!.id)
        {
            R.id.img_filter ->
            {
                findNavController().navigate(R.id.filterBottomSheetLoanDialog)
            }
        }
    }

}