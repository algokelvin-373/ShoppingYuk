package com.algokelvin.shoppingyuk.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.algokelvin.shoppingyuk.data.model.user.Login
import com.algokelvin.shoppingyuk.data.model.user.Token
import com.algokelvin.shoppingyuk.domain.usecase.login.GetProfileUseCase
import com.algokelvin.shoppingyuk.domain.usecase.login.LoginUseCase
import com.algokelvin.shoppingyuk.utils.Resource

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
    private val getProfileUseCase: GetProfileUseCase,
): ViewModel() {



    /*fun login(login: Login) = liveData {
        val token = loginUseCase.execute(login)
        emit(token)
    }*/

    // Using Resource and LiveData
    fun login(login: Login) = liveData {
        emit(Resource.Loading())
        try {
            val profile = loginUseCase.execute(login)
            emit(Resource.Success(profile))
        } catch (e: Exception) {
            emit(Resource.Error("Network call failed ${e.message}"))
        }
    }
    fun getProfile(login: Login) = liveData {
        val profile = getProfileUseCase.execute(login)
        emit(profile)
    }
}