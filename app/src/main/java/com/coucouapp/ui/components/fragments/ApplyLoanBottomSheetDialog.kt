package com.coucouapp.ui.components.fragments

import android.app.*
import android.content.*
import android.graphics.*
import android.graphics.drawable.*
import android.os.*
import android.view.*
import androidx.databinding.*
import com.coucouapp.*
import com.coucouapp.databinding.*
import com.coucouapp.ui.components.*
import com.coucouapp.utils.*
import com.google.android.material.bottomsheet.*

class ApplyLoanBottomSheetDialog : BottomSheetDialogFragment(), View.OnClickListener {
    
    lateinit var fragmentApplyLoanBinding: FragmentApplyLoanBinding
    
    companion object {
        fun newInstance(): ApplyLoanBottomSheetDialog? {
            return ApplyLoanBottomSheetDialog()
        }
    }
    
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)
        return BottomSheetDialog(requireContext() ,R.style.BottomSheetDialogTheme)
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
          R.id.bt_cancel ->
          {
               dismiss()
          }
          
         R.id.bt_apply_loan ->
         {
             showDialog()
         }
          
        }
    }
    
    private fun showDialog() {
        var dialog = Dialog(requireActivity())
        val binding: DialogApplyLoanBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.dialog_apply_loan,
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
            intent.putExtra(Constants.TITLE, getString(R.string.loan_sucess_title))
            intent.putExtra(Constants.DESCRIPTION, getString(R.string.loan_sucess_descripton))
            startActivity(intent)
            dialog.dismiss()
        }
        binding.btCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}