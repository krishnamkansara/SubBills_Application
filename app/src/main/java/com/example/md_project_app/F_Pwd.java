package com.example.md_project_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class F_Pwd extends AppCompatActivity {
    Button go_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fpwd);

        go_back = findViewById(R.id.go_back);
        go_back.setOnClickListener(v -> {
            startActivity(new Intent(F_Pwd.this, Login.class));
        });
    }
}