package com.example.cleanarchexample.domain

import com.example.base.BaseUseCase
import com.example.base.None
import com.example.base.UseCaseResult
import com.example.cleanarchexample.data.ProductRepository
import javax.inject.Inject


class GetProductsUseCase @Inject constructor (private val repository: ProductRepository) :
    BaseUseCase<ProductList, None>() {

    override suspend fun run(
        params: None,
        onResult: (result: UseCaseResult) -> Unit
    ) {
        val response = repository.getProducts()
        if (response.isSuccessful) {
            onResult(UseCaseResult.Success(response.body() ?: ProductList(emptyList())));
        } else {
            onResult(UseCaseResult.Failure)
        }
    }
}
