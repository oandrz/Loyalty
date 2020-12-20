/*
 *  Created by Andreas Oentoro on 12/19/20 5:03 PM
 *  Copyright (c) 2020 . All rights reserved.
 *  Last modified 12/19/20 5:03 PM
 *  Github Profile: https://github.com/oandrz
 */

package com.dre.loyalty.features.register.presentation

import android.content.Context
import android.content.Intent
import com.dre.loyalty.core.platform.BaseActivity

class RegisterActivity : BaseActivity() {
    companion object {
        fun callingIntent(context: Context) = Intent(context, RegisterActivity::class.java)
    }

    override fun fragment() = RegisterFragment()
}
