package com.coucouapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coucouapp.databinding.AdapterSavingGroupBinding


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