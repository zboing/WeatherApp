package com.weather.alerts.interfaces

sealed interface UiState<out T> {
    data class Success<T>(val data: T) : UiState<T>
    data class Error(val message: String) : UiState<Nothing>
    data object Loading : UiState<Nothing>

}