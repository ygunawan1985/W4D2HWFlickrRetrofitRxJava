package com.example.w4hw2flickrusingretrofitrxjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.w4hw2flickrusingretrofitrxjava.model.datasource.remote.retrofit.RetrofitHelper;
import com.example.w4hw2flickrusingretrofitrxjava.model.datasource.remote.rxjava.Callback;
import com.example.w4hw2flickrusingretrofitrxjava.model.datasource.remote.rxjava.FlickrRepo;
import com.example.w4hw2flickrusingretrofitrxjava.model.flickrresponse.FlickrResponse;
import com.example.w4hw2flickrusingretrofitrxjava.model.flickrresponse.Item;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Callback {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        new RetrofitHelper().getAsyncRandomUsers("kitten", "json", 1);
//        try {
//            new RetrofitHelper().getSyncFlickrResponse("kitten", "json", 1);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        recyclerView = findViewById(R.id.rvFlickr);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FlickrRepo.getFlickr(this);

    }

    @Override
    public void getFlickrResponse(FlickrResponse flickrResponse) {
        //Log.d("TAG_RX", flickrResponse.getItems().get(1).getLink());
        List<Item> items = flickrResponse.getItems();

        FlickrListAdapter flickrListAdapter = new FlickrListAdapter(items);
        recyclerView.setAdapter(flickrListAdapter);
    }
}
