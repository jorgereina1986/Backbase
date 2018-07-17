package com.jorgereina.backbase.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.jorgereina.backbase.databinding.CityRowBinding;
import com.jorgereina.backbase.model.City;

import java.util.ArrayList;
import java.util.List;

public class CitiesListAdapter extends RecyclerView.Adapter<CitiesListAdapter.CitiesViewHolder> implements Filterable {

    private List<City> cities;
    private List<City> filteredCities;
    private CitiesListContract.Presenter presenter;

    public CitiesListAdapter(List<City> cities, CitiesListContract.Presenter presenter) {
        this.cities = cities;
        this.filteredCities = cities;
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
        City city = filteredCities.get(position);
        holder.binding.nameTv.setText(city.getName());
    }

    @Override
    public int getItemCount() {
        return filteredCities.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String query = charSequence.toString();
                if (query.isEmpty()) {
                    filteredCities = cities;
                } else {
                    List<City> filteredList = new ArrayList<>();
                    for (City city : cities) {
                        if (city.getName().toLowerCase().startsWith(query)) {
                            filteredList.add(city);
                        }
                    }
                    filteredCities = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredCities;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredCities = (List<City>) filterResults.values;
                notifyDataSetChanged();
            }
        };
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
            presenter.onCitySelected(getAdapterPosition());
        }
    }

    public void filterList(List<City> filteredCities) {
        this.cities = filteredCities;
        notifyDataSetChanged();
    }
}
