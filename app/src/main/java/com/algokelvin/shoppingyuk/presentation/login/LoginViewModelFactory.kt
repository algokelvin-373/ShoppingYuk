package com.algokelvin.shoppingyuk.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.algokelvin.shoppingyuk.domain.usecase.login.GetProfileUseCase
import com.algokelvin.shoppingyuk.domain.usecase.login.LoginUseCase

@Suppress("UNCHECKED_CAST")
class LoginViewModelFactory(
    private val loginUseCase: LoginUseCase,
    private val getProfileUseCase: GetProfileUseCase,
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(loginUseCase, getProfileUseCase) as T
    }
}