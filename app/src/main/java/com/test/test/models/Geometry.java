package com.test.test.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Geometry {

   @SerializedName("type")
   String type;

   @SerializedName("coordinates")
   List<List<List<Double>>> coordinates;


    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
    
    public void setCoordinates(List<List<List<Double>>> coordinates) {
        this.coordinates = coordinates;
    }
    public List<List<List<Double>>> getCoordinates() {
        return coordinates;
    }
    
}