package com.coucouapp.ui.components.dashboard.adapters

import android.view.*
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.*
import androidx.recyclerview.widget.*
import com.coucouapp.R
import com.coucouapp.databinding.*

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