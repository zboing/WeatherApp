package com.weather.alerts.models

import com.google.gson.annotations.SerializedName
import java.util.Date

class Properties {
    @SerializedName("id")
    var id: String? = null

    @SerializedName("areaDesc")
    var areaDesc: String? = null

    @SerializedName("geocode")
    var geocode: Geocode? = null

    @SerializedName("affectedZones")
    var affectedZones: List<String>? = null

    @SerializedName("references")
    var references: List<String>? = null

    @SerializedName("sent")
    var sent: Date? = null

    @SerializedName("effective")
    var effective: Date? = null

    @SerializedName("onset")
    var onset: Date? = null

    @SerializedName("expires")
    var expires: Date? = null

    @SerializedName("ends")
    var ends: Date? = null

    @SerializedName("status")
    var status: String? = null

    @SerializedName("messageType")
    var messageType: String? = null

    @SerializedName("category")
    var category: String? = null

    @SerializedName("severity")
    var severity: String? = null

    @SerializedName("certainty")
    var certainty: String? = null

    @SerializedName("urgency")
    var urgency: String? = null

    @SerializedName("event")
    var event: String? = null

    @SerializedName("sender")
    var sender: String? = null

    @SerializedName("senderName")
    var senderName: String? = null

    @SerializedName("headline")
    var headline: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("instruction")
    var instruction: String? = null

    @SerializedName("response")
    var response: String? = null

    @SerializedName("parameters")
    var parameters: Parameters? = null
}