package com.algokelvin.shoppingyuk.domain.repository

import com.algokelvin.shoppingyuk.data.api.ResponseResults
import com.algokelvin.shoppingyuk.data.model.user.Login
import com.algokelvin.shoppingyuk.data.model.user.Token
import com.algokelvin.shoppingyuk.data.model.user.User
import com.algokelvin.shoppingyuk.utils.Resource

interface LoginRepository {
    suspend fun login(login: Login): Resource<Token>
    suspend fun getUser(login: Login): ResponseResults<User>
    suspend fun getUserFromDB(id: Int): User
}