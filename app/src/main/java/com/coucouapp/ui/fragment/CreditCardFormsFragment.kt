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

    private var genderArray = arrayOf("Male", "Female", "Other")
    private var maritalStatusArray = arrayOf("Single", "Married", "Divorced", "Widow(er)")
    private var highestEducationArray =
        arrayOf("University", "College", "Secondary", "Primary", "Not available")
    private var homeTypeArray = arrayOf("Homeowner", "Renter")
    private var cardInsuranceArray = arrayOf("Yes", "No")

    override fun getLayout(): Int = R.layout.fragment_credit_card_forms

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
        val genderAdapter: ArrayAdapter<String> =
            ArrayAdapter<String>(requireActivity(), R.layout.dropdown_menu_popup_item, genderArray)
        binding.spGender.setAdapter<ArrayAdapter<String>>(genderAdapter)

        val maritalStatusAdapter: ArrayAdapter<String> =
            ArrayAdapter<String>(
                requireActivity(),
                R.layout.dropdown_menu_popup_item,
                maritalStatusArray
            )
        binding.spMaritalStatus.setAdapter<ArrayAdapter<String>>(maritalStatusAdapter)

        val highestEducationAdapter: ArrayAdapter<String> =
            ArrayAdapter<String>(
                requireActivity(),
                R.layout.dropdown_menu_popup_item,
                highestEducationArray
            )
        binding.spHighestEducation.setAdapter<ArrayAdapter<String>>(highestEducationAdapter)

        val homeTypeAdapter: ArrayAdapter<String> =
            ArrayAdapter<String>(
                requireActivity(),
                R.layout.dropdown_menu_popup_item,
                homeTypeArray
            )
        binding.spHomeType.setAdapter<ArrayAdapter<String>>(homeTypeAdapter)

        val cardInsuranceAdapter: ArrayAdapter<String> =
            ArrayAdapter<String>(
                requireActivity(),
                R.layout.dropdown_menu_popup_item,
                cardInsuranceArray
            )
        binding.spCardInsurance.setAdapter<ArrayAdapter<String>>(cardInsuranceAdapter)
    }

    override fun getViewModelClass(): Class<CreditCardViewModel> {
        return CreditCardViewModel::class.java
    }
}