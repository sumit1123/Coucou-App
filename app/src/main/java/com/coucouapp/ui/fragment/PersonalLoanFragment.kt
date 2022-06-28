package com.coucouapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.coucouapp.R
import com.coucouapp.databinding.FragmentPersonalLoanBinding
import com.coucouapp.ui.activity.DashBoardActivity
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.viewmodel.DashboardViewModel


class PersonalLoanFragment : BaseFragment<DashboardViewModel, FragmentPersonalLoanBinding>(),
    View.OnClickListener {
    lateinit var fragmentPersonalLoanBinding: FragmentPersonalLoanBinding

    override fun getLayout(): Int = R.layout.fragment_personal_loan

    companion object {
        fun newInstance(): PersonalLoanFragment {
            return PersonalLoanFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentPersonalLoanBinding =
            FragmentPersonalLoanBinding.inflate(inflater, container, false)
        return fragmentPersonalLoanBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentPersonalLoanBinding.btApply.setOnClickListener(this)

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
            getString(R.string.personal_loan)
        )
        (activity as DashBoardActivity).setToolbarBackground(R.color.snowGray)
        (activity as DashBoardActivity).setToolbarNotificationIcon(R.color.darkGray, View.VISIBLE)
    }

    override fun getViewModelClass(): Class<DashboardViewModel> {
        return DashboardViewModel::class.java
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.bt_apply -> {
                findNavController().navigate(R.id.applyLoanBottomSheetDialog)
            }
        }
    }

}