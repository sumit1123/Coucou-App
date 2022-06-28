package com.coucouapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coucouapp.databinding.AdapterFriendsBinding


class FriendsAdapter() : RecyclerView.Adapter<FriendsAdapter.ViewHolder>() {
  
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterFriendsBinding: AdapterFriendsBinding = AdapterFriendsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        return ViewHolder(adapterFriendsBinding)
    }
  
  
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    
      
    }
  
    override fun getItemCount(): Int {
        return 10
    }
  
    class ViewHolder(adapterFriendsBinding: AdapterFriendsBinding) : RecyclerView.ViewHolder(adapterFriendsBinding.root) {
         private var adapterFriendsBinding: AdapterFriendsBinding? = null
    }
}