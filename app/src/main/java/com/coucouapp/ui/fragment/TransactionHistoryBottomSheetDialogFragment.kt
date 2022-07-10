package com.coucouapp.ui.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.coucouapp.R
import com.coucouapp.databinding.FragmentTransactionHistoryBinding
import com.coucouapp.ui.adapter.TransactionHistoryAdapter
import com.coucouapp.ui.interfaces.OnClickTransactionHistory
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class TransactionHistoryBottomSheetDialogFragment : BottomSheetDialogFragment(),
    OnClickTransactionHistory,
    View.OnClickListener {

    lateinit var binding: FragmentTransactionHistoryBinding

    companion object {
        fun newInstance(): TransactionHistoryBottomSheetDialogFragment {
            return TransactionHistoryBottomSheetDialogFragment()
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
        binding = FragmentTransactionHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        binding.ivCancel.setOnClickListener(this)

        binding.rvRequestPayment.layoutManager = LinearLayoutManager(requireContext())
        binding.rvRequestPayment.adapter = TransactionHistoryAdapter(this)

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.ivCancel -> {
                dismiss()
            }
        }
    }

    override fun onClickTransactionHistory() {
        dismiss()
        findNavController().navigate(R.id.publiGroupDetailFragment)
    }
}