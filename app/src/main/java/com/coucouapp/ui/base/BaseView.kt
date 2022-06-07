package com.coucouapp.ui.base

import androidx.annotation.LayoutRes


interface BaseView {
    fun showMsg(msgId: Int)

    fun showMsg(msg: String)

    fun hideKeyboard()

    fun onHandleException(e: Throwable)

    fun onSuccess(msg: String)

    fun onFailed(msg: String, error: Int)

//    @LayoutRes
//    fun getLayoutId(): Int
//
//    fun getBindingVariable(): Int
}
