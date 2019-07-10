package com.example.w4hw2flickrusingretrofitrxjava.model.datasource.remote.rxjava;

import android.util.Log;

import com.example.w4hw2flickrusingretrofitrxjava.model.flickrresponse.FlickrResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class FlickrObserver implements Observer<FlickrResponse> {
    Callback callback;
    private FlickrResponse flickrResponse;

    public FlickrObserver(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void onSubscribe(Disposable d) {
        //Do what is in here when we a object starts listening for emitting

    }

    @Override
    public void onNext(FlickrResponse flickrResponse) {
        //Do this when we get an result
        Log.d("TAG_RX", flickrResponse.getItems().get(0).getLink());
        this.flickrResponse = flickrResponse;
    }

    @Override
    public void onError(Throwable e) {
        //Do this if something goes wrong
    }

    @Override
    public void onComplete() {
        callback.getFlickrResponse(flickrResponse);
    }
}
