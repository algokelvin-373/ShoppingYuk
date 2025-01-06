package com.algokelvin.shoppingyuk.domain.usecase.cart

import com.algokelvin.shoppingyuk.domain.repository.CartRepository

class DeleteProductInCartUseCase(private val cartRepository: CartRepository) {
    suspend fun execute(
        userId: Int,
        productInt: Int,
    ): String = cartRepository.deleteProductInCart(userId, productInt)
}