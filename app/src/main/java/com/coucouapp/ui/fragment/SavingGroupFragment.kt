package com.coucouapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.coucouapp.R
import com.coucouapp.databinding.FragmentSavingGroupBinding
import com.coucouapp.ui.activity.DashBoardActivity
import com.coucouapp.ui.adapter.FriendsAdapter
import com.coucouapp.ui.adapter.PublicGroupAdapter
import com.coucouapp.ui.adapter.SavingGroupAdapter
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.viewmodel.DashboardViewModel


class SavingGroupFragment : BaseFragment<DashboardViewModel, FragmentSavingGroupBinding>(),
    View.OnClickListener {

    lateinit var fragmentSavingGroupBinding: FragmentSavingGroupBinding
    override fun getLayout(): Int = R.layout.fragment_saving_group

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
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

        initViews()
        setRecyclerView()
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
            getString(R.string.your_savings_groups)
        )
        (activity as DashBoardActivity).setToolbarBackground(R.color.primary)
        (activity as DashBoardActivity).setToolbarNotificationIcon(R.color.white, View.VISIBLE)
    }

    private fun initViews() {
        fragmentSavingGroupBinding.tvViewAll.setOnClickListener(this)
        fragmentSavingGroupBinding.imgCreateGroup.setOnClickListener(this)
        fragmentSavingGroupBinding.tvCurrentSavingGroup.setOnClickListener(this)
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
            R.id.tv_current_saving_group -> {
                findNavController().navigate(R.id.mySavingGroupsFragment)
            }
            R.id.img_add_friends -> {
                findNavController().navigate(R.id.contactsFragment)
            }
        }
    }
}