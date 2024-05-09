package com.weather.alerts.models

import com.google.gson.annotations.SerializedName

class Features {
    @SerializedName("id")
    var id: String? = null

    @SerializedName("type")
    var type: String? = null

    @SerializedName("geometry")
    var geometry: Geometry? = null

    @SerializedName("properties")
    var properties: Properties? = null
}