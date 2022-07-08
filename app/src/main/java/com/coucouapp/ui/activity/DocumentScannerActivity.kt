package com.coucouapp.ui.activity

import android.os.Bundle
import android.util.*
import com.coucouapp.R
import com.coucouapp.databinding.*
import com.coucouapp.ui.base.BaseActivity
import com.coucouapp.viewmodel.LogInViewModel
import com.otaliastudios.cameraview.controls.*
import com.zynksoftware.documentscanner.*
import com.zynksoftware.documentscanner.model.*
import husaynhakeem.io.facedetector.*
import kotlinx.android.synthetic.main.activity_face_detection.*
import kotlinx.android.synthetic.main.activity_log_in.*

class DocumentScannerActivity : ScanActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_document_scan)
        addFragmentContentLayout()
       
    }
    
    override fun onError(error: DocumentScannerErrorModel) {
        TODO("Not yet implemented")
    }
    
    override fun onSuccess(scannerResults: ScannerResults) {
        TODO("Not yet implemented")
    }
    
    override fun onClose() {
       finish()
    }
    
}