package com.coucouapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.*
import com.coucouapp.R
import com.coucouapp.databinding.*
import com.coucouapp.ui.activity.DashBoardActivity
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.utils.*
import com.coucouapp.utils.Constants.DOCUMENT_TYPE
import com.coucouapp.utils.Constants.TITLE
import com.coucouapp.viewmodel.DashboardViewModel


class CreditCardReportFragment : BaseFragment<DashboardViewModel, FragmentCreditcardsReportBinding>(),
    View.OnClickListener {

    lateinit var fragmentCreditcardsReportBinding: FragmentCreditcardsReportBinding
    override fun getLayout(): Int = R.layout.fragment_creditcards_report
   
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentCreditcardsReportBinding = FragmentCreditcardsReportBinding.inflate(inflater, container, false)
        return fragmentCreditcardsReportBinding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentCreditcardsReportBinding.tvProofEmployment.setOnClickListener(this)
        fragmentCreditcardsReportBinding.tvProofIncome.setOnClickListener(this)
        fragmentCreditcardsReportBinding.tvProofRent.setOnClickListener(this)
        fragmentCreditcardsReportBinding.tvBankHistory.setOnClickListener(this)
      
    }
    
    override fun onResume() {
        super.onResume()
        setToolbar()
    }

    private fun setToolbar() {
        (activity as DashBoardActivity).setToolbarBackImage(View.VISIBLE, R.color.white)
        (activity as DashBoardActivity).setToolbarTitle(
            View.VISIBLE,
            R.color.white,
            getString(R.string.credit_deta)
        )
        (activity as DashBoardActivity).setToolbarBackground(R.color.primary)
        (activity as DashBoardActivity).setToolbarNotificationIcon(R.color.white, View.VISIBLE)
    }
    
    
    override fun getViewModelClass(): Class<DashboardViewModel> {
        return DashboardViewModel::class.java
    }
    
    override fun onClick(view: View?) {
        var bundle = Bundle()
        when (view?.id) {
          R.id.tv_proof_employment ->
          {
              bundle.putString(TITLE , resources.getString(R.string.employement))
              bundle.putString(DOCUMENT_TYPE , DocumentType.EMPLOYEMENT_DOC.name)
            findNavController().navigate(R.id.fileUploadFragment ,bundle)
          }
          
          R.id.tv_proof_income ->
          {
              bundle.putString(TITLE , resources.getString(R.string.income_file))
              bundle.putString(DOCUMENT_TYPE , DocumentType.INCOME_DOC.name)
              findNavController().navigate(R.id.fileUploadFragment ,bundle)
          }
          
          R.id.tv_proof_rent ->
          {
              bundle.putString(TITLE , resources.getString(R.string.rent_file))
              bundle.putString(DOCUMENT_TYPE , DocumentType.RENT_DOC.name)
              findNavController().navigate(R.id.fileUploadFragment,bundle)
          }
         
         R.id.tv_bank_history ->
         {
             bundle.putString(TITLE , resources.getString(R.string.bank_file))
             bundle.putString(DOCUMENT_TYPE , DocumentType.BANK_HISTORY.name)
             findNavController().navigate(R.id.fileUploadFragment,bundle)
         }
         
        }
    }
}