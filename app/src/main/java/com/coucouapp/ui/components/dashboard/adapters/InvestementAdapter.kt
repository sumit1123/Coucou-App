package com.coucouapp.ui.components.dashboard.adapters

import android.view.*
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.*
import androidx.recyclerview.widget.*
import com.coucouapp.R
import com.coucouapp.databinding.*


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