package com.learn.catdetail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;

import static com.learn.base.Constant.CAT_DETAIL_ACTIVITY_URL_KEY;

@Route(path = CatDetailActivity.PATH)
public class CatDetailActivity extends AppCompatActivity {
    public static final String PATH = "/catDetail/main";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_detail_avtivity);

        ImageView backIcon = findViewById(R.id.iv_back);
        backIcon.setOnClickListener(v -> finish());

        String url = getIntent().getStringExtra(CAT_DETAIL_ACTIVITY_URL_KEY);
        ImageView imageView = findViewById(R.id.iv_cat_full_screen);

        Glide.with(this)
                .load(url)
                .placeholder(R.drawable.ic_default_palceholder)
                .fitCenter()
                .into(imageView);
    }
}