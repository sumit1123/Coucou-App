package com.coucouapp.database.datastore

import android.content.Context
import androidx.datastore.core.*
import androidx.datastore.preferences.*
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.core.Preferences
import com.coucouapp.utils.Constants.PREF_NAME
import com.coucouapp.utils.Constants.STORE_NAME
import kotlinx.coroutines.flow.*
import java.util.prefs.*
import javax.inject.Inject

/*
Datastore runs on a separate thread which makes it thread-safe
Async API for storing and reading the data (Flow)
Safe to call from UI thread (Dispatchers.IO underneath)
-> Preferences Datastore
-> Proto Datastore
 */
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = STORE_NAME,
    produceMigrations = { context -> listOf(SharedPreferencesMigration(context, PREF_NAME)) })


class CoucouDataStore @Inject constructor(private val context: Context) {

    suspend fun putString(key: String, value: String) {
        val preferencesKey = stringPreferencesKey(key)
        context.dataStore.edit { preferences ->
            preferences[preferencesKey] = value
        }
    }

    suspend fun putLong(key: String, value: Long) {
        val preferencesKey = longPreferencesKey(key)
        context.dataStore.edit { preferences ->
            preferences[preferencesKey] = value
        }
    }

    suspend fun putBoolean(key: String, value: Boolean) {
        val preferencesKey = booleanPreferencesKey(key)
        context.dataStore.edit { preferences ->
            preferences[preferencesKey] = value
        }
    }


    suspend fun putDouble(key: String, value: Double) {
        val preferencesKey = doublePreferencesKey(key)
        context.dataStore.edit { preferences ->
            preferences[preferencesKey] = value
        }
    }

    suspend fun getLong(Key: String): Long? {
        return try {
            val preferencesKey = longPreferencesKey(Key)
            val preferences = context.dataStore.data.first()
            preferences[preferencesKey]
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    suspend fun getString(Key: String): String? {
        return try {
            val preferencesKey = stringPreferencesKey(Key)
            val preferences = context.dataStore.data.first()
            preferences[preferencesKey]
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    suspend fun getBoolean(Key: String): Boolean? {
        return try {
            val preferencesKey = booleanPreferencesKey(Key)
            val preferences = context.dataStore.data.first()
            preferences[preferencesKey]
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }


    suspend fun getDouble(Key: String): Double? {
        return try {
            val preferencesKey = doublePreferencesKey(Key)
            val preferences = context.dataStore.data.first()
            preferences[preferencesKey]
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
    
    suspend fun clearDataStore()
    {
        context.dataStore.edit {
            it.clear()
        }
    }
}