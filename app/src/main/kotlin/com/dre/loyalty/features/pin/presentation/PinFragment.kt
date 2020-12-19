package com.dre.loyalty.features.pin.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dre.loyalty.core.platform.BaseFragment
import com.fernandocejas.sample.databinding.FragmentPinBinding

class PinFragment : BaseFragment() {

    private var binding: FragmentPinBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPinBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    companion object {
        fun newInstance(): PinFragment {
            return PinFragment()
        }
    }
}
