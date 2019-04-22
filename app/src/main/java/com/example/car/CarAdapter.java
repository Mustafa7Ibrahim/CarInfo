package com.example.car;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

    private ArrayList<Car> cars;

    ItemClicked activity;


    public interface ItemClicked {
        void onItemClicked(int index);
    }

    public CarAdapter(Context context, ArrayList<Car> List) {

        cars = List;
        activity = (ItemClicked) context ;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_layout , viewGroup , false );

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.itemView.setTag(cars.get(i));

        viewHolder.tvOwner.setText(cars.get(i).getOwnerName());
        viewHolder.tvModel.setText(cars.get(i).getModel());

        switch (cars.get(i).getMake()) {
            case "Mercedes":

                viewHolder.ivMake.setImageResource(R.drawable.mercedes);

                break;
            case "Nissan":

                viewHolder.ivMake.setImageResource(R.drawable.nissan);
                break;
            default:

                viewHolder.ivMake.setImageResource(R.drawable.volkswagen);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivMake;
        TextView tvModel, tvOwner;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivMake = itemView.findViewById(R.id.ivMake);
            tvModel = itemView.findViewById(R.id.tvModel);
            tvOwner = itemView.findViewById(R.id.tvOwner);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    activity.onItemClicked(cars.indexOf(v.getTag()));

                }
            });
        }
    }


}