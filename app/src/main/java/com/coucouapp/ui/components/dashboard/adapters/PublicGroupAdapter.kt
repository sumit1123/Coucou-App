package com.coucouapp.ui.components.dashboard.adapters

import android.view.*
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.*
import androidx.recyclerview.widget.*
import com.coucouapp.R
import com.coucouapp.databinding.*


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