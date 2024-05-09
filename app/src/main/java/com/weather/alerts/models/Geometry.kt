package com.weather.alerts.models

import com.google.gson.annotations.SerializedName

class Geometry {
    @SerializedName("type")
    var type: String? = null

    @SerializedName("coordinates")
    var coordinates: List<List<List<Double>>>? = null
}