package com.algokelvin.shoppingyuk.presentation.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.algokelvin.shoppingyuk.domain.usecase.cart.DeleteProductInCartUseCase
import com.algokelvin.shoppingyuk.domain.usecase.cart.GetCartByUserIdUseCase
import com.algokelvin.shoppingyuk.domain.usecase.cart.UpdateCountProductInCartUseCase

@Suppress("UNCHECKED_CAST")
class CartViewModelFactory(
    private val getCartByUserIdUseCase: GetCartByUserIdUseCase,
    private val updateCountProductInCartUseCase: UpdateCountProductInCartUseCase,
    private val deleteProductInCartUseCase: DeleteProductInCartUseCase,
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CartViewModel(
            getCartByUserIdUseCase,
            updateCountProductInCartUseCase,
            deleteProductInCartUseCase
        ) as T
    }
}