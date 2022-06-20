package com.coucouapp.ui.base

import android.content.Context
import android.graphics.*
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.coucouapp.R
import com.coucouapp.utils.Constants.INVALID_SESSION_ERROR_CODE
import retrofit2.HttpException

abstract class BaseActivity<VM : ViewModel,T : ViewDataBinding> : AppCompatActivity(), BaseView {

    var mViewModel: VM? = null
    lateinit var viewDataBinding: T
    @LayoutRes
    abstract fun getLayout(): Int
    abstract fun getViewModelClass(): Class<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this, getLayout())
        mViewModel = ViewModelProvider(this).get(getViewModelClass())
        viewDataBinding.lifecycleOwner = this
//        window?.decorView?.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
//        window.statusBarColor = Color.TRANSPARENT
    
    }

    protected fun bindViewData(): T {
        viewDataBinding = DataBindingUtil.setContentView(this, getLayout())
        mViewModel = ViewModelProvider(this).get(getViewModelClass())
        viewDataBinding.lifecycleOwner = this
        return viewDataBinding
    }

    override fun hideKeyboard() {
        val inputMethodManager: InputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
    }

    override fun onHandleException(e: Throwable) {
        var msg = ""
        if (e is java.net.UnknownHostException) {
            msg = getString(R.string.no_internet)
        } else if (e is java.net.SocketTimeoutException || e is java.net.ConnectException) {
            msg = getString(R.string.slow_internet)
        } else if (e is HttpException) {
            if (e.code() == 500) {
                msg = getString(R.string.server_error)
            }
        }

        if (!TextUtils.isEmpty(msg)) {
            runOnUiThread {
                showMsg(msg)
            }
        }
        e.printStackTrace()
    }

    override fun onSuccess(msg: String) {
        showMsg(msg)
    }

    override fun onFailed(msg: String, error: Int) {

        when (error) {
            INVALID_SESSION_ERROR_CODE -> {
                // logout from app and go to launch screen
            }
            else -> {
                showMsg(msg)
            }
        }
    }

}