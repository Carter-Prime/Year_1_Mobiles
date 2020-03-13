package com.example.myapplication_room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


class SpiceListAdapter extends RecyclerView.Adapter<SpiceListAdapter.ViewHolder> {

    List<Spice> spices;

    public SpiceListAdapter(List<Spice> users) {
        this.spices = users;
    }

    @NonNull
    @Override
    public SpiceListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapterview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpiceListAdapter.ViewHolder holder, int position) {
        holder.barcode.setText(spices.get(position).getBarcodeID());
        holder.spiceName.setText(spices.get(position).getSpice_name());
        holder.stock.setText(spices.get(position).getStock());

    }

    @Override
    public int getItemCount() {
        return spices.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView barcode, spiceName, stock;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            barcode = itemView.findViewById(R.id.tvBarcode);
            spiceName = itemView.findViewById(R.id.tvSpiceName);
            stock = itemView.findViewById(R.id.tvStock);
        }
    }
}
