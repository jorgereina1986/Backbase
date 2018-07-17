package com.jorgereina.backbase.list;

import com.jorgereina.backbase.BaseView;
import com.jorgereina.backbase.model.City;

public interface CitiesListContract {

    interface Presenter {

        void onCitiesRequested();

        void onCitySelected(City city);

        void onQueryTextChange(String query);
    }

    interface CitiesView extends BaseView {

        void showCitiesRequested();

        void showCitySelected(City city);

        void showOnQueryTextChange(String query);
    }
}
