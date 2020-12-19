/*
 *  Created by Andreas Oentoro on 12/19/20 1:52 PM
 *  Copyright (c) 2020 . All rights reserved.
 *  Last modified 12/19/20 1:45 PM
 *  Github Profile: https://github.com/oandrz
 */

package com.dre.loyalty.features.splash.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.dre.loyalty.AndroidApplication
import com.dre.loyalty.core.di.ApplicationComponent
import com.dre.loyalty.core.navigation.Navigator
import com.dre.loyalty.databinding.ActivitySplashScreenBinding
import javax.inject.Inject

class SplashScreenActivity : AppCompatActivity() {

    @Inject
    lateinit var navigator: Navigator

    private lateinit var binding: ActivitySplashScreenBinding

    private val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (application as AndroidApplication).appComponent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        bindView()
        Handler().postDelayed({
            navigator.showMain(this)
            finish()
        }, SPLASH_DISPLAY_LENGTH)
    }

    private fun bindView() {
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object {
        private const val SPLASH_DISPLAY_LENGTH = 1000L

        fun callingIntent(context: Context) = Intent(context, SplashScreenActivity::class.java)
    }
}
