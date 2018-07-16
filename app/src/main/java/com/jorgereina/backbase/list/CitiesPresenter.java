package com.jorgereina.backbase.list;

import com.google.gson.Gson;
import com.jorgereina.backbase.BasePresenter;
import com.jorgereina.backbase.CityNameComparator;
import com.jorgereina.backbase.model.City;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CitiesPresenter extends BasePresenter<CitiesContract.CitiesView>
        implements CitiesContract.Presenter {

    private List<City> cities;

    public CitiesPresenter(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public void onCitiesRequested() {
        view.showProgress();
        InputStream inputStream = getClass().getResourceAsStream("/assets/cities.json");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        Gson gson = new Gson();
        Collections.addAll(cities, gson.fromJson(inputStreamReader, City[].class));
        Collections.sort(cities, new CityNameComparator());

        view.showCitiesRequested();
    }

    @Override
    public void onFilteredCitiesRequest(String query) {
        List<City> filteredCities = new ArrayList<>();
        for (City city : cities) {
            if (city.getName()
                    .toLowerCase()
                    .startsWith(String.valueOf(query).toLowerCase())) {
                filteredCities.add(city);
            }
        }
        view.showFilteredCities(filteredCities);
    }
}
