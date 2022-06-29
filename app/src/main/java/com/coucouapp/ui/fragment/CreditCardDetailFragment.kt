package com.coucouapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.coucouapp.R
import com.coucouapp.databinding.FragmentCreditCardDetailBinding
import com.coucouapp.ui.activity.DashBoardActivity
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.viewmodel.CreditCardViewModel

class CreditCardDetailFragment :
    BaseFragment<CreditCardViewModel, FragmentCreditCardDetailBinding>(), View.OnClickListener {

    lateinit var binding: FragmentCreditCardDetailBinding

    override fun getLayout(): Int = R.layout.fragment_credit_card_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreditCardDetailBinding.inflate(inflater, container, false)
        return binding.root
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
            getString(R.string.credit_cards)
        )
        (activity as DashBoardActivity).setToolbarBackground(R.color.snowGray)
        (activity as DashBoardActivity).setToolbarNotificationIcon(R.color.darkGray, View.VISIBLE)
    }

    private fun initViews() {
        binding.tvApplyCard.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.tvApplyCard -> {
                v.findNavController().navigate(R.id.creditCardFormsFragment)
            }
        }
    }

    override fun getViewModelClass(): Class<CreditCardViewModel> {
        return CreditCardViewModel::class.java
    }


}