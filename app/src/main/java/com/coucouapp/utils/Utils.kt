package com.coucouapp.utils

import android.app.Activity
import android.content.Context
import android.text.method.PasswordTransformationMethod
import android.text.method.SingleLineTransformationMethod
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView


object Utils {
    private val TAG = Utils::class.simpleName

    fun hideKeyboard(context: Activity) {
        // Check if no view has focus
        val view = context.currentFocus
        if (view != null) {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun showHidePassword(imageView: ImageView, editText: EditText) {
        imageView.setOnClickListener(View.OnClickListener {
            if (editText.transformationMethod.javaClass.name.equals("PasswordTransformationMethod")
            ) {
                editText.transformationMethod = SingleLineTransformationMethod()
            } else {
                editText.transformationMethod = PasswordTransformationMethod()
            }
            editText.setSelection(editText.text.length)
        })
    }

}
