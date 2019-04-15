package com.androidpopcorn.tenx.testapp.di;

import com.androidpopcorn.tenx.testapp.MainActivity;
import com.androidpopcorn.tenx.testapp.di.module.ActivityModule;
import com.androidpopcorn.tenx.testapp.di.module.AdapterModule;
import com.androidpopcorn.tenx.testapp.di.scope.PerActivity;

import dagger.Component;


@PerActivity
@Component( dependencies = {AppComponent.class}, modules = {AdapterModule.class, ActivityModule.class})
public interface ActivityComponent {

    void inject(MainActivity mainactivity);

}