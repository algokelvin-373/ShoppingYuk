package com.algokelvin.shoppingyuk.presentation.di.product

import com.algokelvin.shoppingyuk.domain.usecase.productdetail.AddProductToCartUseCase
import com.algokelvin.shoppingyuk.domain.usecase.productdetail.GetProductDetailUseCase
import com.algokelvin.shoppingyuk.presentation.productdetail.ProductDetailViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ProductDetailModule {
    @ProductDetailScope
    @Provides
    fun provideProductDetailViewModelFactory(
        getProductDetailUseCase: GetProductDetailUseCase,
        addProductToCartUseCase: AddProductToCartUseCase,
    ): ProductDetailViewModelFactory = ProductDetailViewModelFactory(
        getProductDetailUseCase,
        addProductToCartUseCase
    )
}