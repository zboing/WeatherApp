package com.test.test.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class Root {

    @SerializedName("type")
    String type;

    @SerializedName("features")
    List<Features> features;

    @SerializedName("title")
    String title;

    @SerializedName("updated")
    Date updated;

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setFeatures(List<Features> features) {
        this.features = features;
    }

    public List<Features> getFeatures() {
        return features;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getUpdated() {
        return updated;
    }

}