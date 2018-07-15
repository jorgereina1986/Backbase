package com.jorgereina.backbase;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.jorgereina.backbase.databinding.FragmentCitiesBinding;
import com.jorgereina.backbase.model.City;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CitiesFragment extends Fragment {

    private static final String TAG = CitiesFragment.class.getSimpleName();

    private FragmentCitiesBinding binding;
    private CitiesAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<City> cities = new ArrayList<>();

    public CitiesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_cities, container, false);
        layoutManager = new LinearLayoutManager(getContext());
        adapter = new CitiesAdapter(cities);
        binding.citiesRv.setLayoutManager(layoutManager);
        binding.citiesRv.setAdapter(adapter);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        InputStream inputStream = getClass().getResourceAsStream("/assets/cities.json");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        Gson gson = new Gson();
        Collections.addAll(cities, gson.fromJson(inputStreamReader, City[].class));
        Collections.sort(cities, new CityNameComparator());
        adapter.notifyDataSetChanged();

        binding.searchEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                List<City> updatedCityList = new ArrayList<>();
                for (City city : cities) {
                    if (city.getName()
                            .toLowerCase()
                            .startsWith(String.valueOf(charSequence).toLowerCase())) {
                        updatedCityList.add(city);
                    }
                }
                adapter.filterList(updatedCityList);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
