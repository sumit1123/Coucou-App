package com.coucouapp.ui.fragment

import android.app.*
import android.content.*
import android.graphics.*
import android.graphics.drawable.*
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.*
import androidx.navigation.fragment.findNavController
import com.coucouapp.R
import com.coucouapp.databinding.*
import com.coucouapp.ui.activity.*
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.utils.*
import com.coucouapp.viewmodel.DashboardViewModel

class PublicGroupDetailFragment : BaseFragment<DashboardViewModel, FragmentGroupDetailBinding>(),
    View.OnClickListener {
    private var param1: String? = null
    private var param2: String? = null

    lateinit var fragmentGroupDetailBinding: FragmentGroupDetailBinding
    override fun getLayout(): Int = R.layout.fragment_group_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentGroupDetailBinding = FragmentGroupDetailBinding.inflate(inflater, container, false)
        return fragmentGroupDetailBinding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentGroupDetailBinding.btRequestJoin.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        setToolbar()
    }

    private fun setToolbar() {
        (activity as DashBoardActivity).setToolbarBackImage(View.VISIBLE, R.color.primary)
        (activity as DashBoardActivity).setToolbarTitle(
            View.VISIBLE,
            R.color.darkGray,
            getString(R.string.public_group) // TODO: Replace title with group name
        )
        (activity as DashBoardActivity).setToolbarBackground(R.color.snowGray)
        (activity as DashBoardActivity).setToolbarNotificationIcon(R.color.darkGray, View.VISIBLE)
    }

    override fun getViewModelClass(): Class<DashboardViewModel> {
        return DashboardViewModel::class.java
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.bt_request_join ->
            {
                showDialog()
            }
        }
    }
    
    
    private fun showDialog() {
        var dialog = Dialog(requireActivity())
        val binding: DialogCoucouBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.dialog_coucou,
            null,
            false
        )
        dialog.setContentView(binding.getRoot())
        val width = (resources.displayMetrics.widthPixels * 0.90).toInt()
        val height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog.getWindow()?.setLayout(width, height)
        binding.tvTitle.setText(resources.getString(R.string.send_reques))
        binding.tvDescription.setText(resources.getString(R.string.kings_royal))
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        binding.btYes.setOnClickListener {
            dialog.dismiss()
        }
        binding.btCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}