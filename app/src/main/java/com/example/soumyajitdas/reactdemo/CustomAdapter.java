package com.example.soumyajitdas.reactdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomAdapter  extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>{

    Context context;
    ArrayList<ListModel.Model> modelArrayList;

    public CustomAdapter(Context context, ArrayList<ListModel.Model> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.model_layout,parent,false);
        CustomViewHolder customViewHolder=new CustomViewHolder(view);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        ListModel.Model model=modelArrayList.get(position);
        holder.textView.setText(model.getName());
        Picasso.get().load(model.getBannerImage())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.name)
        TextView textView;
        @BindView(R.id.image)
        ImageView imageView;

        public CustomViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
