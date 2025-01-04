package com.algokelvin.shoppingyuk.utils

import retrofit2.Response

suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): Resource<T> {
    return try {
        val response = apiCall()
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                Resource.Success(body)
            } else {
                Resource.Error("Response body is null")
            }
        } else {
            Resource.Error("API Error: ${response.code()} - ${response.message()}")
        }
    } catch (e: Exception) {
        Resource.Error("Network call failed: ${e.message}")
    }
}