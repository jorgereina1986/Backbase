package com.jorgereina.backbase;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jorgereina.backbase.databinding.CityRowBinding;
import com.jorgereina.backbase.model.City;

import java.util.List;

/**
 * Created by jorgereina on 7/13/18.
 */

public class CitiesAdapter extends RecyclerView.Adapter <CitiesAdapter.CitiesViewHolder> {

    private List<City> cities;

    public CitiesAdapter(List<City> cities) {
        this.cities = cities;
    }

    @NonNull
    @Override
    public CitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CityRowBinding binding = CityRowBinding.inflate(inflater, parent, false);
        return new CitiesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CitiesViewHolder holder, int position) {

        City city = cities.get(position);
        holder.binding.nameTv.setText(city.getName());
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public class CitiesViewHolder extends RecyclerView.ViewHolder{

        private CityRowBinding binding;

        public CitiesViewHolder(CityRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
