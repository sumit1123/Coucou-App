package com.coucouapp.ui.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coucouapp.R
import com.coucouapp.databinding.FragmentFilterLoanBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FilterBottomSheetLoanDialog : BottomSheetDialogFragment(), View.OnClickListener {

    lateinit var fragmentFilterLoanBinding: FragmentFilterLoanBinding
    companion object {
        fun newInstance(): FilterBottomSheetLoanDialog {
            return FilterBottomSheetLoanDialog()
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
        fragmentFilterLoanBinding = FragmentFilterLoanBinding.inflate(inflater, container, false)
        return fragmentFilterLoanBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentFilterLoanBinding.btCancel.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.bt_cancel -> {
                dismiss()
            }

        }
    }
}