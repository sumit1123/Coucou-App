package com.coucouapp.ui.components.dashboard.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.coucouapp.R
import com.coucouapp.databinding.FragmentGroupDetailBinding
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.ui.components.dashboard.DashBoardScreen
import com.coucouapp.ui.components.dashboard.viewmodel.DashboardViewModel

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

    override fun onResume() {
        super.onResume()
        setToolbar()
    }

    private fun setToolbar() {
        (activity as DashBoardScreen).setToolbarBackImage(View.VISIBLE, R.color.primary)
        (activity as DashBoardScreen).setToolbarTitle(
            View.VISIBLE,
            R.color.darkGray,
            getString(R.string.public_group) // TODO: Replace title with group name
        )
        (activity as DashBoardScreen).setToolbarBackground(R.color.market_gray)
        (activity as DashBoardScreen).setToolbarNotificationIcon(R.color.darkGray, View.VISIBLE)
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