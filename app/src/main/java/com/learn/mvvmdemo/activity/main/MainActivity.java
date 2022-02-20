package com.learn.mvvmdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private RecyclerView catsListRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void initView() {
        progressBar = findViewById(R.id.pb_loading);
        catsListRecyclerView = findViewById(R.id.rv_cats_image_list);

        catsListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        catsListRecyclerView.setHasFixedSize(true);
    }
}