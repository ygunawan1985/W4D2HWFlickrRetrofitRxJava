package com.example.w4hw2flickrusingretrofitrxjava.model.datasource.remote.retrofit;

import com.example.w4hw2flickrusingretrofitrxjava.model.flickrresponse.FlickrResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.w4hw2flickrusingretrofitrxjava.model.datasource.remote.retrofit.UrlConstants.PATH;
import static com.example.w4hw2flickrusingretrofitrxjava.model.datasource.remote.retrofit.UrlConstants.QUERY_FORMAT;
import static com.example.w4hw2flickrusingretrofitrxjava.model.datasource.remote.retrofit.UrlConstants.QUERY_NOJSONCALLBACK;
import static com.example.w4hw2flickrusingretrofitrxjava.model.datasource.remote.retrofit.UrlConstants.QUERY_TAG;

public interface RandomObservableService {

    @GET(PATH)
    Observable<FlickrResponse> getFlickrResponse(
            @Query(QUERY_TAG)String tag,
            @Query(QUERY_FORMAT)String format,
            @Query(QUERY_NOJSONCALLBACK)String nojsoncallback);
}
