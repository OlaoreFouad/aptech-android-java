package com.example.mvvmdemo.adapters;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmdemo.models.Deal;

import java.util.List;

public class DealsAdapter extends RecyclerView.Adapter<DealsAdapter.DealViewHolder> {

    private Context context;
    private List<Deal> deals;

    public DealsAdapter(Context context, List<Deal> deals) {
        this.context = context;
        this.deals = deals;
    }

    @NonNull
    @Override
    public DealsAdapter.DealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DealsAdapter.DealViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class DealViewHolder extends RecyclerView.ViewHolder {

        public DealViewHolder(ViewGroup itemView) {
            super(itemView);
        }

    }

}
