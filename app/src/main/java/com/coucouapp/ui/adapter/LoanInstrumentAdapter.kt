package com.coucouapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.coucouapp.R
import com.coucouapp.databinding.AdapterLoanInstrumentBinding


class LoanInstrumentAdapter(private val fragmentActivity: FragmentActivity) : RecyclerView.Adapter<LoanInstrumentAdapter.ViewHolder>() ,View.OnClickListener{
    
    private lateinit var adapterLoanInstrumentBinding: AdapterLoanInstrumentBinding
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        adapterLoanInstrumentBinding = AdapterLoanInstrumentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        return ViewHolder(adapterLoanInstrumentBinding)
    }
  
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        adapterLoanInstrumentBinding.btApply.setOnClickListener(this)
    }
  
    override fun getItemCount(): Int {
        return 10
    }
  
   inner class ViewHolder(adapterLoanInstrumentBinding: AdapterLoanInstrumentBinding) : RecyclerView.ViewHolder(adapterLoanInstrumentBinding.root) {
    
    }
    
    override fun onClick(v: View?) {
        when(v!!.id)
        {
            R.id.bt_apply ->
            {
                v.findNavController().navigate(R.id.personalLoanFragment)
            }
        }
    }
}