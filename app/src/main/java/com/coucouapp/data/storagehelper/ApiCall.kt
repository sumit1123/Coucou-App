package com.coucouapp.data.storagehelper

import com.coucouapp.data.repository.*
import kotlinx.coroutines.*
import retrofit2.HttpException

interface ApiCall {
    suspend fun <T> apiCall(apiCall: suspend () -> T): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> {
                        Resource.error(throwable.message, null, throwable.message()+"")
                    }
                    else -> {
                        Resource.error(throwable.message, null, throwable.message+"")
                    }
                }
            }
        }
    }
}