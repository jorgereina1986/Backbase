package com.jorgereina.backbase;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jorgereina.backbase.databinding.FragmentCitiesBinding;

public class CitiesFragment extends Fragment {

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
}
