package com.jorgereina.backbase.list;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jorgereina.backbase.MapActivity;
import com.jorgereina.backbase.R;
import com.jorgereina.backbase.databinding.FragmentCitiesBinding;
import com.jorgereina.backbase.details.CityDetailsFragment;
import com.jorgereina.backbase.model.City;

import java.util.ArrayList;
import java.util.List;

public class CitiesListFragment extends Fragment implements CitiesListContract.CitiesView {

    private FragmentCitiesBinding binding;
    private CitiesListAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<City> cities = new ArrayList<>();
    private CitiesListPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new CitiesListPresenter(cities);
        presenter.attachView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_cities, container, false);
        layoutManager = new LinearLayoutManager(getContext());
        adapter = new CitiesListAdapter(cities, presenter);
        binding.citiesRv.setLayoutManager(layoutManager);
        binding.citiesRv.setAdapter(adapter);
        showProgress();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter.onCitiesRequested();

        binding.searchEt.setQueryHint(getString(R.string.search));
        binding.searchEt.onActionViewExpanded();
        binding.searchEt.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                presenter.onQueryTextChange(newText);
                return false;
            }
        });

    }

    @Override
    public void showProgress() {
        binding.citiesPb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        binding.citiesPb.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showCitiesRequested() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showCitySelected(City city) {
        Intent intent = new Intent(getActivity(), MapActivity.class);
        intent.putExtra("lat", city.getCoord().getLat());
        intent.putExtra("lon", city.getCoord().getLon());
        intent.putExtra("name", city.getName());
        startActivity(intent);
    }

    @Override
    public void showOnQueryTextChange(String query) {
        adapter.getFilter().filter(query);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
