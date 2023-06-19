package com.example.apipractice.Adapter;

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
import com.example.apipractice.Model.Model;
import com.example.apipractice.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context context;
    ArrayList<Model> responseArrayList = new ArrayList<>();
    public MyAdapter(Context context, ArrayList<Model> responseArrayList) {
        this.context=context;
        this.responseArrayList=responseArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.api_view,parent,false);
        Log.e("TAG","Inside ViewHolder View");
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model api = responseArrayList.get(position);
        holder.tvCopyRight.setText(api.getCopyright());
        holder.tvDate.setText(api.getDate());
        holder.tvTitle.setText(api.getTitle());
        holder.tvText.setText(api.getExplanation());
        Glide.with(context).load(api.getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return responseArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvDate, tvText, tvCopyRight, tvTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvText = itemView.findViewById(R.id.tvText);
            tvCopyRight=itemView.findViewById(R.id.tvCopyRight);
            tvTitle=itemView.findViewById(R.id.tvTitle);
        }
    }
}
