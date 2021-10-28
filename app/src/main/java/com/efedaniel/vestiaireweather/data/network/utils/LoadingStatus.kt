package com.efedaniel.vestiaireweather.data.network.utils

/**
 * Loading Status Enum to keep network calls states.
 */
sealed class LoadingStatus {

    object Success : LoadingStatus()
    class Loading(val message: String = "") : LoadingStatus()
    data class Error(val errorMessage: String) : LoadingStatus()

    override fun toString(): String {
        return when (this) {
            is Success -> "Success"
            is Error -> "Error[$errorMessage]"
            is Loading -> "Loading[$message]"
        }
    }
}
