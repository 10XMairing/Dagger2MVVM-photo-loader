package com.androidpopcorn.tenx.testapp.data;


import com.androidpopcorn.tenx.testapp.data.model.Photo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;



public interface ApiService {

    String base_url = "https://picsum.photos/";


    @GET("{size}")
    Observable<Photo> getPhoto(@Path("size")String size);


    @GET("list")
    Observable<List<Photo>> getListPhotos();


}
