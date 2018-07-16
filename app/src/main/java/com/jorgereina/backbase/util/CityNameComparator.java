package com.jorgereina.backbase;

import com.jorgereina.backbase.model.City;

public class CityNameComparator implements java.util.Comparator<City> {

    @Override
    public int compare(City city1, City city2) {
        return city1.getName().compareTo(city2.getName());
    }
}
