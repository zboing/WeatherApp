package com.weather.alerts.models

import com.google.gson.annotations.SerializedName

class Parameters {
    @SerializedName("AWIPSidentifier")
    var aWIPSidentifier: List<String>? = null

    @SerializedName("WMOidentifier")
    var wMOidentifier: List<String>? = null

    @SerializedName("NWSheadline")
    var nWSheadline: List<String>? = null

    @SerializedName("BLOCKCHANNEL")
    var bLOCKCHANNEL: List<String>? = null
}