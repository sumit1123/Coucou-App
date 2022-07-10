package com.coucouapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coucouapp.databinding.LayoutTransactionHistoryBinding
import com.coucouapp.ui.interfaces.OnClickTransactionHistory

class TransactionHistoryAdapter(
    private val onClickTransactionHistory: OnClickTransactionHistory
) : RecyclerView.Adapter<TransactionHistoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val transactionHistoryBinding: LayoutTransactionHistoryBinding =
            LayoutTransactionHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(transactionHistoryBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.transactionHistoryBinding.root.setOnClickListener {
            onClickTransactionHistory.onClickTransactionHistory()
            /*Navigation.findNavController(holder.transactionHistoryBinding.root)
                .navigate(R.id.publiGroupDetailFragment)*/
        }
    }

    override fun getItemCount(): Int {
        return 10
    }

    inner class ViewHolder(val transactionHistoryBinding: LayoutTransactionHistoryBinding) :
        RecyclerView.ViewHolder(transactionHistoryBinding.root)
}
