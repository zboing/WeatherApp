package com.test.test.models;

public class DataModel
{
    String event;
    String senderName;
    String duration;

    public DataModel(String event, String senderName, String duration) {
        this.event = event;
        this.senderName = senderName;
        this.duration = duration;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
