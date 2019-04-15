package com.androidpopcorn.tenx.testapp.data;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;


import com.androidpopcorn.tenx.testapp.data.model.Photo;


import java.util.List;


public class AppViewModel extends AndroidViewModel {

    private static final String TAG = "AppViewModel";

    private AppRepository appRepository;


    public AppViewModel(@NonNull Application application) {
        super(application);

        appRepository = new AppRepository(application);

    }




    
    public LiveData<List<Photo>> getSomePhotos(){
            return appRepository.getAllPhotos();
    }


}
