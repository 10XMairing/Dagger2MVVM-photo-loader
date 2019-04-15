package com.androidpopcorn.tenx.testapp.di.module;


import android.content.Context;

import com.androidpopcorn.tenx.testapp.adapters.PhotoAdapter;
import com.androidpopcorn.tenx.testapp.data.model.Photo;
import com.androidpopcorn.tenx.testapp.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class AdapterModule {
    private Context mCtx;

    public AdapterModule(Context mCtx) {
        this.mCtx = mCtx;
    }


    @PerActivity
    @Provides
    public PhotoAdapter provideAdapter(){
     return new PhotoAdapter(mCtx);
    }
}
