package com.jorgereina.backbase;

import android.content.res.AssetManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.jorgereina.backbase.databinding.FragmentCitiesBinding;
import com.jorgereina.backbase.model.CitiesResponse;
import com.jorgereina.backbase.model.City;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CitiesFragment extends Fragment {

    private static final String TAG = CitiesFragment.class.getSimpleName();
    private FragmentCitiesBinding binding;
    private CitiesAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public CitiesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cities, container, false);

        layoutManager = new LinearLayoutManager(getContext());
        adapter = new CitiesAdapter();
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
        City[] response = gson.fromJson(inputStreamReader, City[].class);

        Log.d(TAG, "onCreateView: " + response[0].getName());
    }
}
