package com.coucouapp.ui.components.fragments

import android.app.*
import android.os.*
import android.view.*
import com.coucouapp.*
import com.coucouapp.databinding.*
import com.google.android.material.bottomsheet.*

class FilterBottomSheetCreaditCardDialog : BottomSheetDialogFragment(), View.OnClickListener {
    
    lateinit var fragmentFilterBinding: FragmentFilterBinding
    
    companion object {
        fun newInstance(): FilterBottomSheetCreaditCardDialog? {
            return FilterBottomSheetCreaditCardDialog()
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
        fragmentFilterBinding = FragmentFilterBinding.inflate(inflater, container, false)
        return fragmentFilterBinding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentFilterBinding.btCancel.setOnClickListener(this)
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