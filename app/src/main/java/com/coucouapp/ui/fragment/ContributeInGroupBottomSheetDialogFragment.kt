package com.coucouapp.ui.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.coucouapp.R
import com.coucouapp.databinding.FragmentContributeInGroupBinding
import com.coucouapp.ui.adapter.PublicGroupAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ContributeInGroupBottomSheetDialogFragment : BottomSheetDialogFragment(),
    View.OnClickListener {

    lateinit var binding: FragmentContributeInGroupBinding

    companion object {
        fun newInstance(): ContributeInGroupBottomSheetDialogFragment {
            return ContributeInGroupBottomSheetDialogFragment()
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
        binding = FragmentContributeInGroupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        binding.ivCancel.setOnClickListener(this)

        binding.rvGroup.layoutManager = LinearLayoutManager(requireContext())
        binding.rvGroup.adapter = PublicGroupAdapter()

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.ivCancel -> {
                dismiss()
            }
        }
    }
}