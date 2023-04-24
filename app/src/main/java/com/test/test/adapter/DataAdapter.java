package com.test.test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.card.MaterialCardView;
import com.test.test.R;
import com.test.test.models.DataModel;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.UserViewHolder> {
    private ArrayList<DataModel> modelList;
    private Context ctx;

    public void setData(ArrayList<DataModel> modelList, Context ctx) {
        this.modelList = modelList;
        this.ctx = ctx;
        notifyDataSetChanged();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        MaterialCardView item;
        TextView event, sender;
        Button duration;
        ImageView image;

        UserViewHolder(View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.item);
            event = itemView.findViewById(R.id.event);
            sender = itemView.findViewById(R.id.sender);
            duration = itemView.findViewById(R.id.duration);
            image = itemView.findViewById(R.id.image);
        }
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_item, viewGroup, false);
        UserViewHolder pvh = new UserViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder vh, int pos) {
        DataModel row = modelList.get(pos);

        vh.event.setText(row.getEvent());
        vh.sender.setText(row.getSenderName());
        vh.duration.setText(row.getDuration());

        //get unique square images
        Glide.with(ctx).load("https://picsum.photos/id/"+pos+"/200/200").transition(DrawableTransitionOptions.withCrossFade()).into(vh.image);
    }

    @Override
    public int getItemCount() {
        if (modelList != null) {
            return modelList.size();
        } else {
            return 0;
        }
    }

}
