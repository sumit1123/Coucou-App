package com.coucouapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.*
import android.widget.Filter
import androidx.recyclerview.widget.RecyclerView
import com.coucouapp.data.*
import com.coucouapp.databinding.*
import java.util.*
import kotlin.collections.ArrayList


class ContactsAdapter(private val contacts: List<Contact>) :
    RecyclerView.Adapter<ContactsAdapter.ViewHolder>(), Filterable {
    
    var contactfilterlist: List<Contact> = ArrayList()
    
    init {
        contactfilterlist = contacts
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterContactsBinding: AdapterContactsBinding =
            AdapterContactsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        return ViewHolder(adapterContactsBinding)
    }
    
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.adapterContactsBinding.contactName.text = contactfilterlist[position].name
        holder.adapterContactsBinding.contactNumber.text = contactfilterlist[position].number
    }
    
    override fun getItemCount(): Int {
        return contactfilterlist.size
    }
    
    inner class ViewHolder(val adapterContactsBinding: AdapterContactsBinding) :
        RecyclerView.ViewHolder(adapterContactsBinding.root) {
        
    }
    
    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    contactfilterlist = contacts
                } else {
                    val resultList = ArrayList<Contact>()
                    for (row in contacts) {
                        if (row.name.lowercase().startsWith(charSearch.lowercase())) {
                            resultList.add(row)
                        }
                    }
                    contactfilterlist = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = contactfilterlist
                return filterResults
            }
            
            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                contactfilterlist = results?.values as ArrayList<Contact>
                notifyDataSetChanged()
            }
            
        }
    }
}