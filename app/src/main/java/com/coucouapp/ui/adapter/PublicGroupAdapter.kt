package com.coucouapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.coucouapp.R
import com.coucouapp.databinding.AdapterPublicGroupBinding


class PublicGroupAdapter() : RecyclerView.Adapter<PublicGroupAdapter.ViewHolder>() {
  
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterPublicGroupBinding: AdapterPublicGroupBinding = AdapterPublicGroupBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        return ViewHolder(adapterPublicGroupBinding)
    }
  
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.adapterPublicGroupBinding.root.setOnClickListener {
            findNavController(holder.adapterPublicGroupBinding.root).navigate(R.id.publiGroupDetailFragment)
        }
      
    }
  
    override fun getItemCount(): Int {
        return 10
    }
  
   inner class ViewHolder(val adapterPublicGroupBinding: AdapterPublicGroupBinding) : RecyclerView.ViewHolder(adapterPublicGroupBinding.root) {
    
    }
}