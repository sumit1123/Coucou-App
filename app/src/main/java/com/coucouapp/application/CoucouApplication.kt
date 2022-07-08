package com.coucouapp.application

import android.app.Application
import android.graphics.*
import com.zynksoftware.documentscanner.ui.*

open class CoucouApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initDocumentScanner()
    }
    
    private fun initDocumentScanner() {
        val configuration = DocumentScanner.Configuration()
        configuration.imageQuality = 100
        configuration.imageSize = 1000000
        configuration.imageType = Bitmap.CompressFormat.JPEG
        DocumentScanner.init(this, configuration)
    }
    
}