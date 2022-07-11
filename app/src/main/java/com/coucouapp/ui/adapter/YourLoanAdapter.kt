package com.coucouapp.ui.adapter

import android.view.*
import androidx.fragment.app.*
import androidx.navigation.*
import androidx.recyclerview.widget.RecyclerView
import com.coucouapp.*
import com.coucouapp.R
import com.coucouapp.databinding.*
import kotlinx.android.synthetic.main.adapter_credit_cards.view.*

class YourLoanAdapter(private val fragmentActivity: FragmentActivity) : RecyclerView.Adapter<YourLoanAdapter.ViewHolder>() {
  
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterYourLoanBinding: AdapterYourLoanBinding = AdapterYourLoanBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        return ViewHolder(adapterYourLoanBinding)
    }
  
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.adapterYourLoanBinding.btPayLoan.setOnClickListener{
            Navigation.findNavController(holder.adapterYourLoanBinding.root).navigate(R.id.payPersonalLoanFragment)
        }
        holder.adapterYourLoanBinding.btPayHistory.setOnClickListener{
            Navigation.findNavController(holder.adapterYourLoanBinding.root).navigate(R.id.paymentHistoryFragment)
        }
    }
  
    override fun getItemCount(): Int {
        return 3
    }
    
    class ViewHolder(val adapterYourLoanBinding: AdapterYourLoanBinding) : RecyclerView.ViewHolder(adapterYourLoanBinding.root) {
    
    }
    
  
}