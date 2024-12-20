package com.algokelvin.shoppingyuk.data.repository.login

import android.util.Log
import com.algokelvin.shoppingyuk.data.api.ResponseResults
import com.algokelvin.shoppingyuk.data.model.user.Login
import com.algokelvin.shoppingyuk.data.model.user.Token
import com.algokelvin.shoppingyuk.data.model.user.User
import com.algokelvin.shoppingyuk.data.repository.login.datasource.LoginLocalDataSource
import com.algokelvin.shoppingyuk.data.repository.login.datasource.LoginRemoteDataSource
import com.algokelvin.shoppingyuk.domain.repository.LoginRepository
import com.algokelvin.shoppingyuk.utils.Resource
import com.algokelvin.shoppingyuk.utils.safeApiCall

class LoginRepositoryImpl(
    private val remote: LoginRemoteDataSource,
    private val local: LoginLocalDataSource,
): LoginRepository {
    override suspend fun login(login: Login): Resource<Token> = loginProcess(login)

    override suspend fun getUser(login: Login): ResponseResults<User> = getProfileUser(login)

    override suspend fun getUserFromDB(id: Int): User = getProfileFromDB(id)

    override suspend fun forgetUserAndOrPass(): String {
        Log.i("Action_Me", "This is Logic for forget user and pass")
        return "You Click Forget User Password"
        // Connect to Data Source
    }

    /*private suspend fun loginProcess(login: Login): ResponseResults<Token> {
        val token: Token?

        try {
            val response = remote.login(login)
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    token = body
                    return ResponseResults(token)
                } else {
                    return ResponseResults(null, "Value Body is NULL")
                }
            } else {
                val errorMessage = response.errorBody()?.string() ?: "Unknown Error"
                return ResponseResults(null, errorMessage)
            }
        } catch (e: Exception) {
            return ResponseResults(null, e.message)
        }
    }*/

    // Implements Resource and SafeApiCall
    private suspend fun loginProcess(login: Login): Resource<Token> {
        return safeApiCall {
            remote.login(login)
        }
    }

    private suspend fun getProfileUser(login: Login): ResponseResults<User> {
        val user: User?

        try {
            val response = remote.getAllUser()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    user = body.find { it.username == login.username && it.password == login.password }
                    user?.let { saveProfile(it) }
                    return ResponseResults(user)
                } else {
                    return ResponseResults(null, "Value Body is NULL")
                }
            } else {
                val errorMessage = response.errorBody()?.string() ?: "Unknown Error"
                return ResponseResults(null, errorMessage)
            }
        } catch (e: Exception) {
            return ResponseResults(null, e.message)
        }
    }

    private suspend fun saveProfile(user: User) {
        try {
            local.saveUserToDB(user)
        } catch (e: Exception) {
            //Log.i("ALGOKELVIN_DEBUG", e.message.toString())
        }
    }

    private suspend fun getProfileFromDB(id: Int): User {
        lateinit var user: User

        try {
            user = local.getUserFromDB(id)
        } catch (e: Exception) {
            //Log.i("ALGOKELVIN_DEBUG", e.message.toString())
        }

        return user
    }

}