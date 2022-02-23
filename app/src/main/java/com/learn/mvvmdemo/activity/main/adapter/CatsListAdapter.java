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

import com.bumptech.glide.Glide;
import com.learn.mvvmdemo.R;
import com.learn.mvvmdemo.bean.CatBean;

import java.util.ArrayList;
import java.util.List;

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
        Log.d(TAG, "cat list item bind image url:" + catBean.getCatImage());
        if (catBean.getCatImage() != null) {
            Glide.with(context)
                    .load(catBean.getCatImage().getUrl())
                    .into(viewHolder.imgViewCover);
        }
    }

    @Override
    public int getItemCount() {
        return this.catBeans.size();
    }

    public void addAllCatsList(List<CatBean> catsList) {
        this.catBeans.addAll(catsList);
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgViewCover;
        private final TextView tvTitle;
        private final TextView tvOrigin;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgViewCover = (ImageView) itemView.findViewById(R.id.imgViewCover);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvOrigin = (TextView) itemView.findViewById(R.id.tvOrigin);
        }
    }
}
