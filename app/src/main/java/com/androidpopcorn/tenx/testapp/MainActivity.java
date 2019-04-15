package com.androidpopcorn.tenx.testapp;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.androidpopcorn.tenx.testapp.data.ApiService;
import com.androidpopcorn.tenx.testapp.data.AppViewModel;
import com.androidpopcorn.tenx.testapp.adapters.PhotoAdapter;
import com.androidpopcorn.tenx.testapp.data.model.Photo;
import com.androidpopcorn.tenx.testapp.di.ActivityComponent;
import com.androidpopcorn.tenx.testapp.di.AppComponent;
import com.androidpopcorn.tenx.testapp.di.DaggerActivityComponent;
import com.androidpopcorn.tenx.testapp.di.DaggerAppComponent;
import com.androidpopcorn.tenx.testapp.di.ExampleApp;
import com.androidpopcorn.tenx.testapp.di.module.AdapterModule;
import com.androidpopcorn.tenx.testapp.di.module.ApplicationModule;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";

    private CompositeDisposable mDispo;


    private  RecyclerView recyclerView;
    private ActivityComponent  activityComponent;

    @Inject
    public PhotoAdapter adapter;

    private List<Photo> heroList;





    AppViewModel vm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//disposable
        mDispo = new CompositeDisposable();

        ExampleApp app = ((ExampleApp) getApplication());

        activityComponent = DaggerActivityComponent.builder().appComponent(app.getComponent()).adapterModule(new AdapterModule(this)).build();
        activityComponent.inject(this);


//        initialize recycler
        initRecycler(this);


//        view model
        vm = ViewModelProviders.of(this).get(AppViewModel.class);


        vm.getSomePhotos().observe(this, photos -> {
            adapter.updatePhotos(photos);
        });







    }

    public void initRecycler(Context mCtx){

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

}