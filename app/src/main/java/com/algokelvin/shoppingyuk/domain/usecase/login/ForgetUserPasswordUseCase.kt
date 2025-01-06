package com.algokelvin.shoppingyuk.domain.usecase.login

import com.algokelvin.shoppingyuk.domain.repository.LoginRepository

class ForgetUserPasswordUseCase(private val loginRepository: LoginRepository) {
    suspend fun execute(): String = loginRepository.forgetUserAndOrPass()
}