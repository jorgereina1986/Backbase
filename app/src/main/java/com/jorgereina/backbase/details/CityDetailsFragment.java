package com.jorgereina.backbase.details;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jorgereina.backbase.R;
import com.jorgereina.backbase.databinding.FragmentCityDetailsBinding;
import com.jorgereina.backbase.model.City;

public class CityDetailsFragment extends Fragment implements OnMapReadyCallback {

    private static final String CITY_PARCEL = "city_parcel";

    private FragmentCityDetailsBinding binding;
    private GoogleMap map;
    private SupportMapFragment mapFragment;



    public CityDetailsFragment() {
    }

    public static CityDetailsFragment newInstance(City city) {
        CityDetailsFragment fragment = new CityDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(CITY_PARCEL, city);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_city_details, container, false);
        mapFragment = (SupportMapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        City city = this.getArguments().getParcelable(CITY_PARCEL);
        Log.d("lagarto", "onViewCreated: " + city.getName());

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        LatLng sydney = new LatLng(-34, 151);
        map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        map.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}

