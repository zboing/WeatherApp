package com.weather.alerts.models

import com.google.gson.annotations.SerializedName

class Geocode {
    @SerializedName("SAME")
    var sAME: List<String>? = null

    @SerializedName("UGC")
    var uGC: List<String>? = null
}