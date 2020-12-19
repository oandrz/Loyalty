package com.dre.loyalty.features.pin.presentation

import android.content.Context
import android.content.Intent
import com.dre.loyalty.core.platform.BaseActivity
import com.dre.loyalty.core.platform.BaseFragment

class PinActivity : BaseActivity() {
    override fun fragment(): BaseFragment = PinFragment.newInstance()

    companion object {
        fun callingIntent(context: Context) = Intent(context, PinActivity::class.java)
    }
}
