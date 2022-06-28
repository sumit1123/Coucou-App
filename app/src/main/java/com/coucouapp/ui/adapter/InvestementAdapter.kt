package com.coucouapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coucouapp.databinding.AdapterInvestementBinding


class InvestementAdapter() : RecyclerView.Adapter<InvestementAdapter.ViewHolder>() {
  
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterInvestementBinding: AdapterInvestementBinding = AdapterInvestementBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        return ViewHolder(adapterInvestementBinding)
    }
  
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    
    }
  
    override fun getItemCount(): Int {
        return 4
    }
  
   inner class ViewHolder(adapterInvestementBinding: AdapterInvestementBinding) : RecyclerView.ViewHolder(adapterInvestementBinding.root) {
    
    }
}