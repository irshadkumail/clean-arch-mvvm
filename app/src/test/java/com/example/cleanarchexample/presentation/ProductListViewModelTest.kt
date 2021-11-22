package com.example.cleanarchexample.presentation

import com.example.cleanarchexample.AndroidTest
import com.example.cleanarchexample.data.ProductRepository
import com.example.cleanarchexample.domain.GetProductsUseCase
import com.example.cleanarchexample.domain.Product
import com.example.cleanarchexample.domain.ProductList
import com.example.cleanarchexample.presentation.list.ProductListViewModel
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Response


class ProductListViewModelTest : AndroidTest() {

    private lateinit var productListViewModel: ProductListViewModel

    @MockK
    private lateinit var repository: ProductRepository

    @Before
    fun setUp() {
        productListViewModel = ProductListViewModel(GetProductsUseCase(repository))
    }

    @Test
    fun `loading product list`() {
        val productList = ProductList(
            listOf(
                Product(
                    "data", "AED 100", "Dummy", "123", emptyList(), emptyList(),
                    emptyList()
                )
            )
        )
        coEvery { repository.getProducts() } returns Response.success(productList)
        runBlocking { productListViewModel.getProducts() }

        Assert.assertNotNull(productListViewModel.productList.value)
        Assert.assertEquals(1, productListViewModel.productList.value?.size)
    }
}