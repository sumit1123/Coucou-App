package com.coucouapp.ui.fragment

import android.content.*
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.coucouapp.R
import com.coucouapp.databinding.FragmentProfileVerificationBinding
import com.coucouapp.ui.activity.*
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.viewmodel.ProfileVerificationViewModel
import kotlinx.android.synthetic.main.fragment_profile_verification.*

class ProfileVerificationFragment : BaseFragment<ProfileVerificationViewModel, FragmentProfileVerificationBinding>() ,View.OnClickListener {

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
        fragmentProfileVerificationBinding.llFacialVerification.setOnClickListener(this)
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
            getString(R.string.verification)
        )
        (activity as DashBoardActivity).setToolbarBackground(R.color.snowGray)
        (activity as DashBoardActivity).setToolbarNotificationIcon(R.color.darkGray, View.VISIBLE)
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
    
    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.llFacialVerification ->
            {
                val intent = Intent(requireContext() , FaceDetectionActivity::class.java)
                startActivity(intent)
            }
        }
    }
    
    
}