package com.example.myanimalapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager; // Import cái này
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class AnimalFragment extends Fragment {

    private static final String ARG_LAYOUT_TYPE = "layout_type";
    private String layoutType;
    private RecyclerView recyclerView;

    public static AnimalFragment newInstance(String layoutType) {
        AnimalFragment fragment = new AnimalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_LAYOUT_TYPE, layoutType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            layoutType = getArguments().getString(ARG_LAYOUT_TYPE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_animal_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);

        // *** ĐÂY LÀ CODE ĐÚNG ***
        if ("GRID".equals(layoutType)) {
            // Tab "Grid" thì dùng GridLayoutManager
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2)); // 2 cột
        } else {
            // Cả tab "Vertical" và "Horizontal" đều dùng LinearLayoutManager DỌC
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }

        // Tạo data
        List<Animal> data = createAllAnimals();

        // Truyền layoutType cho Adapter (để nó chọn đúng item_layout_XXX.xml)
        recyclerView.setAdapter(new AnimalAdapter(data, layoutType));
    }

    // Hàm tạo data giữ nguyên
    private List<Animal> createAllAnimals() {
        List<Animal> list = new ArrayList<>();
        list.add(new Animal("Sư Tử", R.drawable.animal_lion));
        list.add(new Animal("Hổ", R.drawable.animal_tiger));
        list.add(new Animal("Voi", R.drawable.animal_elephant));
        list.add(new Animal("Cá Heo", R.drawable.animal_dolphin));
        list.add(new Animal("Cá Mập", R.drawable.animal_shark));
        list.add(new Animal("Đại Bàng", R.drawable.animal_eagle));
        list.add(new Animal("Vẹt", R.drawable.animal_parrot));
        return list;
    }
}