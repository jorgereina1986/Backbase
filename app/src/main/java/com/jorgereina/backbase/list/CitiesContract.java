package com.jorgereina.backbase.list;

import com.jorgereina.backbase.BaseView;
import com.jorgereina.backbase.model.City;

import java.util.List;

public interface CitiesContract {

    interface Presenter {

        void onCitiesRequested();

        void onFilteredCitiesRequest(String query);
    }

    interface CitiesView extends BaseView {

        void showCitiesRequested();

        void showFilteredCities(List<City> filteredCities);
    }
}
