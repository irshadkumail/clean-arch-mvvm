package com.example.cleanarchexample.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.base.BaseViewModel
import com.example.base.None
import com.example.base.UseCaseResult
import com.example.cleanarchexample.domain.GetProductsUseCase
import com.example.cleanarchexample.domain.Product
import com.example.cleanarchexample.domain.ProductList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(private val getProducts: GetProductsUseCase) :
    BaseViewModel() {

    val productList = MutableLiveData<List<Product?>>()

    fun getProducts() {
        networkRequestInProgress.value = true
        viewModelScope.launch {
            getProducts.run(None()) {
                networkRequestInProgress.value = false
                when (it) {
                    is UseCaseResult.Failure -> networkRequestFailed.value = true
                    is UseCaseResult.Success<*> -> {
                        productList.value = (it.response as ProductList).results ?: emptyList()
                    }
                }
            }
        }

    }

}