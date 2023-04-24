package com.test.test.models;

import com.google.gson.annotations.SerializedName;

public class Features {

   @SerializedName("id")
   String id;

   @SerializedName("type")
   String type;

   @SerializedName("geometry")
   Geometry geometry;

   @SerializedName("properties")
   Properties properties;


    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
    
    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
    public Geometry getGeometry() {
        return geometry;
    }
    
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
    public Properties getProperties() {
        return properties;
    }
    
}