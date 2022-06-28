package com.coucouapp.ui.fragment

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.coucouapp.R
import com.coucouapp.databinding.DialogCreateGroupBinding
import com.coucouapp.databinding.FragmentCreateGroupBinding
import com.coucouapp.ui.activity.CreateGroupVerificationActivity
import com.coucouapp.ui.activity.DashBoardActivity
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.utils.Constants
import com.coucouapp.viewmodel.DashboardViewModel


class CreateGroupFragment : BaseFragment<DashboardViewModel, FragmentCreateGroupBinding>(),
    View.OnClickListener {
    lateinit var createGroupBinding: FragmentCreateGroupBinding

    override fun getLayout(): Int = R.layout.fragment_create_group

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        createGroupBinding = FragmentCreateGroupBinding.inflate(inflater, container, false)
        return createGroupBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createGroupBinding.btCreateGroup.setOnClickListener(this)
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
            getString(R.string.create_a_group)
        )
        (activity as DashBoardActivity).setToolbarBackground(R.color.snowGray)
        (activity as DashBoardActivity).setToolbarNotificationIcon(R.color.darkGray, View.VISIBLE)
    }

    override fun getViewModelClass(): Class<DashboardViewModel> {
        return DashboardViewModel::class.java
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.bt_create_group -> {
                showDialog()
            }
        }
    }

    private fun showDialog() {
        var dialog = Dialog(requireActivity())
        val binding: DialogCreateGroupBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.dialog_create_group,
            null,
            false
        )
        dialog.setContentView(binding.root)
        val width = (resources.displayMetrics.widthPixels * 0.90).toInt()
        val height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog.window?.setLayout(width, height)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        binding.btYes.setOnClickListener {
            val intent = Intent(requireActivity(), CreateGroupVerificationActivity::class.java)
            intent.putExtra(Constants.TITLE, getString(R.string.create_group))
            intent.putExtra(Constants.DESCRIPTION, getString(R.string.create_group_description))
            startActivity(intent)
            dialog.dismiss()
        }
        binding.btCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

}