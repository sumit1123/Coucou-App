package com.coucouapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coucouapp.databinding.LayoutAllCreditCardsBinding


class AllCreditCardAdapter : RecyclerView.Adapter<AllCreditCardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: LayoutAllCreditCardsBinding =
            LayoutAllCreditCardsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 4
    }

    inner class ViewHolder(binding: LayoutAllCreditCardsBinding) :
        RecyclerView.ViewHolder(binding.root)
}