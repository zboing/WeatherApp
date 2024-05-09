package com.weather.alerts.api

import com.weather.alerts.models.Root
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("alerts/active?status=actual&message_type=alert")
    fun getData(): Call<Root>
}