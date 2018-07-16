package com.jorgereina.backbase.list;

import com.jorgereina.backbase.BaseView;
import com.jorgereina.backbase.model.City;

import java.util.List;

public interface CitiesListContract {

    interface Presenter {

        void onCitiesRequested();

        void onFilteredCitiesRequest(String query);

        int getCitiesCount();

        void onCitySelected(int position);

        void onQueryTextChange(String query);
    }

    interface CitiesView extends BaseView {

        void showCitiesRequested();

        void showFilteredCities(List<City> filteredCities);

        void showCitySelected(City city);

        void showOnQueryTextChange(String query);
    }
}
