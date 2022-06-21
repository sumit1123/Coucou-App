package com.coucouapp.ui.components.dashboard.adapters

import android.view.*
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.*
import androidx.recyclerview.widget.*
import com.coucouapp.R
import com.coucouapp.databinding.*


class LoanProductAdapter() : RecyclerView.Adapter<LoanProductAdapter.ViewHolder>() {
  
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterLoanProductBinding: AdapterLoanProductBinding = AdapterLoanProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        return ViewHolder(adapterLoanProductBinding)
    }
  
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }
  
    override fun getItemCount(): Int {
        return 3
    }
  
   inner class ViewHolder(adapterLoanProductBinding: AdapterLoanProductBinding) : RecyclerView.ViewHolder(adapterLoanProductBinding.root) {
    
    }
}