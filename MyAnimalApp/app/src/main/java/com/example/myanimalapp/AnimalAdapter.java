package com.example.myanimalapp;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {

    private List<Animal> animals;
    private String layoutType; // "VERTICAL", "HORIZONTAL", or "GRID"

    // Constructor mới, nhận thêm layoutType
    public AnimalAdapter(List<Animal> animals, String layoutType) {
        this.animals = animals;
        this.layoutType = layoutType;
    }

    // 1. Chỉ cần 1 ViewHolder
    public class AnimalViewHolder extends RecyclerView.ViewHolder {
        ImageView animalImage;
        TextView animalName;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            animalImage = itemView.findViewById(R.id.imgAnimal);
            animalName = itemView.findViewById(R.id.tvAnimalName);
        }
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // Dựa vào layoutType để chọn file XML
        if ("VERTICAL".equals(layoutType)) {
            view = inflater.inflate(R.layout.item_layout_vertical, parent, false);
        } else if ("HORIZONTAL".equals(layoutType)) {
            view = inflater.inflate(R.layout.item_layout_horizontal, parent, false);
        } else { // "GRID"
            view = inflater.inflate(R.layout.item_layout_grid, parent, false);
        }
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        Animal animal = animals.get(position);
        holder.animalName.setText(animal.getName());
        holder.animalImage.setImageResource(animal.getImageResId());
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    // Bỏ hết mấy hàm getItemViewType và 2 ViewHolder kia
}