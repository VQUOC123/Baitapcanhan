package com.example.loginprofileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText etUsername, etPassword;

    // ===== SET TÀI KHOẢN VÀ MẬT KHẨU Ở ĐÂY =====
    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "123456";
    // =============================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo views
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        MaterialButton btnLogin = findViewById(R.id.btnLogin);

        // Xử lý sự kiện click button Login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = Objects.requireNonNull(etUsername.getText()).toString().trim();
                String password = Objects.requireNonNull(etPassword.getText()).toString().trim();

                // Kiểm tra input rỗng
                if (username.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            R.string.enter_username, Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            R.string.enter_password, Toast.LENGTH_SHORT).show();
                    return;
                }

                // ===== KIỂM TRA ĐĂNG NHẬP =====
                if (!username.equals(CORRECT_USERNAME)) {
                    Toast.makeText(MainActivity.this,
                            "Sai tên đăng nhập!\nThử: " + CORRECT_USERNAME,
                            Toast.LENGTH_LONG).show();
                    return;
                }

                if (!password.equals(CORRECT_PASSWORD)) {
                    Toast.makeText(MainActivity.this,
                            "Sai mật khẩu!\nThử: " + CORRECT_PASSWORD,
                            Toast.LENGTH_LONG).show();
                    return;
                }
                // ==============================

                Toast.makeText(MainActivity.this,
                        "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();

                // Chuyển sang ProfileActivity và truyền username
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.putExtra("USERNAME", username);
                startActivity(intent);
            }
        });
    }
}