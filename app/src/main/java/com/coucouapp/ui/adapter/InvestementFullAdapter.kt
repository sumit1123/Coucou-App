package com.coucouapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coucouapp.databinding.AdapterInvestementFullBinding

class InvestementFullAdapter() : RecyclerView.Adapter<InvestementFullAdapter.ViewHolder>() {
  
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterInvestementFullBinding: AdapterInvestementFullBinding = AdapterInvestementFullBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        return ViewHolder(adapterInvestementFullBinding)
    }
  
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    
    }
  
    override fun getItemCount(): Int {
        return 10
    }
  
   inner class ViewHolder(adapterInvestementFullBinding: AdapterInvestementFullBinding) : RecyclerView.ViewHolder(adapterInvestementFullBinding.root) {
    
    }
}