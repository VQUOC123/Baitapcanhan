    package com.example.recyclerview; // Tên gói của bạn

    // Sửa "class" ở đây thành "interface"
    public interface SelectListener {
        // Đây là phương thức sẽ được gọi khi một item được click
        void onItemClicked(MyModel myModel);
    }