package com.coucouapp.ui.components.dashboard.adapters

import android.view.*
import androidx.recyclerview.widget.*
import com.coucouapp.databinding.*


class SavingGroupAdapter() : RecyclerView.Adapter<SavingGroupAdapter.ViewHolder>() {
  
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterSavingGroupBinding: AdapterSavingGroupBinding = AdapterSavingGroupBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        return ViewHolder(adapterSavingGroupBinding)
    }
  
  
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    
      
    }
  
    override fun getItemCount(): Int {
        return 10
    }
  
    class ViewHolder(adapterSavingGroupBinding: AdapterSavingGroupBinding) : RecyclerView.ViewHolder(adapterSavingGroupBinding.root) {
         private var adapterSavingGroupBinding: AdapterSavingGroupBinding? = null
    }
}