package com.coucouapp.ui.fragment

import android.app.*
import android.content.*
import android.graphics.*
import android.graphics.drawable.*
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.*
import androidx.navigation.fragment.findNavController
import com.coucouapp.R
import com.coucouapp.databinding.*
import com.coucouapp.ui.activity.*
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.utils.*
import com.coucouapp.viewmodel.DashboardViewModel

class PayPersonalLoanFragment : BaseFragment<DashboardViewModel, FragmentPayPersonalLoanBinding>(),
    View.OnClickListener {
    lateinit var fragmentPayPersonalLoanFragment: FragmentPayPersonalLoanBinding

    override fun getLayout(): Int = R.layout.fragment_pay_personal_loan

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentPayPersonalLoanFragment =
            FragmentPayPersonalLoanBinding.inflate(inflater, container, false)
        return fragmentPayPersonalLoanFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentPayPersonalLoanFragment.btPayLoan.setOnClickListener(this)
        initview()

    }
    
    private fun initview() {
        val list_of_items = arrayOf(resources.getString(R.string.credit_card))
        fragmentPayPersonalLoanFragment.paymentModeSpinner.prompt = resources.getString(R.string.choose_a_pa)
        val payment_mode_adapter = ArrayAdapter(requireActivity(), R.layout.dropdown_menu_popup_item_icon, list_of_items)
        payment_mode_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        fragmentPayPersonalLoanFragment.paymentModeSpinner.setAdapter(payment_mode_adapter)
    }
    
    override fun onResume() {
        super.onResume()
        setToolbar()
    }

    private fun setToolbar() {
        (activity as DashBoardActivity).setToolbarBackImage(View.VISIBLE, R.color.primary)
        (activity as DashBoardActivity).setToolbarTitle(
            View.VISIBLE,
            R.color.primary,
            getString(R.string.personal_loan)
        )
        (activity as DashBoardActivity).setToolbarBackground(R.color.snowGray)
        (activity as DashBoardActivity).setToolbarNotificationIcon(R.color.darkGray, View.VISIBLE)
    }

    override fun getViewModelClass(): Class<DashboardViewModel> {
        return DashboardViewModel::class.java
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.bt_pay_loan -> {
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
        binding.tvTitle.setText(resources.getString(R.string.pay_for_loan))
        binding.tvDescription.setText(resources.getString(R.string.you_are_abo))
        val width = (resources.displayMetrics.widthPixels * 0.90).toInt()
        val height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog.getWindow()?.setLayout(width, height)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        binding.btYes.setOnClickListener {
            var intent = Intent(requireActivity(), CreateGroupVerificationActivity::class.java)
            intent.putExtra(Constants.TITLE, getString(R.string.loan_paymen))
            intent.putExtra(Constants.DESCRIPTION, getString(R.string.your_paymen))
            startActivity(intent)
            dialog.dismiss()
        }
        binding.btCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

}