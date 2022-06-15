package com.coucouapp.ui.components.dashboard.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coucouapp.*
import com.coucouapp.databinding.*
import com.coucouapp.ui.base.*
import com.coucouapp.ui.components.dashboard.viewmodel.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SavingGroupFragment : BaseFragment<DashboardViewModel , FragmentSavingGroupBinding>() {
    private var param1: String? = null
    private var param2: String? = null
    
    lateinit var fragmentSavingGroupBinding: FragmentSavingGroupBinding
    override fun getLayout(): Int = R.layout.fragment_saving_group
    
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentSavingGroupBinding = FragmentSavingGroupBinding.inflate(inflater, container, false)
        return fragmentSavingGroupBinding.root
    }
    
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SavingGroupFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    
    override fun getViewModelClass(): Class<DashboardViewModel> {
        return DashboardViewModel::class.java
    }
}