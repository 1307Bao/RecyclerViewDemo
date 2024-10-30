package com.masterandroid.recyclerviewdemo.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.masterandroid.recyclerviewdemo.R;
import com.masterandroid.recyclerviewdemo.event.RecyclerViewInterface;
import com.masterandroid.recyclerviewdemo.model.FoodModel;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<FoodModel> foodModels;
    private RecyclerViewInterface recyclerViewInterface;

    public FoodAdapter(Context context, ArrayList<FoodModel> foodModels, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.foodModels = foodModels;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public FoodAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.food_item, parent, false);

        return new FoodAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.MyViewHolder holder, int position) {
        String imgSrc = foodModels.get(position).getImgSrc();
        int imageResId = context.getResources().getIdentifier(imgSrc, "drawable", context.getPackageName());
        holder.imgFoodImage.setBackgroundResource(imageResId);
        holder.tvFoodItemName.setText(foodModels.get(position).getName());
        holder.tvFoodItemQuantity.setText(foodModels.get(position).getQuantity() + " sản phẩm");
        holder.tvFoodItemQuantitySale.setText(foodModels.get(position).getQuantitySaled() + " đang giảm giá");
    }

    @Override
    public int getItemCount() {
        return foodModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgFoodImage;
        public TextView tvFoodItemName, tvFoodItemQuantity, tvFoodItemQuantitySale;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFoodImage = itemView.findViewById(R.id.foodImage);
            tvFoodItemName = itemView.findViewById(R.id.foodItemName);
            tvFoodItemQuantity = itemView.findViewById(R.id.foodItemQuantity);
            tvFoodItemQuantitySale = itemView.findViewById(R.id.foodItemQuantitySale);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null){
                        int position =getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.click(position);
                        }
                    }
                }
            });
        }
    }

}
