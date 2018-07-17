package com.jorgereina.backbase.list;

import com.jorgereina.backbase.BaseView;
import com.jorgereina.backbase.model.City;

import java.util.List;

public interface CitiesListContract {

    interface Presenter {

        void onCitiesRequested();

        void onCitySelected(int position);

        void onQueryTextChange(String query);
    }

    interface CitiesView extends BaseView {

        void showCitiesRequested();

        void showCitySelected(City city);

        void showOnQueryTextChange(String query);
    }
}
