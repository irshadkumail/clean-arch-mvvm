package com.example.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFragment<D : ViewDataBinding>(private val layoutResId: Int) :
    Fragment(layoutResId) {

    abstract val viewModel: ViewModel

    lateinit var dataBinding: D

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(layoutInflater, layoutResId, container, false)
        dataBinding.lifecycleOwner = this

        return dataBinding.root
    }

}