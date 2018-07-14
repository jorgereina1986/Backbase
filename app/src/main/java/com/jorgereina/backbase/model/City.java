package com.jorgereina.backbase.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class City {

    //{"country":"UA","name":"Hurzuf","_id":707860,"coord":{"lon":34.283333,"lat":44.549999}},

    @SerializedName("country")
    private String country;
    @SerializedName("name")
    private String name;
    @SerializedName("_id")
    private Long id;
    @SerializedName("coord")
    private Coord coord;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }
}
