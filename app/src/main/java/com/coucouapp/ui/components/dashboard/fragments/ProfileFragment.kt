package com.coucouapp.ui.components.dashboard.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coucouapp.R
import com.coucouapp.databinding.FragmentProfileBinding
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.ui.components.ProfileVerificationActivity
import com.coucouapp.viewmodel.ProfileDetailViewModel
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : BaseFragment<ProfileDetailViewModel, FragmentProfileBinding>() {

    lateinit var fragmentProfileBinding: FragmentProfileBinding

    override fun getLayout(): Int = R.layout.fragment_profile

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        fragmentProfileBinding = FragmentProfileBinding.inflate(inflater, container, false)
        return fragmentProfileBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        tvVerifyYourProfile.setOnClickListener {
            val intent = Intent(requireActivity(), ProfileVerificationActivity::class.java)
            startActivity(intent)
        }
    }

    override fun getViewModelClass(): Class<ProfileDetailViewModel> {
        return ProfileDetailViewModel::class.java
    }
}