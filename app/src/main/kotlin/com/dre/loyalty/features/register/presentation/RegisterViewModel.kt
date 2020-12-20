/*
 *  Created by Andreas Oentoro on 12/19/20 5:03 PM
 *  Copyright (c) 2020 . All rights reserved.
 *  Last modified 12/14/20 8:16 PM
 *  Github Profile: https://github.com/oandrz
 */

package com.dre.loyalty.features.register.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dre.loyalty.core.platform.BaseViewModel
import javax.inject.Inject

class RegisterViewModel @Inject constructor() : BaseViewModel() {

    private val _navigateMain: MutableLiveData<Boolean> = MutableLiveData()
    val navigateMain: LiveData<Boolean> = _navigateMain

    fun handleLoginButtonClicked() {
        _navigateMain.value = true
    }

}
