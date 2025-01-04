package com.algokelvin.shoppingyuk.domain.usecase.product

import com.algokelvin.shoppingyuk.data.model.product.Product
import com.algokelvin.shoppingyuk.domain.repository.ProductCategoryRepository

class GetProductsCategoryUseCase(private val productCategoryRepository: ProductCategoryRepository) {
    suspend fun execute(): List<Product> = productCategoryRepository.getProductsSortByCategory()
}