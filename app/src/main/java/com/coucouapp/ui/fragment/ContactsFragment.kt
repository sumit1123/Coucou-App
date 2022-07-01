package com.coucouapp.ui.fragment

import android.opengl.*
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.coucouapp.R
import com.coucouapp.data.*
import com.coucouapp.databinding.*
import com.coucouapp.ui.activity.DashBoardActivity
import com.coucouapp.ui.adapter.*
import com.coucouapp.ui.base.BaseFragment
import com.coucouapp.viewmodel.DashboardViewModel
import java.util.*

class ContactsFragment : BaseFragment<DashboardViewModel, FragmentContactsBinding>(),
    View.OnClickListener {

    lateinit var fragmentContactsBinding: FragmentContactsBinding
    override fun getLayout(): Int = R.layout.fragment_contacts
    lateinit var contactsAdapter: ContactsAdapter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentContactsBinding = FragmentContactsBinding.inflate(inflater, container, false)
        return fragmentContactsBinding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentContactsBinding.progressbar.visibility = View.VISIBLE
        mViewModel.getContacts(requireActivity())
        searchfilter()
        liveDataObservers()
    }
    
    private fun liveDataObservers() {
        mViewModel.contactsLiveData.observe(viewLifecycleOwner , {
            setRecyclerView(it)
            fragmentContactsBinding.progressbar.visibility = View.GONE
        })
    }
    
    private fun searchfilter() {
        fragmentContactsBinding.searchFilter.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
        
            override fun onQueryTextChange(newText: String?): Boolean {
                contactsAdapter.filter.filter(newText)
                return false
            }
        })
    }
    
    private fun setRecyclerView(contacts: List<Contact>) {
        contactsAdapter = ContactsAdapter(contacts)
        fragmentContactsBinding.recyclerviewContacts.layoutManager = LinearLayoutManager(requireContext())
        fragmentContactsBinding.recyclerviewContacts.adapter = contactsAdapter
    }
    
    override fun onResume() {
        super.onResume()
        setToolbar()
    }

    private fun setToolbar() {
        (activity as DashBoardActivity).setToolbarBackImage(View.VISIBLE, R.color.primary)
        (activity as DashBoardActivity).setToolbarTitle(
            View.VISIBLE,
            R.color.darkGray,
            getString(R.string.your_contac)
        )
        (activity as DashBoardActivity).setToolbarBackground(R.color.snowGray)
        (activity as DashBoardActivity).setToolbarNotificationIcon(R.color.darkGray, View.VISIBLE)
    }
    
    
    override fun getViewModelClass(): Class<DashboardViewModel> {
        return DashboardViewModel::class.java
    }
    
    override fun onClick(view: View?) {
        when (view?.id) {
        
        }
    }
}