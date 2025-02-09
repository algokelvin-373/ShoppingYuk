package com.algokelvin.shoppingyuk.presentation.di.cart

import com.algokelvin.shoppingyuk.domain.usecase.cart.DeleteProductInCartUseCase
import com.algokelvin.shoppingyuk.domain.usecase.cart.GetCartByUserIdUseCase
import com.algokelvin.shoppingyuk.domain.usecase.cart.UpdateCountProductInCartUseCase
import com.algokelvin.shoppingyuk.presentation.cart.CartViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class CartModule {
    @CartScope
    @Provides
    fun provideCartViewModelFactory(
        getCartByUserIdUseCase: GetCartByUserIdUseCase,
        updateCountProductInCartUseCase: UpdateCountProductInCartUseCase,
        deleteProductInCartUseCase: DeleteProductInCartUseCase,
    ): CartViewModelFactory = CartViewModelFactory(
        getCartByUserIdUseCase,
        updateCountProductInCartUseCase,
        deleteProductInCartUseCase
    )
}