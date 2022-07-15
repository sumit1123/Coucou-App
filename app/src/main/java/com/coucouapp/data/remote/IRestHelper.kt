package com.coucouapp.data.remote

import com.coucouapp.data.repository.*
import com.coucouapp.model.api_request.*
import com.coucouapp.model.api_response.*

interface IRestHelper {
    
    suspend fun doLogin(apiRequest: ApiRequest): Resource<LoginResponse>
}