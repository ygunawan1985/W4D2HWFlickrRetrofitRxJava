package com.example.w4hw2flickrusingretrofitrxjava.model.datasource.remote.rxjava;

import com.example.w4hw2flickrusingretrofitrxjava.model.datasource.remote.retrofit.RetrofitHelper;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class FlickrRepo {

    public static void getFlickr(Callback callback){
        new RetrofitHelper()
                .getObservableService()
                .getFlickrResponse("kitten", "json", "1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new FlickrObserver(callback));
    }
}
