package com.example.recyclerview; // Kiểm tra lại tên gói của bạn

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectListener {

    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    List<MyModel> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dataList = new ArrayList<>();

        // 1. TẠO DỮ LIỆU MỚI (ĐÃ SỬA LỖI - THÊM "" CHO DESCRIPTION)
        // Constructor bây giờ đã đủ 7 tham số
        dataList.add(new MyModel(R.drawable.anh1, "Sắc Thu Kyoto", "", "Kyoto, Nhật Bản",
                4.8, "Ngày: 10/11/2025", "Thể loại: Cảnh Quan"));

        dataList.add(new MyModel(R.drawable.anh2, "Cún Cưng Cắm Trại", "", "Đà Lạt, Việt Nam",
                4.9, "Ngày: 05/10/2025", "Thể loại: Chân Dung"));

        dataList.add(new MyModel(R.drawable.anh3, "Bạn Jack Russell", "", "Công viên trung tâm",
                4.6, "Ngày: 01/09/2025", "Thể loại: Động vật"));

        dataList.add(new MyModel(R.drawable.anh4, "Sóc Đen Lém Lỉnh", "", "Banff, Canada",
                4.7, "Ngày: 22/10/2025", "Thể loại: Hoang Dã"));

        dataList.add(new MyModel(R.drawable.anh5, "Rừng Sương Sa Pa", "", "Sa Pa, Việt Nam",
                4.8, "Ngày: 15/08/2025", "Thể loại: Thiên Nhiên"));


        // 2. Khởi tạo Adapter
        customAdapter = new CustomAdapter(this, dataList, this);
        recyclerView.setAdapter(customAdapter);
    }

    @Override
    public void onItemClicked(MyModel myModel) {
        // 3. Cập nhật Toast cho chủ đề mới
        Toast.makeText(this, "Bạn đã chọn ảnh: " + myModel.getTitle(), Toast.LENGTH_SHORT).show();
    }
}