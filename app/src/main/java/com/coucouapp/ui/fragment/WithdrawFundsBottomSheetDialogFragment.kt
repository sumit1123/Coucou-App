package com.coucouapp.ui.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coucouapp.R
import com.coucouapp.databinding.FragmentWithdrawFundsBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class WithdrawFundsBottomSheetDialogFragment : BottomSheetDialogFragment(),
    View.OnClickListener {

    lateinit var binding: FragmentWithdrawFundsBinding

    companion object {
        fun newInstance(): WithdrawFundsBottomSheetDialogFragment {
            return WithdrawFundsBottomSheetDialogFragment()
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
        binding = FragmentWithdrawFundsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        binding.ivCancel.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.ivCancel -> {
                dismiss()
            }
        }
    }
}