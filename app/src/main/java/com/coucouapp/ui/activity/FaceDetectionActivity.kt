package com.coucouapp.ui.activity

import android.os.Bundle
import android.util.*
import com.coucouapp.R
import com.coucouapp.databinding.*
import com.coucouapp.ui.base.BaseActivity
import com.coucouapp.viewmodel.LogInViewModel
import com.otaliastudios.cameraview.controls.*
import husaynhakeem.io.facedetector.*
import kotlinx.android.synthetic.main.activity_face_detection.*
import kotlinx.android.synthetic.main.activity_log_in.*

class FaceDetectionActivity : BaseActivity<LogInViewModel, ActivityFaceDetectionBinding>(){

    override fun getLayout(): Int = R.layout.activity_face_detection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_face_detection)
        val lensFacing = savedInstanceState?.getSerializable(KEY_LENS_FACING) as Facing? ?: Facing.BACK
        setupCamera(lensFacing)
       
    }

    override fun showMsg(msgId: Int) {
        TODO("Not yet implemented")
    }

    override fun showMsg(msg: String) {
        TODO("Not yet implemented")
    }

    override fun getViewModelClass(): Class<LogInViewModel> {
        return LogInViewModel::class.java
    }
    
    
    override fun onResume() {
        super.onResume()
        viewfinder.open()
    }
    
    override fun onPause() {
        super.onPause()
        viewfinder.stopVideo()
    }
    
    private fun setupCamera(lensFacing: Facing) {
        val faceDetector = FaceDetector(faceBoundsOverlay)
        viewfinder.facing = lensFacing
        viewfinder.addFrameProcessor {
            faceDetector.process(
                Frame(
                    data = it.getData(),
                    rotation = it.rotation,
                    size = Size(it.size.width, it.size.height),
                    format = it.format,
                    lensFacing = if (viewfinder.facing == Facing.BACK) LensFacing.BACK else LensFacing.FRONT
                )
            )
        }
        toggleCameraButton.setOnClickListener {
            viewfinder.toggleFacing()
        }
    }
    
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putSerializable(KEY_LENS_FACING, viewfinder.facing)
        super.onSaveInstanceState(outState)
    }
    
    companion object {
        private const val KEY_LENS_FACING = "key-lens-facing"
    }
    
    override fun onDestroy() {
        super.onDestroy()
        viewfinder.destroy()
    }
}