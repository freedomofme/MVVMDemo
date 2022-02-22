package com.learn.mvvmdemo.activity.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.alibaba.android.arouter.launcher.ARouter;
import com.learn.base.di.component.BaseComponent;
import com.learn.base.di.component.DaggerBaseComponent;
import com.learn.base.utils.InjectUtils;
import com.learn.catdetail.CatDetailActivity;
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
        initDaggerAndInject();

        initView();
        setClickListener();


        getCatList();
    }

    private void initView() {
        progressBar = findViewById(R.id.pb_loading);
        catsListRecyclerView = findViewById(R.id.rv_cats_image_list);

        catsListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        catsListRecyclerView.setHasFixedSize(true);
    }

    private void setClickListener() {
        progressBar.setOnClickListener(v -> jumpCatDetail());
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

    private void jumpCatDetail() {
        Log.d("dd", "asdf");
        ARouter.getInstance()
                .build(CatDetailActivity.PATH)
                .navigation();
    }




}