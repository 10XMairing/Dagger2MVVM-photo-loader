package com.androidpopcorn.tenx.testapp.di.module;

import com.androidpopcorn.tenx.testapp.data.ApiService;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


@Module
public class ApiServiceModule {

    @Inject
    Retrofit retrofit;


    @Singleton
    @Provides
    public ApiService provideApiService(){
        return retrofit.create(ApiService.class);
    }

}
