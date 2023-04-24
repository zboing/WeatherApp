package com.test.test.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Parameters {

   @SerializedName("AWIPSidentifier")
   List<String> AWIPSidentifier;

   @SerializedName("WMOidentifier")
   List<String> WMOidentifier;

   @SerializedName("NWSheadline")
   List<String> NWSheadline;

   @SerializedName("BLOCKCHANNEL")
   List<String> BLOCKCHANNEL;


    public void setAWIPSidentifier(List<String> AWIPSidentifier) {
        this.AWIPSidentifier = AWIPSidentifier;
    }
    public List<String> getAWIPSidentifier() {
        return AWIPSidentifier;
    }
    
    public void setWMOidentifier(List<String> WMOidentifier) {
        this.WMOidentifier = WMOidentifier;
    }
    public List<String> getWMOidentifier() {
        return WMOidentifier;
    }
    
    public void setNWSheadline(List<String> NWSheadline) {
        this.NWSheadline = NWSheadline;
    }
    public List<String> getNWSheadline() {
        return NWSheadline;
    }
    
    public void setBLOCKCHANNEL(List<String> BLOCKCHANNEL) {
        this.BLOCKCHANNEL = BLOCKCHANNEL;
    }
    public List<String> getBLOCKCHANNEL() {
        return BLOCKCHANNEL;
    }
    
}