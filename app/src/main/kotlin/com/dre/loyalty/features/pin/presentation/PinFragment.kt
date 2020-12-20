package com.dre.loyalty.features.pin.presentation

import android.graphics.Typeface
import android.os.Bundle
import android.text.Editable
import android.text.Spannable
import android.text.SpannableString
import android.text.TextWatcher
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dre.loyalty.R
import com.dre.loyalty.core.extension.observe
import com.dre.loyalty.core.extension.viewModel
import com.dre.loyalty.core.navigation.Navigator
import com.dre.loyalty.core.platform.BaseFragment
import com.dre.loyalty.databinding.FragmentPinBinding
import javax.inject.Inject

class PinFragment : BaseFragment() {

    private val textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(s: Editable?) {
            vm.handleTextChanged(s.toString())
        }
    }

    @Inject
    lateinit var navigator: Navigator

    private var binding: FragmentPinBinding? = null
    private lateinit var vm: PinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        vm = viewModel(viewModelFactory) {
            observe(navigationMain) {
                
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPinBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.run {
            val forgotPinLabelText = SpannableString(resources.getString(R.string.pin_screen_label_forgotpin))
            forgotPinLabelText.setSpan(
                StyleSpan(Typeface.BOLD),
                10,
                forgotPinLabelText.length,
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )
            tvForgotpinLabel.text = forgotPinLabelText
            etPin.addTextChangedListener(textWatcher)
        }
    }

    override fun onDetach() {
        binding?.etPin?.removeTextChangedListener(textWatcher)
        binding = null
        super.onDetach()
    }

    companion object {
        fun newInstance(): PinFragment {
            return PinFragment()
        }
    }
}
