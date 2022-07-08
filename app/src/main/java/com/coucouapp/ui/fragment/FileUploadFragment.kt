package com.coucouapp.ui.fragment

import android.content.*
import android.os.Bundle
import android.service.quicksettings.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.coucouapp.R
import com.coucouapp.databinding.*
import com.coucouapp.ui.activity.*
import com.coucouapp.ui.adapter.LoanInstrumentAdapter
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.utils.*
import com.coucouapp.utils.Constants.DESCRIPTION
import com.coucouapp.utils.Constants.TITLE
import com.coucouapp.viewmodel.DashboardViewModel

class FileUploadFragment : BaseFragment<DashboardViewModel, FragmentFileUploadBinding>(),
    View.OnClickListener {
    lateinit var fragmentFileUploadBinding: FragmentFileUploadBinding
    var title: String? = null
    var document_type: String? = null
    
    override fun getLayout(): Int = R.layout.fragment_file_upload
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = arguments?.getString(TITLE)
        document_type = arguments?.getString(Constants.DOCUMENT_TYPE)
        
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentFileUploadBinding = FragmentFileUploadBinding.inflate(inflater, container, false)
        return fragmentFileUploadBinding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentFileUploadBinding.btUploadFile.setOnClickListener(this)
        fragmentFileUploadBinding.imgScanImage.setOnClickListener(this)
        showRentAndBank()
    }
    
    private fun showRentAndBank() {
        when (document_type) {
            DocumentType.RENT_DOC.name -> {
                fragmentFileUploadBinding.layoutRent.consRent.visibility = View.VISIBLE
            }
            DocumentType.BANK_HISTORY.name -> {
                fragmentFileUploadBinding.layoutBankHistory.consBankHistory.visibility =
                    View.VISIBLE
            }
            else -> {
                fragmentFileUploadBinding.layoutBankHistory.consBankHistory.visibility = View.GONE
                fragmentFileUploadBinding.layoutRent.consRent.visibility = View.GONE
            }
        }
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
            title!!
        )
        (activity as DashBoardActivity).setToolbarBackground(R.color.primary)
        (activity as DashBoardActivity).setToolbarNotificationIcon(R.color.white, View.VISIBLE)
    }
    
    override fun getViewModelClass(): Class<DashboardViewModel> {
        return DashboardViewModel::class.java
    }
    
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.img_scan_image ->
            {
                val intent = Intent(requireActivity() , DocumentScannerActivity::class.java)
                startActivity(intent)
            }
            
            R.id.bt_upload_file -> {
                var intent = Intent(requireActivity(), CreateGroupVerificationActivity::class.java)
                when (document_type) {
                    DocumentType.EMPLOYEMENT_DOC.name -> {
                        intent.putExtra(TITLE, getString(R.string.employment_))
                        intent.putExtra(DESCRIPTION, getString(R.string.your_employ))
                    }
                    DocumentType.INCOME_DOC.name -> {
                        intent.putExtra(TITLE, getString(R.string.income_file_upload))
                        intent.putExtra(DESCRIPTION, getString(R.string.your_income))
                    }
                    DocumentType.RENT_DOC.name -> {
                        intent.putExtra(TITLE, getString(R.string.rent))
                        intent.putExtra(DESCRIPTION, getString(R.string.your_rent))
                    }
                    DocumentType.BANK_HISTORY.name -> {
                        intent.putExtra(TITLE, getString(R.string.bank_history))
                        intent.putExtra(DESCRIPTION, getString(R.string.your_bank))
                    }
                }
                startActivity(intent)
            }
        }
    }
}