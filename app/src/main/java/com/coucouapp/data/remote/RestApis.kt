package com.coucouapp.data.remote

import com.coucouapp.model.api_request.*
import com.coucouapp.model.api_response.*
import retrofit2.http.*

interface RestApis {
    
    @POST("v1/login/")
    suspend fun doLoginApiCall(@Body apiRequest: ApiRequest): LoginResponse
}