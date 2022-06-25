package com.coucouapp.ui.components.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.coucouapp.R
import com.coucouapp.databinding.FragmentProfileVerificationBinding
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.ui.components.dashboard.DashBoardScreen
import com.coucouapp.viewmodel.ProfileVerificationViewModel
import kotlinx.android.synthetic.main.fragment_profile_verification.*

class ProfileVerificationFragment : BaseFragment<ProfileVerificationViewModel, FragmentProfileVerificationBinding>() {

    lateinit var fragmentProfileVerificationBinding: FragmentProfileVerificationBinding

    override fun getLayout(): Int = R.layout.fragment_profile_verification

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        fragmentProfileVerificationBinding = FragmentProfileVerificationBinding.inflate(inflater, container, false)
        return fragmentProfileVerificationBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
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
            getString(R.string.verification)
        )
        (activity as DashBoardScreen).setToolbarBackground(R.color.market_gray)
        (activity as DashBoardScreen).setToolbarNotificationIcon(R.color.darkGray, View.VISIBLE)
    }

    private fun initViews() {
        llAddressVerification.setOnClickListener {
            findNavController().navigate(
                ProfileVerificationFragmentDirections.actionFragmentProfileVerificationToFragmentAddressVerification()
            )
        }
    }

    override fun getViewModelClass(): Class<ProfileVerificationViewModel> {
        return ProfileVerificationViewModel::class.java
    }


}