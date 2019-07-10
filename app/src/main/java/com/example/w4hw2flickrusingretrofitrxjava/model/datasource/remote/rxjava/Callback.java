package com.example.w4hw2flickrusingretrofitrxjava.model.datasource.remote.rxjava;

import com.example.w4hw2flickrusingretrofitrxjava.model.flickrresponse.FlickrResponse;

public interface Callback {
    void getFlickrResponse(FlickrResponse flickrResponse);
}
