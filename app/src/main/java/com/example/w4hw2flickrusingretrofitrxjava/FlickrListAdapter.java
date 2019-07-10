package com.example.w4hw2flickrusingretrofitrxjava;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.w4hw2flickrusingretrofitrxjava.model.flickrresponse.Item;

import java.util.List;

public class FlickrListAdapter extends RecyclerView.Adapter<FlickrListAdapter.ViewHolder>{
    List<Item> items;
    //Context context;

    public FlickrListAdapter(List<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.flickr_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = items.get(position);
        String imageUrl = item.getMedia().getM();

        Glide.with(holder.itemView.getContext()).load(imageUrl).into(holder.ivImage);
        holder.tvTitle.setText(item.getTitle());
        holder.tvAuthor.setText(item.getAuthor());
        holder.tvAuthorId.setText(item.getAuthorId());
        holder.tvPublished.setText(item.getPublished());
        holder.tvImgUrl.setText(item.getLink());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView ivImage;
        TextView tvTitle, tvAuthor, tvAuthorId, tvPublished, tvImgUrl;
        Item item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvAuthorId = itemView.findViewById(R.id.tvAuthorId);
            tvPublished = itemView.findViewById(R.id.tvPublished);
            tvImgUrl = itemView.findViewById(R.id.tvImgUrl);
            //context = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }

        @Override
        public void onClick(View view) {
//            Intent intent = new Intent(view.getContext(), ViewFlickr.class);
//            Bundle bundle = new Bundle();
//            bundle.putParcelable("item", item);
//            intent.putExtras(bundle);
//            view.getContext().startActivity(intent);
        }
    }
}
