package com.coucouapp.ui.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel () : ViewModel() {

    override fun onCleared() {
        super.onCleared()
    }

}