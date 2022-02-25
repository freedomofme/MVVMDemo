package com.learn.mvvmdemo.activity.main.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.learn.catdetail.CatDetailActivity;
import com.learn.mvvmdemo.R;
import com.learn.base.bean.CatBean;

import java.util.ArrayList;
import java.util.List;

import static com.learn.base.Constant.CAT_DETAIL_ACTIVITY_URL_KEY;

public class CatsListAdapter extends RecyclerView.Adapter<CatsListAdapter.ViewHolder> {
    private final String TAG = "CatsListAdapter";
    private Context context;
    List<CatBean> catBeans;

    public CatsListAdapter(Context context) {
        this.context = context;
        this.catBeans = new ArrayList<>();
    }

    @NonNull
    @Override
    public CatsListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adaper_cat_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatsListAdapter.ViewHolder viewHolder, int position) {
        CatBean catBean = catBeans.get(position);
        viewHolder.tvTitle.setText(catBean.getName());
        viewHolder.tvOrigin.setText(catBean.getOrigin());
        if (catBean.getCatImage() != null) {
            String url = catBean.getCatImage().getUrl();
            Log.d(TAG, "cat list item bind image url:" + url);

            Glide.with(context)
                    .load(url)
                    .override(260, 320)
                    .fitCenter()
                    .into(viewHolder.imgViewCover);

            viewHolder.itemView.setOnClickListener(v ->
                    ARouter.getInstance()
                            .build(CatDetailActivity.PATH)
                            .withString(CAT_DETAIL_ACTIVITY_URL_KEY, url)
                            .navigation());
        }

    }

    @Override
    public int getItemCount() {
        return this.catBeans.size();
    }

    public void addAllCatsList(List<CatBean> catsList) {
        this.catBeans.clear();
        this.catBeans.addAll(catsList);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgViewCover;
        private final TextView tvTitle;
        private final TextView tvOrigin;
        private final View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.itemView = itemView;
            imgViewCover = (ImageView) itemView.findViewById(R.id.imgViewCover);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvOrigin = (TextView) itemView.findViewById(R.id.tvOrigin);
        }
    }
}
