package com.coucouapp.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CoucouApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

}