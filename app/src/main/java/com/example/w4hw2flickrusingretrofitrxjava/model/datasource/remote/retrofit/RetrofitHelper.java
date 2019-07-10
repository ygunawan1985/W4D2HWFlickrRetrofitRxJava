package com.example.w4hw2flickrusingretrofitrxjava.model.datasource.remote.retrofit;

import android.util.Log;

import com.example.w4hw2flickrusingretrofitrxjava.model.datasource.remote.okhttp3.OkhttpHelper;
import com.example.w4hw2flickrusingretrofitrxjava.model.flickrresponse.FlickrResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.w4hw2flickrusingretrofitrxjava.model.datasource.remote.retrofit.UrlConstants.BASE_URL;

public class RetrofitHelper {

    static FlickrResponse flickrResponse;

    public Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkhttpHelper.getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public RandomService getService() {
        return getRetrofitInstance().create(RandomService.class);
    }

    public RandomObservableService getObservableService() {
        return getRetrofitInstance().create(RandomObservableService.class);
    }

    public FlickrResponse getSyncFlickrResponse(final String tag, final String format, final int nojsoncallback) throws Exception {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = getService().getFlickrResponse(tag, format, String.valueOf(nojsoncallback)).execute();
                    flickrResponse = (FlickrResponse) response.body();
                    Log.d("TAG_RETROFIT", flickrResponse.getItems().get(0).getTitle());
                    Log.d("TAG_RETROFIT", flickrResponse.getItems().get(0).getPublished());
                    Log.d("TAG_RETROFIT", flickrResponse.getItems().get(0).getAuthor());
                    Log.d("TAG_RETROFIT", flickrResponse.getItems().get(0).getAuthorId());
                } catch (IOException e) {

                }
            }
        });
        thread.start();
        return flickrResponse;
    }

    public void getAsyncRandomUsers(String tag, String format, int nojsoncallback) {
        RetrofitHelper retrofitHelper = new RetrofitHelper();
        retrofitHelper.getService().getFlickrResponse(tag, format, String.valueOf(nojsoncallback)).enqueue(new Callback<FlickrResponse>() {
            @Override
            public void onResponse(Call<FlickrResponse> call, Response<FlickrResponse> response) {
                String titleInList = response.body().getItems().get(0).getTitle();
                Log.d("TAG_ASYNC_RETRO", titleInList);
            }

            @Override
            public void onFailure(Call<FlickrResponse> call, Throwable t) {

            }
        });
    }


}
