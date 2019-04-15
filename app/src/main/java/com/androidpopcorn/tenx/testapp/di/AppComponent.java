package com.androidpopcorn.tenx.testapp.di;



import android.content.Context;


import com.androidpopcorn.tenx.testapp.data.ApiService;
import com.androidpopcorn.tenx.testapp.di.module.ApiServiceModule;
import com.androidpopcorn.tenx.testapp.di.module.ApplicationModule;
import com.androidpopcorn.tenx.testapp.di.module.RetrofitModule;
import com.androidpopcorn.tenx.testapp.di.scope.ApplicationContext;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RetrofitModule.class, ApplicationModule.class, ApiServiceModule.class})
public interface AppComponent {

    void inject(ExampleApp exampleApp);

    @ApplicationContext
    Context getContext();

    ApiService getApiService();


}
