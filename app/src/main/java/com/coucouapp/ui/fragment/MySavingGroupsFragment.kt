package com.coucouapp.ui.fragment

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.coucouapp.R
import com.coucouapp.databinding.DialogCoucouBinding
import com.coucouapp.databinding.FragmentMySavingGroupsBinding
import com.coucouapp.ui.activity.CreateGroupVerificationActivity
import com.coucouapp.ui.activity.DashBoardActivity
import com.coucouapp.ui.adapter.MySavingGroupsAdapter
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.ui.interfaces.OnClickMySavingGroup
import com.coucouapp.utils.Constants
import com.coucouapp.utils.PagerMarginItemDecoration
import com.coucouapp.viewmodel.MySavingGroupsViewModel


class MySavingGroupsFragment :
    BaseFragment<MySavingGroupsViewModel, FragmentMySavingGroupsBinding>(),
    View.OnClickListener, OnClickMySavingGroup {

    lateinit var binding: FragmentMySavingGroupsBinding

    private lateinit var myAdapter: MySavingGroupsAdapter

    override fun getLayout(): Int = R.layout.fragment_my_saving_groups

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMySavingGroupsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {
        binding.tvContributeInGroup.setOnClickListener(this)
        myAdapter = MySavingGroupsAdapter(requireActivity(), this)
        createViewPager()
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

    private fun createViewPager() {
        binding.vpMyGroup.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        binding.vpMyGroup.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.vpMyGroup.adapter = myAdapter
        binding.vpMyGroup.offscreenPageLimit = 1

        val nextItemVisibleWidth = resources.getDimension(R.dimen.next_item_visible_width)
        val currentItemMargin =
            resources.getDimension(R.dimen.viewpager_horizontal_margin)
        val pageTranslation = nextItemVisibleWidth + currentItemMargin
        binding.vpMyGroup.setPageTransformer { page: View, position: Float ->
            page.translationX = -pageTranslation * position
            page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
            page.alpha = 0.25f + (1 - kotlin.math.abs(position))
        }
        val itemDecoration = PagerMarginItemDecoration(
            requireContext(),
            R.dimen.viewpager_horizontal_margin
        )
        binding.vpMyGroup.addItemDecoration(itemDecoration)
    }


    private fun showRequestPaymentDialog() {
        val dialog = Dialog(requireActivity())
        val binding: DialogCoucouBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.dialog_coucou,
            null,
            false
        )
        dialog.setContentView(binding.root)
        binding.tvTitle.text = resources.getString(R.string.request_payment)
        binding.tvDescription.text = getString(R.string.request_payment_detail)
        val width = (resources.displayMetrics.widthPixels * 0.90).toInt()
        val height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog.window?.setLayout(width, height)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        binding.btYes.setOnClickListener {
            val intent = Intent(requireActivity(), CreateGroupVerificationActivity::class.java)
            intent.putExtra(Constants.TITLE, getString(R.string.payment_request_sent))
            intent.putExtra(Constants.DESCRIPTION, "")
            startActivity(intent)
            dialog.dismiss()
        }
        binding.btCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    override fun onResume() {
        super.onResume()
        setToolbar()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.tvContributeInGroup -> {
                findNavController().navigate(R.id.contributeInGroupBottomSheetDialogFragment)
            }
        }
    }

    override fun onClickRequestPayment() {
        showRequestPaymentDialog()
    }

    override fun onClickTransactionHistory() {
        findNavController().navigate(R.id.transactionHistoryBottomSheetDialogFragment)
    }

    override fun onClickWithdrawFunds() {
        findNavController().navigate(R.id.withdrawFundsBottomSheetDialogFragment)
    }

    override fun getViewModelClass(): Class<MySavingGroupsViewModel> {
        return MySavingGroupsViewModel::class.java
    }
}