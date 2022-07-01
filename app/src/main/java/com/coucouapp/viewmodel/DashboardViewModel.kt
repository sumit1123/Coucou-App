package com.coucouapp.viewmodel

import android.annotation.*
import android.content.*
import android.provider.*
import androidx.lifecycle.*
import com.coucouapp.data.*
import com.coucouapp.ui.base.BaseViewModel
import kotlinx.coroutines.*

class DashboardViewModel : BaseViewModel() {
    
    var contactsLiveData = MutableLiveData<ArrayList<Contact>>()
    
    @SuppressLint("Range")
    fun getContacts(context: Context) {
        var contacts: ArrayList<Contact> = ArrayList()
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                contacts = ArrayList<Contact>()
                val cursor = context.contentResolver.query(
                    ContactsContract.Contacts.CONTENT_URI,
                    null,
                    null,
                    null,
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
                )
                if (cursor!!.count > 0) {
                    contacts.clear()
                    while (cursor.moveToNext()) {
                        val id =
                            cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))
                        val name =
                            cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                        val phoneNumber =
                            (cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))).toInt()
                        if (phoneNumber > 0) {
                            val cursorPhone = context.contentResolver.query(
                                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                                null,
                                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=?",
                                arrayOf(id),
                                null
                            )
                            if (cursorPhone!!.count > 0) {
                                while (cursorPhone.moveToNext()) {
                                    val phoneNumValue = cursorPhone.getString(
                                        cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                                    )
                                    contacts.add(Contact(name, phoneNumValue))
                                }
                                cursorPhone.close()
                            }
                        }
                    }
                    cursor.close()
                    contactsLiveData.postValue(contacts)
                }
            }
        }
    }
}