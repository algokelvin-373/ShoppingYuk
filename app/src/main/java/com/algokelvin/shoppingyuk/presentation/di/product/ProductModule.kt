package com.algokelvin.shoppingyuk.presentation.di.product

import com.algokelvin.shoppingyuk.domain.usecase.product.GetProductsUseCase
import com.algokelvin.shoppingyuk.presentation.product.ProductViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ProductModule {
    @ProductScope
    @Provides
    fun provideProductViewModelFactory(
        getProductsUseCase: GetProductsUseCase,
    ): ProductViewModelFactory = ProductViewModelFactory(getProductsUseCase)
}