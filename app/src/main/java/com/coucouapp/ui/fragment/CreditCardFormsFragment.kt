package com.coucouapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.coucouapp.R
import com.coucouapp.databinding.FragmentCreditCardFormsBinding
import com.coucouapp.ui.activity.DashBoardActivity
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.viewmodel.CreditCardViewModel


class CreditCardFormsFragment :
    BaseFragment<CreditCardViewModel, FragmentCreditCardFormsBinding>() {

    lateinit var binding: FragmentCreditCardFormsBinding

    var genderArray = arrayOf("Male", "Female", "Other")

    override fun getLayout(): Int = R.layout.fragment_credit_card_forms

    var genderAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
        requireActivity(),
        R.layout.dropdown_menu_popup_item,
        genderArray
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreditCardFormsBinding.inflate(inflater, container, false)
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
            getString(R.string.credit_cards_forms)
        )
        (activity as DashBoardActivity).setToolbarBackground(R.color.snowGray)
        (activity as DashBoardActivity).setToolbarNotificationIcon(R.color.darkGray, View.VISIBLE)
    }

    private fun initViews() {
        binding.spGender.setAdapter<ArrayAdapter<String>>(genderAdapter)
    }

    override fun getViewModelClass(): Class<CreditCardViewModel> {
        return CreditCardViewModel::class.java
    }
}