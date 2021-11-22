package com.example.cleanarchexample.data

import com.example.cleanarchexample.domain.ProductList
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("default/dynamodb-writer")
    suspend fun getProducts(): Response<ProductList>

}