package com.coucouapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.text.*
import android.view.*
import android.widget.*
import com.coucouapp.R
import com.coucouapp.databinding.ActivityOtpVerificationBinding
import com.coucouapp.ui.base.BaseActivity
import com.coucouapp.utils.Constants
import com.coucouapp.viewmodel.OtpVerificationViewModel
import kotlinx.android.synthetic.main.activity_otp_verification.*

class OtpVerificationActivity :
    BaseActivity<OtpVerificationViewModel, ActivityOtpVerificationBinding>() {

    private val TAG = OtpVerificationActivity::class.simpleName

    override fun getLayout(): Int = R.layout.activity_otp_verification

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_verification)
        initViews()
    }

    private fun initViews() {
        et_otp1.addTextChangedListener(GenericTextWatcher(et_otp1, et_otp2))
        et_otp2.addTextChangedListener(GenericTextWatcher(et_otp2, et_otp3))
        et_otp3.addTextChangedListener(GenericTextWatcher(et_otp3, et_otp4))
        et_otp4.addTextChangedListener(GenericTextWatcher(et_otp4, et_otp5))
        et_otp5.addTextChangedListener(GenericTextWatcher(et_otp5, null))
    
        et_otp1.setOnKeyListener(GenericKeyEvent(et_otp1, null))
        et_otp2.setOnKeyListener(GenericKeyEvent(et_otp2, et_otp1))
        et_otp3.setOnKeyListener(GenericKeyEvent(et_otp3, et_otp2))
        et_otp4.setOnKeyListener(GenericKeyEvent(et_otp4,et_otp3))
        et_otp5.setOnKeyListener(GenericKeyEvent(et_otp5,et_otp4))
    
        tvContinue.setOnClickListener {
            val intent = Intent(this, UserVerifiedActivity::class.java)
            intent.putExtra(Constants.USER_VERIFICATION, Constants.FROM_OTP_VERIFICATION)
            startActivity(intent)
        }
    }

    override fun showMsg(msgId: Int) {
        TODO("Not yet implemented")
    }

    override fun showMsg(msg: String) {
        TODO("Not yet implemented")
    }

    override fun getViewModelClass(): Class<OtpVerificationViewModel> {
        return OtpVerificationViewModel::class.java
    }
    class GenericKeyEvent internal constructor(private val currentView: EditText, private val previousView: EditText?) : View.OnKeyListener{
        override fun onKey(p0: View?, keyCode: Int, event: KeyEvent?): Boolean {
            if(event!!.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL && currentView.id != R.id.et_otp1 && currentView.text.isEmpty()) {
                //If current is empty then previous EditText's number will also be deleted
                previousView!!.text = null
                previousView.requestFocus()
                return true
            }
            return false
        }
        
        
    }
    
    class GenericTextWatcher internal constructor(private val currentView: View, private val nextView: View?) :
        TextWatcher {
        override fun afterTextChanged(editable: Editable) { // TODO Auto-generated method stub
            val text = editable.toString()
            when (currentView.id) {
                R.id.et_otp1 -> if (text.length == 1) nextView!!.requestFocus()
                R.id.et_otp2 -> if (text.length == 1) nextView!!.requestFocus()
                R.id.et_otp3 -> if (text.length == 1) nextView!!.requestFocus()
                R.id.et_otp4 -> if (text.length == 1) nextView!!.requestFocus()
                //You can use EditText4 same as above to hide the keyboard
            }
        }
        
        override fun beforeTextChanged(
            arg0: CharSequence,
            arg1: Int,
            arg2: Int,
            arg3: Int
        ) { // TODO Auto-generated method stub
        }
        
        override fun onTextChanged(
            arg0: CharSequence,
            arg1: Int,
            arg2: Int,
            arg3: Int
        ) { // TODO Auto-generated method stub
        }
        
    }
    
}

