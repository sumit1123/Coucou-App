package com.coucouapp.data.storagehelper

import com.coucouapp.data.remote.*
import com.coucouapp.data.repository.*
import com.coucouapp.model.api_request.*
import com.coucouapp.model.api_response.*
import javax.inject.Inject

class RemoteHelper @Inject constructor(private val restApi: RestApis) : IRestHelper, ApiCall {
    
    override suspend fun doLogin(apiRequest: ApiRequest): Resource<LoginResponse> {
        return apiCall { (restApi.doLoginApiCall(apiRequest)) }
    }
    
    
}