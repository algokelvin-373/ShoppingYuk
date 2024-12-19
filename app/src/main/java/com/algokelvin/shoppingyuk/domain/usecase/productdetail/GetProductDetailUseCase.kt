package com.algokelvin.shoppingyuk.domain.usecase.productdetail

import com.algokelvin.shoppingyuk.data.model.product.Product
import com.algokelvin.shoppingyuk.domain.repository.ProductDetailRepository

class GetProductDetailUseCase(private val productDetailRepository: ProductDetailRepository) {
    suspend fun execute(id: String): Product? = productDetailRepository.getProductDetail(id)
}