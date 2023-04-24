package com.test.test.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class Properties {

   @SerializedName("id")
   String id;

   @SerializedName("areaDesc")
   String areaDesc;

   @SerializedName("geocode")
   Geocode geocode;

   @SerializedName("affectedZones")
   List<String> affectedZones;

   @SerializedName("references")
   List<String> references;

   @SerializedName("sent")
   Date sent;

   @SerializedName("effective")
   Date effective;

   @SerializedName("onset")
   Date onset;

   @SerializedName("expires")
   Date expires;

   @SerializedName("ends")
   Date ends;

   @SerializedName("status")
   String status;

   @SerializedName("messageType")
   String messageType;

   @SerializedName("category")
   String category;

   @SerializedName("severity")
   String severity;

   @SerializedName("certainty")
   String certainty;

   @SerializedName("urgency")
   String urgency;

   @SerializedName("event")
   String event;

   @SerializedName("sender")
   String sender;

   @SerializedName("senderName")
   String senderName;

   @SerializedName("headline")
   String headline;

   @SerializedName("description")
   String description;

   @SerializedName("instruction")
   String instruction;

   @SerializedName("response")
   String response;

   @SerializedName("parameters")
   Parameters parameters;
    
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    
    public void setAreaDesc(String areaDesc) {
        this.areaDesc = areaDesc;
    }
    public String getAreaDesc() {
        return areaDesc;
    }
    
    public void setGeocode(Geocode geocode) {
        this.geocode = geocode;
    }
    public Geocode getGeocode() {
        return geocode;
    }
    
    public void setAffectedZones(List<String> affectedZones) {
        this.affectedZones = affectedZones;
    }
    public List<String> getAffectedZones() {
        return affectedZones;
    }
    
    public void setReferences(List<String> references) {
        this.references = references;
    }
    public List<String> getReferences() {
        return references;
    }
    
    public void setSent(Date sent) {
        this.sent = sent;
    }
    public Date getSent() {
        return sent;
    }
    
    public void setEffective(Date effective) {
        this.effective = effective;
    }
    public Date getEffective() {
        return effective;
    }
    
    public void setOnset(Date onset) {
        this.onset = onset;
    }
    public Date getOnset() {
        return onset;
    }
    
    public void setExpires(Date expires) {
        this.expires = expires;
    }
    public Date getExpires() {
        return expires;
    }
    
    public void setEnds(Date ends) {
        this.ends = ends;
    }
    public Date getEnds() {
        return ends;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
    
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
    public String getMessageType() {
        return messageType;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    public String getCategory() {
        return category;
    }
    
    public void setSeverity(String severity) {
        this.severity = severity;
    }
    public String getSeverity() {
        return severity;
    }
    
    public void setCertainty(String certainty) {
        this.certainty = certainty;
    }
    public String getCertainty() {
        return certainty;
    }
    
    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }
    public String getUrgency() {
        return urgency;
    }
    
    public void setEvent(String event) {
        this.event = event;
    }
    public String getEvent() {
        return event;
    }
    
    public void setSender(String sender) {
        this.sender = sender;
    }
    public String getSender() {
        return sender;
    }
    
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }
    public String getSenderName() {
        return senderName;
    }
    
    public void setHeadline(String headline) {
        this.headline = headline;
    }
    public String getHeadline() {
        return headline;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    
    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
    public String getInstruction() {
        return instruction;
    }
    
    public void setResponse(String response) {
        this.response = response;
    }
    public String getResponse() {
        return response;
    }
    
    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }
    public Parameters getParameters() {
        return parameters;
    }
    
}