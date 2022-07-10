package com.coucouapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.coucouapp.R
import com.coucouapp.model.PaymentMethodDetailsBean
import kotlinx.android.synthetic.main.layout_payment_method_detail.view.*


class PaymentMethodDetailAdapter(
    context: Context,
    paymentMethodDetailList: ArrayList<PaymentMethodDetailsBean>
) :
    ArrayAdapter<PaymentMethodDetailsBean>(context, 0, paymentMethodDetailList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createItemView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createItemView(position, convertView, parent)
    }

    private fun createItemView(position: Int, recycledView: View?, parent: ViewGroup): View {
        val country = getItem(position)

        val view = recycledView ?: LayoutInflater.from(context).inflate(
            R.layout.layout_payment_method_detail,
            parent,
            false
        )

        country?.let {
            view.ivChoosePaymentChannel.setImageResource(country.image)
            view.tvChoosePaymentChannel.text = country.name
        }
        return view
    }
}


/*
class PaymentMethodDetailAdapter(val paymentMethodDetailList: List<PaymentMethodDetailsBean>) :
    RecyclerView.Adapter<PaymentMethodDetailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: LayoutPaymentMethodDetailBinding =
            LayoutPaymentMethodDetailBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val paymentMethodDetailsBean = paymentMethodDetailList[position]
        holder.binding.tvChoosePaymentChannel.text = paymentMethodDetailsBean.name
    }

    override fun getItemCount(): Int {
        return paymentMethodDetailList.size
    }

    class ViewHolder(val binding: LayoutPaymentMethodDetailBinding) :
        RecyclerView.ViewHolder(binding.root)
}*/
