package com.coucouapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.coucouapp.databinding.LayoutMySavingGroupsBinding
import com.coucouapp.ui.interfaces.OnClickMySavingGroup


class MySavingGroupsAdapter(
    val context: Context,
    private val onClickMySavingGroup: OnClickMySavingGroup
) :
    RecyclerView.Adapter<MySavingGroupsAdapter.ViewHolder>() {

    private lateinit var contributorsAdapter: ContributorsAdapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: LayoutMySavingGroupsBinding = LayoutMySavingGroupsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.rvContributors.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        contributorsAdapter = ContributorsAdapter()
        holder.binding.rvContributors.adapter = contributorsAdapter
        contributorsAdapter.notifyDataSetChanged()

        holder.binding.ivAddContribution.setOnClickListener {
            onClickMySavingGroup.onAddContribution()
        }
        holder.binding.tvAddContribution.setOnClickListener {
            onClickMySavingGroup.onAddContribution()
        }

        holder.binding.ivRequestPayment.setOnClickListener {
            onClickMySavingGroup.onClickRequestPayment()
        }
        holder.binding.tvRequestPayment.setOnClickListener {
            onClickMySavingGroup.onClickRequestPayment()
        }

        holder.binding.ivTransactionHistory.setOnClickListener {
            onClickMySavingGroup.onClickTransactionHistory()
        }
        holder.binding.tvTransactionHistory.setOnClickListener {
            onClickMySavingGroup.onClickTransactionHistory()
        }
        holder.binding.ivWithDrawFunds.setOnClickListener {
            onClickMySavingGroup.onClickWithdrawFunds()
        }
        holder.binding.tvWithDrawFunds.setOnClickListener {
            onClickMySavingGroup.onClickWithdrawFunds()
        }
    }

    override fun getItemCount(): Int {
        return 10
    }

    inner class ViewHolder(var binding: LayoutMySavingGroupsBinding) :
        RecyclerView.ViewHolder(binding.root)
}