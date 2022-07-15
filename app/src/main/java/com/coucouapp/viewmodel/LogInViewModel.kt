package com.coucouapp.viewmodel

import androidx.lifecycle.*
import com.coucouapp.data.repository.*
import com.coucouapp.model.api_request.*
import com.coucouapp.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.*

@HiltViewModel
class LogInViewModel @Inject constructor(val coucouRepository: CoucouRepository) : BaseViewModel() {
    
    fun doLogin(apiRequest: ApiRequest)
    {
        viewModelScope.launch {
                coucouRepository.doLogin(apiRequest).collect{
                     coucouRepository.doLogin(apiRequest)
                }
        }
    }
}