package com.coucouapp.data.repository

import android.content.Context
import com.coucouapp.*
import com.coucouapp.data.remote.*
import com.coucouapp.data.storagehelper.*
import com.coucouapp.database.*
import com.coucouapp.database.datastore.*
import com.coucouapp.model.api_request.*
import com.coucouapp.model.api_response.*
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class CoucouRepository @Inject constructor(
    @ApplicationContext val context: Context,
    private val remoteRepository: RemoteHelper,
    private val coucouDataStore: CoucouDataStore,
    private val coucouDb: CoucouDb
) : ApiCall {
    
    fun getAppDB() = coucouDb
    fun getDataStoreContext() = coucouDataStore
    
    fun provideLocalRemoteRepository(): IRestHelper {
        return if (BuildConfig.BUILD_TYPE.equals("release", ignoreCase = true)) {
            remoteRepository
        } else {
            remoteRepository
        }
        return remoteRepository!!
    }

    suspend fun doLogin(apiRequest: ApiRequest): Flow<Resource<LoginResponse>> {
        val loginResponse = provideLocalRemoteRepository().doLogin(apiRequest)
        return flow {
            emit(loginResponse)
        }.flowOn(Dispatchers.IO)
    }
}




