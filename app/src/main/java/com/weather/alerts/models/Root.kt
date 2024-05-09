package com.weather.alerts.models

import com.google.gson.annotations.SerializedName
import java.util.Date

class Root {
    @SerializedName("type")
    var type: String? = null

    @SerializedName("features")
    var features: List<Features>? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("updated")
    var updated: Date? = null
}