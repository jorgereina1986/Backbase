package com.jorgereina.backbase;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jorgereina.backbase.databinding.CityRowBinding;
import com.jorgereina.backbase.list.CitiesContract;
import com.jorgereina.backbase.model.City;

import java.util.List;

public class CitiesAdapter extends RecyclerView.Adapter <CitiesAdapter.CitiesViewHolder> {

    private List<City> cities;
    private CitiesContract.Presenter presenter;

    public CitiesAdapter(List<City> cities, CitiesContract.Presenter presenter) {
        this.cities = cities;
        this.presenter = presenter;
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
        holder.binding.nameTv.setText(city.getName() + ", " + city.getCountry());
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public class CitiesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private CityRowBinding binding;

        public CitiesViewHolder(CityRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            String pos = "Clicked item at position " + getAdapterPosition();
            Toast.makeText(view.getContext(), pos, Toast.LENGTH_LONG).show();
        }
    }

    public void filterList(List<City> filteredCities) {
        this.cities = filteredCities;
        notifyDataSetChanged();
    }
}
