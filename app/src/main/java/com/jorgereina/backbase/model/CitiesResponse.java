package com.jorgereina.backbase.model;

import java.util.List;

public class CitiesResponse {

    private List<City> cityList;

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
