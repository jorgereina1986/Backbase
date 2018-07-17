package com.jorgereina.backbase.list;

import com.google.gson.Gson;
import com.jorgereina.backbase.BasePresenter;
import com.jorgereina.backbase.CityNameComparator;
import com.jorgereina.backbase.model.City;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

public class CitiesListPresenter extends BasePresenter<CitiesListContract.CitiesView>
        implements CitiesListContract.Presenter {

    private List<City> cities;

    public CitiesListPresenter(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public void onCitiesRequested() {
        InputStream inputStream = getClass().getResourceAsStream("/assets/cities.json");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        Gson gson = new Gson();
        Collections.addAll(cities, gson.fromJson(inputStreamReader, City[].class));
        Collections.sort(cities, new CityNameComparator());

        view.hideProgress();
        view.showCitiesRequested();
    }

    @Override
    public void onCitySelected(int position) {
        view.showCitySelected(cities.get(position));
    }

    @Override
    public void onQueryTextChange(String query) {
        view.showOnQueryTextChange(query);
    }
}
