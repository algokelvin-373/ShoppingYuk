package com.algokelvin.shoppingyuk.domain.usecase.login

import com.algokelvin.shoppingyuk.data.api.ResponseResults
import com.algokelvin.shoppingyuk.data.model.user.Login
import com.algokelvin.shoppingyuk.data.model.user.Token
import com.algokelvin.shoppingyuk.domain.repository.LoginRepository
import com.algokelvin.shoppingyuk.utils.Resource

class LoginUseCase(private val loginRepository: LoginRepository) {
    suspend fun execute(login: Login): Resource<Token> = loginRepository.login(login)
}