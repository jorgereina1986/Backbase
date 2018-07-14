package com.jorgereina.backbase;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jorgereina on 7/13/18.
 */

public class CitiesAdapter extends RecyclerView.Adapter <CitiesAdapter.CitiesViewHolder> {
    @NonNull
    @Override
    public CitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CitiesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CitiesViewHolder extends RecyclerView.ViewHolder{
        public CitiesViewHolder(View itemView) {
            super(itemView);
        }
    }
}
