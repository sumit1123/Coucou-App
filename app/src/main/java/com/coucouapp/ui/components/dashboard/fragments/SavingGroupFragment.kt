package com.coucouapp.ui.components.dashboard.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.coucouapp.R
import com.coucouapp.databinding.FragmentSavingGroupBinding
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.ui.components.dashboard.DashBoardScreen
import com.coucouapp.ui.components.dashboard.adapters.FriendsAdapter
import com.coucouapp.ui.components.dashboard.adapters.PublicGroupAdapter
import com.coucouapp.ui.components.dashboard.adapters.SavingGroupAdapter
import com.coucouapp.ui.components.dashboard.viewmodel.DashboardViewModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SavingGroupFragment : BaseFragment<DashboardViewModel, FragmentSavingGroupBinding>(),
    View.OnClickListener {
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
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        setToolbar()
    }

    private fun setToolbar() {
        (activity as DashBoardScreen).setToolbarBackImage(View.VISIBLE, R.color.white)
        (activity as DashBoardScreen).setToolbarTitle(View.VISIBLE, R.color.white, getString(R.string.your_savings_groups))
        (activity as DashBoardScreen).setToolbarBackground(R.color.primary)
        (activity as DashBoardScreen).setToolbarNotificationIcon(R.color.white, View.VISIBLE)
    }
    
    private fun setRecyclerView() {
        fragmentSavingGroupBinding.recyclerviewFriends.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        fragmentSavingGroupBinding.recyclerviewFriends.adapter = FriendsAdapter()
        
        fragmentSavingGroupBinding.recyclerviewGroupName.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        fragmentSavingGroupBinding.recyclerviewGroupName.adapter = SavingGroupAdapter()
        
        fragmentSavingGroupBinding.recyclerviewPublicGroup.layoutManager =
            LinearLayoutManager(requireContext())
        fragmentSavingGroupBinding.recyclerviewPublicGroup.adapter = PublicGroupAdapter()
        
        fragmentSavingGroupBinding.tvViewAll.setOnClickListener(this)
        fragmentSavingGroupBinding.imgCreateGroup.setOnClickListener(this)
        
    }
    
    
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