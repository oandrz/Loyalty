package com.dre.loyalty.features.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dre.loyalty.core.platform.BaseViewModel
import javax.inject.Inject

class LoginViewModel @Inject constructor() : BaseViewModel() {

    private val _navigateMain: MutableLiveData<Boolean> = MutableLiveData()
    val navigateMain: LiveData<Boolean> = _navigateMain

    fun handleLoginButtonClicked() {
        _navigateMain.value = true
    }

}
