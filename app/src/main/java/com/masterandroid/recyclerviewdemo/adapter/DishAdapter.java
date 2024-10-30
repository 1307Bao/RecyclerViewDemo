package com.masterandroid.recyclerviewdemo.adapter;


import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.Rating;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.masterandroid.recyclerviewdemo.R;
import com.masterandroid.recyclerviewdemo.model.DishModel;

import java.util.ArrayList;
import java.util.Objects;
import java.util.zip.Inflater;

public class DishAdapter extends RecyclerView.Adapter<DishAdapter.ViewHolder> {

    private Context context;
    private ArrayList<DishModel> dishModels;

    public DishAdapter(Context context, ArrayList<DishModel> dishModels) {
        this.context = context;
        this.dishModels = dishModels;
    }

    @NonNull
    @Override
    public DishAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dish_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DishAdapter.ViewHolder holder, int position) {
        String imgSrc = dishModels.get(position).getImgSrc();

        int imageResId = context.getResources().getIdentifier(imgSrc, "drawable", context.getPackageName());

        holder.imgDishImage.setBackgroundResource(imageResId);
        Objects.requireNonNull(holder).tvDishItemName.setText(dishModels.get(position).getName());
        holder.tvDishPrice.setText(dishModels.get(position).getPrice() + "đ");
        holder.tvDishPriceSale.setText(dishModels.get(position).getPriceSaled() + "đ");
        holder.rtBar.setRating(dishModels.get(position).getRating());
    }

    @Override
    public int getItemCount() {
        return dishModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgDishImage;
        private TextView tvDishItemName, tvDishPrice, tvDishPriceSale;
        private RatingBar rtBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgDishImage = itemView.findViewById(R.id.dishImage);
            tvDishItemName = itemView.findViewById(R.id.dishItemName);
            tvDishPrice = itemView.findViewById(R.id.dishPrice);
            tvDishPriceSale = itemView.findViewById(R.id.dishPriceSale);
            rtBar = itemView.findViewById(R.id.ratingBar);

            tvDishPrice.setPaintFlags(tvDishPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }
}
