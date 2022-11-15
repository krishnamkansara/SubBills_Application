package com.example.md_project_app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class help extends AppCompatActivity {
    Button go_back1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        go_back1 = findViewById(R.id.go_back1);
        go_back1.setOnClickListener(v -> {
            startActivity(new Intent(help.this, option_page2.class));
        });

    }
}