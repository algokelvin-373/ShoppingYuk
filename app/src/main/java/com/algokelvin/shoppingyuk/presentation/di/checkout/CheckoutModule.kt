package com.algokelvin.shoppingyuk.presentation.di.checkout

import com.algokelvin.shoppingyuk.domain.usecase.checkout.CheckoutUseCase
import com.algokelvin.shoppingyuk.domain.usecase.cart.GetCartByUserIdUseCase
import com.algokelvin.shoppingyuk.presentation.checkout.CheckoutViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class CheckoutModule {
    @CheckoutScope
    @Provides
    fun provideCheckoutViewModelFactory(
        getCartByUserIdUseCase: GetCartByUserIdUseCase,
        checkoutUseCase: CheckoutUseCase,
    ): CheckoutViewModelFactory = CheckoutViewModelFactory(
        getCartByUserIdUseCase,
        checkoutUseCase
    )
}