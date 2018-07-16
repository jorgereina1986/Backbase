package com.jorgereina.backbase.list;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.jorgereina.backbase.CitiesAdapter;
import com.jorgereina.backbase.CityNameComparator;
import com.jorgereina.backbase.R;
import com.jorgereina.backbase.databinding.FragmentCitiesBinding;
import com.jorgereina.backbase.model.City;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CitiesFragment extends Fragment implements CitiesContract.CitiesView {

    private static final String TAG = CitiesFragment.class.getSimpleName();

    private FragmentCitiesBinding binding;
    private CitiesAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<City> cities = new ArrayList<>();
    private CitiesPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new CitiesPresenter(cities);
        presenter.attachView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_cities, container, false);
        layoutManager = new LinearLayoutManager(getContext());
        adapter = new CitiesAdapter(cities, presenter);
        binding.citiesRv.setLayoutManager(layoutManager);
        binding.citiesRv.setAdapter(adapter);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter.onCitiesRequested();

        binding.searchEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presenter.onFilteredCitiesRequest(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String errorMessage) {

    }

    @Override
    public void showCitiesRequested() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showFilteredCities(List<City> filteredCities) {
        adapter.filterList(filteredCities);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
