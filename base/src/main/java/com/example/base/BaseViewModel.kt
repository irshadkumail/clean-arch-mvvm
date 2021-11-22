package com.example.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    val networkRequestInProgress = MutableLiveData<Boolean>()
    val networkRequestFailed = MutableLiveData<Boolean>();
}