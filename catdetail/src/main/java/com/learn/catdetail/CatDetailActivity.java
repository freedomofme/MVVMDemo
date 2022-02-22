package com.learn.catdetail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = CatDetailActivity.PATH)
public class CatDetailActivity extends AppCompatActivity {
    public static final String PATH = "/catDetail/main";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_detail_avtivity);
    }
}