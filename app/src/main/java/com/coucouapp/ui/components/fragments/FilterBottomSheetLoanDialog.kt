package com.coucouapp.ui.components.fragments

import android.app.*
import android.graphics.*
import android.graphics.drawable.*
import android.os.*
import android.view.*
import com.coucouapp.*
import com.coucouapp.databinding.*
import com.google.android.material.bottomsheet.*

class FilterBottomSheetLoanDialog : BottomSheetDialogFragment(), View.OnClickListener {
    
    lateinit var fragmentFilterLoanBinding: FragmentFilterLoanBinding
    
    companion object {
        fun newInstance(): FilterBottomSheetLoanDialog? {
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
          R.id.bt_cancel ->
          {
               dismiss()
          }
          
        }
    }
    
    
}