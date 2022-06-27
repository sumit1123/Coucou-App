package com.coucouapp.ui.components.dashboard.fragments

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
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.ui.components.CreateGroupVerificationActivity
import com.coucouapp.ui.components.dashboard.DashBoardScreen
import com.coucouapp.ui.components.dashboard.viewmodel.DashboardViewModel
import com.coucouapp.utils.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CreateGroupFragment : BaseFragment<DashboardViewModel, FragmentCreateGroupBinding>(),
    View.OnClickListener {
    private var param1: String? = null
    private var param2: String? = null
    lateinit var createGroupBinding: FragmentCreateGroupBinding

    override fun getLayout(): Int = R.layout.fragment_create_group

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createGroupBinding.btCreateGroup.setOnClickListener(this)
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
            getString(R.string.create_a_group)
        )
        (activity as DashBoardScreen).setToolbarBackground(R.color.market_gray)
        (activity as DashBoardScreen).setToolbarNotificationIcon(R.color.darkGray, View.VISIBLE)
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
        dialog.setContentView(binding.getRoot())
        val width = (resources.displayMetrics.widthPixels * 0.90).toInt()
        val height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog.getWindow()?.setLayout(width, height)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        binding.btYes.setOnClickListener {
            var intent = Intent(requireActivity(), CreateGroupVerificationActivity::class.java)
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