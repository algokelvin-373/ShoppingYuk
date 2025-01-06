package com.algokelvin.shoppingyuk.domain.usecase.profile

import com.algokelvin.shoppingyuk.data.model.user.User
import com.algokelvin.shoppingyuk.domain.repository.LoginRepository

class GetProfileFromDBUseCase(private val loginRepository: LoginRepository) {
    suspend fun execute(id: Int): User = loginRepository.getUserFromDB(id)
}