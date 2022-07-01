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
import com.coucouapp.databinding.*
import com.coucouapp.ui.activity.CreateGroupVerificationActivity
import com.coucouapp.utils.Constants
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ApplyLoanBottomSheetDialog : BottomSheetDialogFragment(), View.OnClickListener {

    lateinit var fragmentApplyLoanBinding: FragmentApplyLoanBinding

    companion object {
        fun newInstance(): ApplyLoanBottomSheetDialog {
            return ApplyLoanBottomSheetDialog()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)
        return BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentApplyLoanBinding = FragmentApplyLoanBinding.inflate(inflater, container, false)
        return fragmentApplyLoanBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentApplyLoanBinding.btCancel.setOnClickListener(this)
        fragmentApplyLoanBinding.btApplyLoan.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.bt_cancel -> {
                dismiss()
            }

            R.id.bt_apply_loan -> {
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
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        binding.btYes.setOnClickListener {
            var intent = Intent(requireActivity(), CreateGroupVerificationActivity::class.java)
            intent.putExtra(Constants.TITLE, getString(R.string.loan_success_title))
            intent.putExtra(Constants.DESCRIPTION, getString(R.string.loan_success_description))
            startActivity(intent)
            dialog.dismiss()
        }
        binding.btCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}