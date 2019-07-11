package com.example.w4hw2flickrusingretrofitrxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.w4hw2flickrusingretrofitrxjava.model.flickrresponse.Item;

public class ViewFlickr extends AppCompatActivity {

    ImageView ivFlickrImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flickr);

        ivFlickrImage = findViewById(R.id.ivFlickrImage);

        Intent intent = getIntent();
        String imgUrl = intent.getExtras().getString("imgUrl");
        Glide.with(this).load(imgUrl).into(ivFlickrImage);
    }
}
