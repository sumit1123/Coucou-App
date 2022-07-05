package com.coucouapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.coucouapp.R
import com.coucouapp.databinding.LayoutTransactionHistoryBinding

class TransactionHistoryAdapter : RecyclerView.Adapter<TransactionHistoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: LayoutTransactionHistoryBinding = LayoutTransactionHistoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.root.setOnClickListener {
            findNavController(holder.binding.root).navigate(R.id.publiGroupDetailFragment)
        }
    }

    override fun getItemCount(): Int {
        return 10
    }

    inner class ViewHolder(val binding: LayoutTransactionHistoryBinding) :
        RecyclerView.ViewHolder(binding.root)
}