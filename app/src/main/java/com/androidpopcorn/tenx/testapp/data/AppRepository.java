package com.androidpopcorn.tenx.testapp.data;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.androidpopcorn.tenx.testapp.data.model.Photo;
import com.androidpopcorn.tenx.testapp.di.ExampleApp;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AppRepository {

    private static final String TAG = "AppRepository";

    private ApiService apiService;
    private CompositeDisposable mDispo;
    private MutableLiveData<List<Photo>> mList;





    public AppRepository(Application application){
        apiService = ((ExampleApp) application).getApiService();
        mDispo = new CompositeDisposable();
        mList = new MutableLiveData<>();
    }



    public LiveData<List<Photo>> getAllPhotos(){
        loadPhotos();
        return mList;
    }







    private void loadPhotos() {

        apiService.getListPhotos().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<List<Photo>>() {
            @Override
            public void onSubscribe(Disposable d) {
                mDispo.add(d);
            }

            @Override
            public void onNext(List<Photo> photos) {
                mList.setValue(photos);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: "+e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: Completed");
            }
        });
    }

}
