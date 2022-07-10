package com.coucouapp.ui.fragment

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.databinding.DataBindingUtil
import com.coucouapp.R
import com.coucouapp.databinding.DialogCoucouBinding
import com.coucouapp.databinding.FragmentWithdrawFundsBinding
import com.coucouapp.model.PaymentMethodDetailsBean
import com.coucouapp.ui.activity.CreateGroupVerificationActivity
import com.coucouapp.ui.adapter.PaymentMethodDetailAdapter
import com.coucouapp.utils.Constants
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class WithdrawFundsBottomSheetDialogFragment : BottomSheetDialogFragment(),
    View.OnClickListener {
    private val TAG = WithdrawFundsBottomSheetDialogFragment::class.simpleName

    lateinit var binding: FragmentWithdrawFundsBinding
    private lateinit var paymentMethodDetailList: ArrayList<PaymentMethodDetailsBean>

    private var onRequestPaymentClick = 0

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
        paymentMethodDetailList = ArrayList()
        setPaymentMethodDetailData()
        binding.ivCancel.setOnClickListener(this)
        binding.tvRequestPaymentClick.setOnClickListener(this)

        /* binding.rvPaymentMethod.layoutManager = LinearLayoutManager(requireContext())
         binding.rvPaymentMethod.adapter = PaymentMethodAdapter(paymentMethodList)*/
    }

    private fun setPaymentMethodDetailData() {
        paymentMethodDetailList.add(
            PaymentMethodDetailsBean(
                "1",
                getString(R.string.choose_payment_channel),
                0
            )
        )
        paymentMethodDetailList.add(
            PaymentMethodDetailsBean(
                "1",
                getString(R.string.bank_transfer),
                R.drawable.ic_bank_transfer
            )
        )
        paymentMethodDetailList.add(
            PaymentMethodDetailsBean(
                "2",
                getString(R.string.atm_transfer),
                R.drawable.ic_atm_withdrawal
            )
        )
        paymentMethodDetailList.add(
            PaymentMethodDetailsBean(
                "3",
                getString(R.string.apple_cash),
                R.drawable.ic_apple_cash
            )
        )
        paymentMethodDetailList.add(
            PaymentMethodDetailsBean(
                "4",
                getString(R.string.octopus_wallet),
                R.drawable.ic_bank_transfer     //TODO: Change icon
            )
        )
        paymentMethodDetailList.add(
            PaymentMethodDetailsBean(
                "5",
                getString(R.string.we_chat_pay),
                R.drawable.ic_we_chat_pay
            )
        )
        paymentMethodDetailList.add(
            PaymentMethodDetailsBean(
                "5",
                getString(R.string.ali_pay),
                R.drawable.ic_ali_pay
            )
        )

        val paymentMethodDetailAdapter =
            PaymentMethodDetailAdapter(requireContext(), paymentMethodDetailList)

        binding.spPaymentMethod.adapter = paymentMethodDetailAdapter

        binding.spPaymentMethod.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    p1: View?,
                    pos: Int,
                    p3: Long
                ) {
                    Log.e(TAG, "pos: $pos")
                    when (pos) {
                        0 -> {
                            showLayout(
                                View.GONE,
                                View.GONE,
                                View.GONE,
                                View.GONE,
                                View.GONE,
                                View.GONE,
                                View.GONE
                            )
                            onRequestPaymentClick = 0
                        }
                        1 -> {
                            showLayout(
                                View.VISIBLE,
                                View.GONE,
                                View.GONE,
                                View.GONE,
                                View.GONE,
                                View.GONE,
                                View.VISIBLE
                            )
                            onRequestPaymentClick = 1
                        }
                        2 -> {
                            showLayout(
                                View.GONE,
                                View.VISIBLE,
                                View.GONE,
                                View.GONE,
                                View.GONE,
                                View.GONE,
                                View.VISIBLE
                            )
                            onRequestPaymentClick = 2
                        }
                        3 -> {
                            showLayout(
                                View.GONE,
                                View.GONE,
                                View.VISIBLE,
                                View.GONE,
                                View.GONE,
                                View.GONE,
                                View.VISIBLE
                            )
                            onRequestPaymentClick = 3
                        }
                        4 -> {
                            showLayout(
                                View.GONE,
                                View.GONE,
                                View.GONE,
                                View.VISIBLE,
                                View.GONE,
                                View.GONE,
                                View.VISIBLE
                            )
                            onRequestPaymentClick = 4
                        }
                        5 -> {
                            showLayout(
                                View.GONE,
                                View.GONE,
                                View.GONE,
                                View.GONE,
                                View.VISIBLE,
                                View.GONE,
                                View.VISIBLE
                            )
                            onRequestPaymentClick = 5
                        }
                        6 -> {
                            showLayout(
                                View.GONE,
                                View.GONE,
                                View.GONE,
                                View.GONE,
                                View.GONE,
                                View.VISIBLE,
                                View.VISIBLE
                            )
                            onRequestPaymentClick = 6
                        }
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }
    }

    private fun showLayout(
        visibilityBankTransfer: Int,  //1
        visibilityAtmWithdrawal: Int, //2
        visibilityAppleCash: Int,     //3
        visibilityOctopusWallet: Int, //4
        visibilityWeChatPay: Int,     //5
        visibilityAliPay: Int,        //6
        visibilityRequestPaymentClick: Int
    ) {
        binding.constraintBankDetail.visibility = visibilityBankTransfer
        binding.constraintAtmWithdrawal.visibility = visibilityAtmWithdrawal
        binding.tilAppleCash.visibility = visibilityAppleCash
        binding.constraintOctopusWallet.visibility = visibilityOctopusWallet
        binding.constraintWeChatPay.visibility = visibilityWeChatPay
        binding.constraintAliPay.visibility = visibilityAliPay
        binding.tvRequestPaymentClick.visibility = visibilityRequestPaymentClick
    }

    private fun confirmPaymentDialog(title: String, description: String) {
        val dialog = Dialog(requireActivity())
        val binding: DialogCoucouBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.dialog_coucou,
            null,
            false
        )
        dialog.setContentView(binding.root)
        binding.tvTitle.text = title
        binding.tvDescription.text = description
        val width = (resources.displayMetrics.widthPixels * 0.90).toInt()
        val height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog.window?.setLayout(width, height)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        binding.btCancel.text = getString(R.string.no_go_back)
        binding.btYes.setOnClickListener {
            dialog.dismiss()
            when (onRequestPaymentClick) {
                4 -> {
                    paymentComplete(
                        getString(R.string.octopus_wallet_payment_request_completed_title),
                        getString(R.string.octopus_wallet_payment_request_completed_description)
                    )
                }
                5 -> {
                    paymentComplete(
                        getString(R.string.we_chat_payment_request_completed_title),
                        getString(R.string.we_chat_payment_request_completed_description)
                    )
                }
                6 -> {
                    paymentComplete(
                        getString(R.string.ali_payment_request_completed_title),
                        getString(R.string.ali_payment_request_completed_description)
                    )
                }
            }
        }
        binding.btCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun paymentComplete(title: String, description: String) {
        val intent = Intent(requireActivity(), CreateGroupVerificationActivity::class.java)
        intent.putExtra(Constants.TITLE, title)
        intent.putExtra(Constants.DESCRIPTION, description)
        startActivity(intent)
    }

    private fun onRequestPaymentClick() {
        when (onRequestPaymentClick) {
            1 -> {
                paymentComplete(
                    getString(R.string.bank_payment_request_completed_title),
                    getString(R.string.bank_payment_request_completed_description)
                )
            }
            2 -> {
                paymentComplete(
                    getString(R.string.atm_payment_request_completed_title),
                    getString(R.string.atm_payment_request_completed_description)
                )
            }
            3 -> {
                paymentComplete(
                    getString(R.string.apple_cash_payment_request_completed_title),
                    getString(R.string.apple_cash_payment_request_completed_description)
                )
            }
            4 -> {
                confirmPaymentDialog(
                    getString(R.string.octopus_payment_request_title),
                    getString(R.string.octopus_payment_request_description)
                )
            }
            5 -> {
                confirmPaymentDialog(
                    getString(R.string.we_chat_payment_request_title),
                    getString(R.string.we_chat_payment_request_description)
                )
            }
            6 -> {
                confirmPaymentDialog(
                    getString(R.string.ali_payment_request_title),
                    getString(R.string.ali_payment_request_description)
                )
            }
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.ivCancel -> {
                dismiss()
            }
            R.id.tvRequestPaymentClick -> {
                onRequestPaymentClick()
            }
        }
    }
}