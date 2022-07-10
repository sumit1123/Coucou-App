package com.coucouapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coucouapp.R
import com.coucouapp.databinding.LayoutPaymentMethodBinding
import com.coucouapp.model.PaymentMethodBean
import com.coucouapp.model.PaymentMethodDetailsBean


class PaymentMethodAdapter(paymentMethodList: List<PaymentMethodBean>) :
    RecyclerView.Adapter<PaymentMethodAdapter.ViewHolder>() {


    private var paymentMethodList: List<PaymentMethodBean>? = paymentMethodList
    private lateinit var paymentMethodDetailList: ArrayList<PaymentMethodDetailsBean>


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: LayoutPaymentMethodBinding =
            LayoutPaymentMethodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        setPaymentDetailData()

        val paymentMethodBean = paymentMethodList!![position]

        holder.binding.tvChoosePaymentChannel.text = paymentMethodBean.name
        /* holder.binding.rvPaymentMethodDetail.adapter =
             PaymentMethodDetailAdapter(paymentMethodDetailList)*/

        holder.binding.ivChoosePaymentChannel.setOnClickListener { onItemClicked(paymentMethodBean) }
        if (paymentMethodBean.isExpanded) {
            holder.binding.rvPaymentMethodDetail.visibility = View.VISIBLE
            holder.binding.ivChoosePaymentChannel.setImageResource(R.drawable.ic_arrow_up)
        } else {
            holder.binding.rvPaymentMethodDetail.visibility = View.GONE
            holder.binding.ivChoosePaymentChannel.setImageResource(R.drawable.ic_arrow_down)
        }
    }

    private fun setPaymentDetailData() {

        paymentMethodDetailList = ArrayList()

        val paymentMethodDetailBean =
            PaymentMethodDetailsBean("1", "Bank transfer", R.drawable.ic_account_balance)
        paymentMethodDetailList.add(paymentMethodDetailBean)

    }

    override fun getItemCount(): Int {
        return paymentMethodList?.size ?: 0
    }

    private fun onItemClicked(paymentMethodBean: PaymentMethodBean?) {
        paymentMethodBean?.isExpanded = !paymentMethodBean?.isExpanded!!
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: LayoutPaymentMethodBinding) :
        RecyclerView.ViewHolder(binding.root)
}