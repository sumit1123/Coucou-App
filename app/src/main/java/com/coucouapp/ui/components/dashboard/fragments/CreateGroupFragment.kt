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

class CreateGroupFragment : BaseFragment<DashboardViewModel, FragmentCreateGroupBinding>() {
    private var param1: String? = null
    private var param2: String? = null
    lateinit var createGroupBinding: FragmentCreateGroupBinding
    
    override fun getLayout(): Int = R.layout.fragment_home
    
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
        createGroupBinding = FragmentCreateGroupBinding.inflate(inflater, container, false)
        return createGroupBinding.root
    }
    
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
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