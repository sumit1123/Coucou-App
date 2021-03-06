package com.coucouapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.coucouapp.R
import com.coucouapp.databinding.FragmentProfileBinding
import com.coucouapp.ui.activity.DashBoardActivity
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.viewmodel.ProfileDetailViewModel
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : BaseFragment<ProfileDetailViewModel, FragmentProfileBinding>() {

    lateinit var fragmentProfileBinding: FragmentProfileBinding

    override fun getLayout(): Int = R.layout.fragment_profile

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentProfileBinding = FragmentProfileBinding.inflate(inflater, container, false)
        return fragmentProfileBinding.root
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
        (activity as DashBoardActivity).setToolbarBackImage(View.VISIBLE, R.color.primary)
        (activity as DashBoardActivity).setToolbarTitle(
            View.VISIBLE,
            R.color.darkGray,
            getString(R.string.profile)
        )
        (activity as DashBoardActivity).setToolbarBackground(R.color.snowGray)
        (activity as DashBoardActivity).setToolbarNotificationIcon(R.color.darkGray, View.VISIBLE)
    }

    private fun initViews() {
        tvVerifyYourProfile.setOnClickListener {
            findNavController().navigate(
                ProfileFragmentDirections.actionFragmentProfileToFragmentProfileVerification()
            )
        }
    }

    override fun getViewModelClass(): Class<ProfileDetailViewModel> {
        return ProfileDetailViewModel::class.java
    }
}