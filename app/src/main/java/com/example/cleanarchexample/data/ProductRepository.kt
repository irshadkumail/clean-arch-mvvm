package com.example.cleanarchexample.data

import retrofit2.Retrofit
import javax.inject.Inject

class ProductRepository @Inject constructor(private val retrofit: Retrofit) {

    suspend fun getProducts() = retrofit.create(ApiInterface::class.java).getProducts()
}