package com.jorgereina.backbase.model;

import com.google.gson.annotations.SerializedName;

public class Coord {

    @SerializedName("lon")
    private Float lon;
    @SerializedName("lat")
    private Float lat;

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }
}
