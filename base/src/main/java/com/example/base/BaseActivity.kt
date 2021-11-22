package com.example.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseActivity<D : ViewDataBinding>(private val layoutResId: Int) :
    AppCompatActivity() {

    abstract val viewModel: ViewModel

    lateinit var dataBinding: D

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState,)
        dataBinding = DataBindingUtil.setContentView(this, layoutResId)
    }

}