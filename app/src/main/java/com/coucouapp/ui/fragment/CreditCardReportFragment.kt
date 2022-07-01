package com.coucouapp.ui.fragment

import android.opengl.*
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.coucouapp.R
import com.coucouapp.data.*
import com.coucouapp.databinding.*
import com.coucouapp.ui.activity.DashBoardActivity
import com.coucouapp.ui.adapter.*
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.viewmodel.DashboardViewModel
import java.util.*

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
        when (view?.id) {
        
        }
    }
}