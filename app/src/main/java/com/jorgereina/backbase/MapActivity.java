package com.jorgereina.backbase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by jorgereina on 7/16/18.
 */

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap map;
    private float latitude;
    private float longitude;
    private String cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        latitude = getIntent().getFloatExtra("lat", 0);
        longitude = getIntent().getFloatExtra("lon", 0);
        cityName = getIntent().getStringExtra("name");

        Log.d("lagarto", "onCreate: Map " + latitude);
        Log.d("lagarto", "onCreate: Map city name " + cityName);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        this.map = map;
        LatLng location = new LatLng(latitude, longitude);
        this.map.addMarker(new MarkerOptions().position(location).title(cityName));
        this.map.moveCamera(CameraUpdateFactory.newLatLng(location));
    }
}
