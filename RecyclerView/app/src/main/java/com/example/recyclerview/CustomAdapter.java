package com.example.recyclerview; // Kiểm tra tên gói của bạn

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.DestinationViewHolder> {

    private Context context;
    private List<MyModel> list;
    private SelectListener listener;

    public CustomAdapter(Context context, List<MyModel> list, SelectListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DestinationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Nạp layout item_my_model.xml (layout mới nhất)
        View view = LayoutInflater.from(context).inflate(R.layout.item_my_model, parent, false);
        return new DestinationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DestinationViewHolder holder, int position) {
        MyModel model = list.get(position);

        // --- KIỂM TRA KỸ CHỖ NÀY ---
        // Dòng này rất quan trọng, đảm bảo nó tồn tại
        holder.item_image.setImageResource(model.getImage());
        // --------------------------

        holder.item_title.setText(model.getTitle());
        holder.item_location.setText(model.getLocation());
        holder.item_rating.setText(String.valueOf(model.getRating()));
        holder.item_days.setText(model.getDays());
        holder.item_activities.setText(model.getActivities());

        // (Dòng holder.item_price đã bị xóa là đúng)

        holder.main_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(model);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    // ViewHolder cho layout mới nhất (không có price)
    public class DestinationViewHolder extends RecyclerView.ViewHolder {

        CardView main_container;

        // --- KIỂM TRA KỸ CHỖ NÀY ---
        ImageView item_image; // 1. Đảm bảo đã khai báo
        TextView item_title, item_location, item_rating, item_days, item_activities;

        public DestinationViewHolder(@NonNull View itemView) {
            super(itemView);
            main_container = itemView.findViewById(R.id.main_container);

            // --- KIỂM TRA KỸ CHỖ NÀY ---
            item_image = itemView.findViewById(R.id.item_image); // 2. Đảm bảo đã ánh xạ
            // --------------------------

            item_title = itemView.findViewById(R.id.item_title);
            item_location = itemView.findViewById(R.id.item_location);
            item_rating = itemView.findViewById(R.id.item_rating);
            item_days = itemView.findViewById(R.id.item_days);
            item_activities = itemView.findViewById(R.id.item_activities);

            // (Dòng item_price đã bị xóa là đúng)
        }
    }
}