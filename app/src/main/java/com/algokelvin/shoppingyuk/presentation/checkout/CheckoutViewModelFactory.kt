package com.algokelvin.shoppingyuk.presentation.checkout

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.algokelvin.shoppingyuk.domain.usecase.checkout.CheckoutUseCase
import com.algokelvin.shoppingyuk.domain.usecase.cart.GetCartByUserIdUseCase

@Suppress("UNCHECKED_CAST")
class CheckoutViewModelFactory(
    private val getCartByUserIdUseCase: GetCartByUserIdUseCase,
    private val checkoutUseCase: CheckoutUseCase,
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CheckoutViewModel(
            getCartByUserIdUseCase,
            checkoutUseCase
        ) as T
    }
}