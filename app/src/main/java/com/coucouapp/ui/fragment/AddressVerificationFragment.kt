package com.coucouapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coucouapp.R
import com.coucouapp.databinding.FragmentAddressVerificationBinding
import com.coucouapp.ui.activity.DashBoardActivity
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.viewmodel.AddressVerificationViewModel

class AddressVerificationFragment :
    BaseFragment<AddressVerificationViewModel, FragmentAddressVerificationBinding>() {

    lateinit var fragmentAddressVerificationBinding: FragmentAddressVerificationBinding

    override fun getLayout(): Int = R.layout.fragment_address_verification

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentAddressVerificationBinding =
            FragmentAddressVerificationBinding.inflate(inflater, container, false)
        return fragmentAddressVerificationBinding.root
    }

    override fun onResume() {
        super.onResume()
        setToolbar()
    }

    private fun setToolbar() {
        (activity as DashBoardActivity).setToolbarBackImage(View.VISIBLE, R.color.primary)
        (activity as DashBoardActivity).setToolbarTitle(
            View.VISIBLE,
            R.color.darkGray,
            getString(R.string.proof_of_residence)
        )
        (activity as DashBoardActivity).setToolbarBackground(R.color.snowGray)
        (activity as DashBoardActivity).setToolbarNotificationIcon(R.color.darkGray, View.VISIBLE)
    }

    override fun getViewModelClass(): Class<AddressVerificationViewModel> {
        return AddressVerificationViewModel::class.java
    }
}