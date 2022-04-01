package com.app.aomatatestapp.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.app.aomatatestapp.R
import com.app.aomatatestapp.base.BaseFragment
import  com.app.aomatatestapp.databinding.FragmentHomeBinding
import com.app.aomatatestapp.utils.toast
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activateListeners()
    }

    private fun activateListeners() {
        bi.btnApply.setOnClickListener {
            validation()
        }
    }

    private fun validation() {
        if (bi.etNumberOfColumns.text.toString().isEmpty()) {
            activity?.toast("Number of Columns can't be Empty")
            return
        }
        if (bi.etNumberOfColumns.text.toString().toInt() < 3) {
            activity?.toast("Columns Should not be less than 3")
            return
        }
    }

}