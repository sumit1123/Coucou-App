package com.coucouapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coucouapp.databinding.*

class AllNotificationsAdapter() : RecyclerView.Adapter<AllNotificationsAdapter.ViewHolder>() {
  
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterAllNotificationsBinding: AdapterAllNotificationBinding = AdapterAllNotificationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        return ViewHolder(adapterAllNotificationsBinding)
    }
  
  
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    
      
    }
  
    override fun getItemCount(): Int {
        return 10
    }
  
    class ViewHolder(val adapterAllNotificationsBinding: AdapterAllNotificationBinding) : RecyclerView.ViewHolder(adapterAllNotificationsBinding.root) {
    
    }
}