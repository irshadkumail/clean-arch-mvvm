package com.example.cleanarchexample.domain

import com.example.base.None
import com.example.cleanarchexample.AndroidTest
import com.example.cleanarchexample.data.ProductRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class GetProductUseCaseTest : AndroidTest() {

    private lateinit var getProductUseCase: GetProductsUseCase

    @MockK
    private lateinit var productRepository: ProductRepository

    @Before
    fun setUp() {
        getProductUseCase = GetProductsUseCase(productRepository)
        coEvery { productRepository.getProducts() } returns Response.success(ProductList(emptyList()))
    }

    @Test
    fun `should get data from repository`() {
        runBlocking { getProductUseCase.run(None()) {} }

        coVerify(exactly = 1) { productRepository.getProducts() }
    }
}