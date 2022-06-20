package com.coucouapp.ui.components.dashboard.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.*
import androidx.recyclerview.widget.*
import com.coucouapp.*
import com.coucouapp.R
import com.coucouapp.databinding.*
import com.coucouapp.ui.base.*
import com.coucouapp.ui.components.dashboard.adapters.*
import com.coucouapp.ui.components.dashboard.viewmodel.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PubliGroupDetailFragment : BaseFragment<DashboardViewModel, FragmentGroupDetailBinding>(),
    View.OnClickListener {
    private var param1: String? = null
    private var param2: String? = null
    
    lateinit var fragmentGroupDetailBinding: FragmentGroupDetailBinding
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
        fragmentGroupDetailBinding = FragmentGroupDetailBinding.inflate(inflater, container, false)
        //setRecyclerView()
        
        return fragmentGroupDetailBinding.root
    }
    
//    private fun setRecyclerView() {
//        fragmentSavingGroupBinding.recyclerviewFriends.layoutManager =
//            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
//        fragmentSavingGroupBinding.recyclerviewFriends.adapter = FriendsAdapter()
//
//        fragmentSavingGroupBinding.recyclerviewGroupName.layoutManager =
//            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
//        fragmentSavingGroupBinding.recyclerviewGroupName.adapter = SavingGroupAdapter()
//
//        fragmentSavingGroupBinding.recyclerviewPublicGroup.layoutManager =
//            LinearLayoutManager(requireContext())
//        fragmentSavingGroupBinding.recyclerviewPublicGroup.adapter = PublicGroupAdapter()
//
//        fragmentSavingGroupBinding.tvViewAll.setOnClickListener(this)
//        fragmentSavingGroupBinding.imgCreateGroup.setOnClickListener(this)
//
//    }
    
    
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = SavingGroupFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
    }
    
    override fun getViewModelClass(): Class<DashboardViewModel> {
        return DashboardViewModel::class.java
    }
    
    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_view_all -> {
                findNavController().navigate(R.id.publicGroupFragment)
            }
            
            R.id.img_create_group -> {
                findNavController().navigate(R.id.createGroupFragment)
            }
        }
    }
}