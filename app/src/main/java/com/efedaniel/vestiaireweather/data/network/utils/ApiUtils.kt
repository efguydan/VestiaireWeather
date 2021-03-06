package com.efedaniel.vestiaireweather.data.network.utils

import retrofit2.Response

const val GENERIC_ERROR_MESSAGE = "An error occurred, Please try again"
const val GENERIC_ERROR_CODE = "-1"

/**
 * Helper method to convert the Response Body to a Result type. For easier use in the presentation
 * layer
 */
fun <T : Any> getAPIResult(response: Response<T>): Result<T> {
    if (response.isSuccessful) {
        val body = response.body()
        if (body != null) {
            return Result.Success(body)
        }
    }
    // No sample error json found. so...
    // Fallback to regular status code and message
    return Result.Error(GENERIC_ERROR_CODE, GENERIC_ERROR_MESSAGE)
}
