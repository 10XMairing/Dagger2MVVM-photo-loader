package com.androidpopcorn.tenx.testapp.di;

import android.app.Application;
import android.arch.lifecycle.ViewModelProviders;

import com.androidpopcorn.tenx.testapp.data.ApiService;
import com.androidpopcorn.tenx.testapp.data.AppViewModel;
import com.androidpopcorn.tenx.testapp.di.AppComponent;
import com.androidpopcorn.tenx.testapp.di.DaggerAppComponent;
import com.androidpopcorn.tenx.testapp.di.module.ApplicationModule;

import javax.inject.Inject;

import retrofit2.Retrofit;


public class ExampleApp extends Application {




    @Inject
    Retrofit retrofit;



    private AppComponent component;


    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder().applicationModule(new ApplicationModule(this)).build();
        component.inject(this);







    }


    public ApiService getApiService(){
        return retrofit.create(ApiService.class);
    }

    public AppComponent getComponent() {
        return component;
    }
}
