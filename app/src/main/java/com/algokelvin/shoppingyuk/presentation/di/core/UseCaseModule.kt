package com.algokelvin.shoppingyuk.presentation.di.core

import com.algokelvin.shoppingyuk.domain.repository.CartRepository
import com.algokelvin.shoppingyuk.domain.repository.LoginRepository
import com.algokelvin.shoppingyuk.domain.repository.ProductCategoryRepository
import com.algokelvin.shoppingyuk.domain.repository.ProductDetailRepository
import com.algokelvin.shoppingyuk.domain.repository.ProductRepository
import com.algokelvin.shoppingyuk.domain.usecase.productdetail.AddProductToCartUseCase
import com.algokelvin.shoppingyuk.domain.usecase.checkout.CheckoutUseCase
import com.algokelvin.shoppingyuk.domain.usecase.cart.DeleteProductInCartUseCase
import com.algokelvin.shoppingyuk.domain.usecase.cart.GetCartByUserIdUseCase
import com.algokelvin.shoppingyuk.domain.usecase.productdetail.GetProductDetailUseCase
import com.algokelvin.shoppingyuk.domain.usecase.product.GetProductsCategoryUseCase
import com.algokelvin.shoppingyuk.domain.usecase.product.GetProductsUseCase
import com.algokelvin.shoppingyuk.domain.usecase.profile.GetProfileFromDBUseCase
import com.algokelvin.shoppingyuk.domain.usecase.login.GetProfileUseCase
import com.algokelvin.shoppingyuk.domain.usecase.login.LoginUseCase
import com.algokelvin.shoppingyuk.domain.usecase.cart.UpdateCountProductInCartUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideGetMovieUseCase(productRepository: ProductRepository): GetProductsUseCase {
        return GetProductsUseCase(productRepository)
    }

    @Provides
    fun provideGetProductDetailUseCase(productDetailRepository: ProductDetailRepository): GetProductDetailUseCase {
        return GetProductDetailUseCase(productDetailRepository)
    }

    @Provides
    fun provideLoginUseCase(loginRepository: LoginRepository): LoginUseCase {
        return LoginUseCase(loginRepository)
    }

    @Provides
    fun provideGetProductsCategoryUseCase(productCategoryRepository: ProductCategoryRepository): GetProductsCategoryUseCase {
        return GetProductsCategoryUseCase(productCategoryRepository)
    }

    @Provides
    fun provideGetProfileUseCase(loginRepository: LoginRepository): GetProfileUseCase {
        return GetProfileUseCase(loginRepository)
    }

    @Provides
    fun provideGetProfileFromDBUseCase(loginRepository: LoginRepository): GetProfileFromDBUseCase {
        return GetProfileFromDBUseCase(loginRepository)
    }

    @Provides
    fun provideGetCartByUserIdUseCase(cartRepository: CartRepository): GetCartByUserIdUseCase {
        return GetCartByUserIdUseCase(cartRepository)
    }

    @Provides
    fun provideAddProductToCartUseCase(cartRepository: CartRepository): AddProductToCartUseCase {
        return AddProductToCartUseCase(cartRepository)
    }

    @Provides
    fun provideUpdateCountProductInCartUseCase(cartRepository: CartRepository): UpdateCountProductInCartUseCase {
        return UpdateCountProductInCartUseCase(cartRepository)
    }

    @Provides
    fun provideDeleteProductInCartUseCase(cartRepository: CartRepository): DeleteProductInCartUseCase {
        return DeleteProductInCartUseCase(cartRepository)
    }

    @Provides
    fun provideCheckoutUseCase(cartRepository: CartRepository): CheckoutUseCase {
        return CheckoutUseCase(cartRepository)
    }
}