package com.jorgereina.backbase.details;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jorgereina.backbase.R;
import com.jorgereina.backbase.databinding.FragmentCityDetailsBinding;
import com.jorgereina.backbase.model.City;

public class CityDetailsFragment extends Fragment {

    private static final String CITY_PARCEL = "city_parcel";
    private FragmentCityDetailsBinding binding;

    public CityDetailsFragment() {
        // Required empty public constructor
    }

    public static CityDetailsFragment newInstance(City city) {
        CityDetailsFragment fragment = new CityDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(CITY_PARCEL, city);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
           Bundle bundle = this.getArguments();
           City city = bundle.getParcelable(CITY_PARCEL);
           if (city == null) {
               return;
           }
           //todo display map
            binding.cityDetailsTv.setText(city.getName());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_city_details, container, false);
        return binding.getRoot();
    }
}
