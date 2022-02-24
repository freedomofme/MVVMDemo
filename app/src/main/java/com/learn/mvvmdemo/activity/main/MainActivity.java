package com.learn.mvvmdemo.activity.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.learn.base.response.Status;
import com.learn.base.utils.InjectUtils;
import com.learn.catdetail.CatDetailActivity;
import com.learn.mvvmdemo.R;
import com.learn.mvvmdemo.activity.main.adapter.CatsListAdapter;
import com.learn.mvvmdemo.activity.main.viewmodel.CatsListViewModel;
import com.learn.mvvmdemo.di.componet.DaggerMainComponent;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private ProgressBar progressBar;
    private RecyclerView catsListRecyclerView;
    private CatsListViewModel catsListViewModel;
    private CatsListAdapter catsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDaggerAndInject();

        initView();
        setClickListener();
        initObserve();

        getCatList();
    }

    private void setClickListener() {
    }

    private void initObserve() {
        catsListAdapter = new CatsListAdapter(this);
        catsListRecyclerView.setAdapter(catsListAdapter);
        catsListViewModel.catsBeanLiveData.observe(this, listCatResponse -> {
            if (listCatResponse.getStatus() == Status.LOADING) {
                Log.d(TAG, "cats Loading");
               showLoading(true);
            } else if (listCatResponse.getStatus() == Status.ERROR){
                Log.d(TAG, "cats error");
                Toast.makeText(this, listCatResponse.getMessage(), Toast.LENGTH_SHORT).show();
                showLoading(false);
            } else {
                Log.d(TAG, "cats success");
                catsListAdapter.addAllCatsList(listCatResponse.getData());
                showLoading(false);
            }
        });
    }

    private void initView() {
        progressBar = findViewById(R.id.pb_loading);
        catsListRecyclerView = findViewById(R.id.rv_cats_image_list);

        catsListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        catsListRecyclerView.setHasFixedSize(true);
    }

    private void showLoading(boolean loading) {
        if (loading) {
            this.progressBar.setVisibility(View.VISIBLE);
        } else {
            this.progressBar.setVisibility(View.GONE);
        }
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