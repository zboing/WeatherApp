package com.test.test.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Geocode {

   @SerializedName("SAME")
   List<String> SAME;

   @SerializedName("UGC")
   List<String> UGC;


    public void setSAME(List<String> SAME) {
        this.SAME = SAME;
    }
    public List<String> getSAME() {
        return SAME;
    }
    
    public void setUGC(List<String> UGC) {
        this.UGC = UGC;
    }
    public List<String> getUGC() {
        return UGC;
    }
    
}