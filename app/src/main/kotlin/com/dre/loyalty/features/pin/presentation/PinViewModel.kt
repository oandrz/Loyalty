/*
 *  Created by Andreas Oentoro on 12/20/20 4:30 PM
 *  Copyright (c) 2020 . All rights reserved.
 *  Last modified 12/20/20 4:30 PM
 *  Github Profile: https://github.com/oandrz
 */

package com.dre.loyalty.features.pin.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dre.loyalty.core.platform.BaseViewModel
import javax.inject.Inject

private const val MIN_PIN_LENGTH = 6
class PinViewModel @Inject constructor() : BaseViewModel() {

    private val _navigationMain: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val navigationMain: LiveData<Boolean> = _navigationMain

    fun handleTextChanged(pin: String) {
        if (pin.length == MIN_PIN_LENGTH) {
            _navigationMain.value = true
            Log.v("pin length", pin)
        }
    }
}
