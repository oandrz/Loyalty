/*
 *  Created by Andreas Oentoro on 12/20/20 2:55 PM
 *  Copyright (c) 2020 . All rights reserved.
 *  Last modified 12/20/20 2:55 PM
 *  Github Profile: https://github.com/oandrz
 */

package com.dre.loyalty.features.authenticationselector.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dre.loyalty.core.navigation.Navigator
import com.dre.loyalty.core.platform.BaseFragment
import com.dre.loyalty.databinding.FragmentAuthSelectorBinding
import javax.inject.Inject

class AuthenticationSelectorFragment : BaseFragment() {

    @Inject
    lateinit var navigator: Navigator

    private lateinit var binding: FragmentAuthSelectorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthSelectorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogin.setOnClickListener {
            activity?.let {
                navigator.showLogin(it)
            }
        }

        binding.btnRegister.setOnClickListener {
            activity?.let {
                navigator.showRegister(it)
            }
        }
    }

    companion object {
        fun newInstance(): AuthenticationSelectorFragment {
            return AuthenticationSelectorFragment()
        }
    }
}
