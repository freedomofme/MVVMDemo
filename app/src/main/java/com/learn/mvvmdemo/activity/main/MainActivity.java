package com.learn.mvvmdemo.activity.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.learn.base.di.component.BaseComponent;
import com.learn.base.di.component.DaggerBaseComponent;
import com.learn.base.utils.InjectUtils;
import com.learn.mvvmdemo.R;
import com.learn.mvvmdemo.activity.main.viewmodel.CatsListViewModel;
import com.learn.mvvmdemo.di.componet.DaggerMainComponent;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private RecyclerView catsListRecyclerView;
    private CatsListViewModel catsListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initDaggerAndInject();
        getCatList();
    }

    private void initView() {
        progressBar = findViewById(R.id.pb_loading);
        catsListRecyclerView = findViewById(R.id.rv_cats_image_list);

        catsListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        catsListRecyclerView.setHasFixedSize(true);
    }

    private void initDaggerAndInject() {
        catsListViewModel = new ViewModelProvider(this).get(CatsListViewModel.class);
        DaggerMainComponent
                .builder()
                .baseComponent(InjectUtils.provideBaseComponent(getApplicationContext()))
                .build()
                .inject(catsListViewModel);
    }

    private void getCatList() {
        catsListViewModel.getCats();
    }




}