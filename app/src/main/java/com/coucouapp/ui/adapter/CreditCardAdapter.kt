package com.coucouapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coucouapp.databinding.AdapterCreditCardsBinding


class CreditCardAdapter() : RecyclerView.Adapter<CreditCardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterCreditCardsBinding: AdapterCreditCardsBinding =
            AdapterCreditCardsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(adapterCreditCardsBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 4
    }
  
   inner class ViewHolder(adapterCreditCardsBinding: AdapterCreditCardsBinding) : RecyclerView.ViewHolder(adapterCreditCardsBinding.root) {
    
    }
}