package com.example.w4hw2flickrusingretrofitrxjava;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.w4hw2flickrusingretrofitrxjava.model.flickrresponse.Item;

import java.util.List;

public class FlickrListAdapter extends RecyclerView.Adapter<FlickrListAdapter.ViewHolder>{
    List<Item> items;
    String imageUrl = "";
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
        imageUrl = item.getMedia().getM();

        Glide.with(holder.itemView.getContext()).load(imageUrl).into(holder.ivImage);
        holder.tvTitle.setText(item.getTitle());
        holder.tvAuthor.setText(item.getAuthor());
        holder.tvAuthorId.setText(item.getAuthorId());
        holder.tvPublished.setText(item.getPublished());
        holder.tvImgUrl.setText(item.getLink());

        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        ImageView ivImage, ivSmallImage;
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
            ivSmallImage = itemView.findViewById(R.id.ivSmallImage);
            //context = itemView.getContext();
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
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

        @Override
        public boolean onLongClick(final View view) {

            // setup the alert builder
            String[] optionsArray = {"Show full image", "Show small image"};
            final String imgUrl = getItem().getMedia().getM();

            final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setTitle("Choose an option:");

            // add a list
            builder.setItems(optionsArray, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(final DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        Intent nextIntent = new Intent(view.getContext(), ViewFlickr.class);
                        Bundle aBundle = new Bundle();
                        aBundle.putString("imgUrl", imgUrl);
                        nextIntent.putExtras(aBundle);
                        view.getContext().startActivity(nextIntent);
                        break;

                    case 1: //Show small image
                        final AlertDialog alert;
                        AlertDialog.Builder smallImgBuilder = new AlertDialog.Builder(view.getContext());
                        LayoutInflater factory = LayoutInflater.from(view.getContext());
                        //Glide.with(factory.getContext()).load(imgUrl).into(ivSmallImage);
                        //ivSmallImage.setImageResource(R.drawable.captainamerica);
                        final View smallImageView = factory.inflate(R.layout.small_image_dialog, null);
                        smallImgBuilder.setView(smallImageView);
                        smallImgBuilder.setTitle("Small Image Dialog");
                        alert = smallImgBuilder.create();
                        alert.show();

                        break;
                }
                }
            });

            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();

            return true;
        }

        private void showSmallImage() {
//            String smallImgUrl = getItem().getMedia().getM();
//            AlertDialog.Builder smallImgBuilder = new AlertDialog.Builder(view.getContext());
//            smallImgBuilder.setTitle("Small Image Dialog");
//            Glide.with(view.getContext()).load(smallImgUrl).into(ivSmallImage);
//            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    Toast.makeText(view.getContext(), "Exiting Dialog", Toast.LENGTH_SHORT).show();
//                    dialog.dismiss();
//                }
//            });
//
//            LayoutInflater inflater = getLayoutInflater();
//            View dialoglayout = inflater.inflate(R.layout.custom_dialog, null);
//
//            builder.setView(dialoglayout);
//            builder.show();
        }
    }
}
