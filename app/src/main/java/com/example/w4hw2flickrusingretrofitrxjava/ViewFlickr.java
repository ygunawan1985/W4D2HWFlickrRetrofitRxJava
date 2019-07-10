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
    String imgUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flickr);

        ivFlickrImage = findViewById(R.id.ivFlickrImage);
        imgUrl = "";

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Item item = bundle.getParcelable("item");

        if(item != null) {
            imgUrl = item.getMedia().getM();
            Glide.with(this).load(imgUrl).into(ivFlickrImage);
        }
        //Log.d("LOG_LINK", imgUrl);
        //Glide.with(this).load(IMAGE_URL).into(imgImageUsingGlide);
    }
}
