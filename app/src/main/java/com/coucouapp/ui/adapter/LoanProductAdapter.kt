package com.coucouapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coucouapp.databinding.AdapterLoanProductBinding


class LoanProductAdapter() : RecyclerView.Adapter<LoanProductAdapter.ViewHolder>() {
  
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterLoanProductBinding: AdapterLoanProductBinding = AdapterLoanProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        return ViewHolder(adapterLoanProductBinding)
    }
  
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }
  
    override fun getItemCount(): Int {
        return 3
    }
  
   inner class ViewHolder(adapterLoanProductBinding: AdapterLoanProductBinding) : RecyclerView.ViewHolder(adapterLoanProductBinding.root) {
    
    }
}