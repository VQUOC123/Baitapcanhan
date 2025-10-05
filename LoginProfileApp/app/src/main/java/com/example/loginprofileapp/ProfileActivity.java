package com.example.loginprofileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Khởi tạo views
        ImageView ivSettings = findViewById(R.id.ivSettings);
        TextView tvProfileName = findViewById(R.id.tvProfileName);
        TextView tvEmail = findViewById(R.id.tvEmail);
        findViewById(R.id.tvPhone);
        TextView tvUsername = findViewById(R.id.tvUsername);

        // Nhận username từ Intent
        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME");

        // Hiển thị thông tin user
        if (username != null && !username.isEmpty()) {
            tvProfileName.setText(username);
            tvUsername.setText(String.format("@%s", username.toLowerCase()));
            tvEmail.setText(String.format("%s@email.com", username.toLowerCase()));
            ivSettings.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Quay về MainActivity (Login)
                    Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                    // Clear back stack để không quay lại Profile khi bấm Back
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            });
        } else {
            ivSettings.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Quay về MainActivity (Login)
                    Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                    // Clear back stack để không quay lại Profile khi bấm Back
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            });
        }

        // Xử lý sự kiện click Settings icon - quay về Login
    }
}