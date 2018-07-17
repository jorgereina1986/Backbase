package com.jorgereina.backbase.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jorgereina.backbase.R;
import com.jorgereina.backbase.databinding.ActivityCitiesBinding;
import com.jorgereina.backbase.list.CitiesListFragment;

public class CitiesActivity extends AppCompatActivity {

    private ActivityCitiesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cities);
        setContentView(R.layout.activity_cities);

        populateFragment();
    }

    private void populateFragment() {
        CitiesListFragment citiesListFragment = new CitiesListFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, citiesListFragment)
                .commit();
    }
}
