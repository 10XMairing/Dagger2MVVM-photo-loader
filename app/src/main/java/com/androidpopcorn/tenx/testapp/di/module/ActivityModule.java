package com.androidpopcorn.tenx.testapp.di.module;

import android.app.Activity;
import android.content.Context;

import com.androidpopcorn.tenx.testapp.di.scope.ActivityContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Activity mActivity;


    public ActivityModule(Activity mActivity) {
        this.mActivity = mActivity;
    }




    @Provides
    @ActivityContext
    Context getContext(){
        return mActivity;
    }


    @Provides
    @ActivityContext
    Activity getActivity(){
        return mActivity;
    }
}
