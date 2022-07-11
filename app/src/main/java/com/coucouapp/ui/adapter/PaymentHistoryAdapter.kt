package com.coucouapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coucouapp.databinding.*


class PaymentHistoryAdapter() : RecyclerView.Adapter<PaymentHistoryAdapter.ViewHolder>() {
  
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterPaymentHistoryBinding: AdapterPaymentHistoryBinding = AdapterPaymentHistoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        return ViewHolder(adapterPaymentHistoryBinding)
    }
  
  
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    
      
    }
  
    override fun getItemCount(): Int {
        return 10
    }
  
    class ViewHolder(val adapterPaymentHistoryBinding: AdapterPaymentHistoryBinding) : RecyclerView.ViewHolder(adapterPaymentHistoryBinding.root) {
    
    }
}