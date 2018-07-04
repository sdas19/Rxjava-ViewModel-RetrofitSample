package com.example.soumyajitdas.reactdemo.Main;


import android.util.Log;
import android.view.View;

import com.example.soumyajitdas.reactdemo.DisposableManager;
import com.example.soumyajitdas.reactdemo.ListModel;
import com.example.soumyajitdas.reactdemo.Retro.ApiClient;
import com.example.soumyajitdas.reactdemo.Retro.PostBody;
import com.example.soumyajitdas.reactdemo.Retro.RetroClass;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.example.soumyajitdas.reactdemo.MainActivity.models;


public class MainActivityPresenter implements MainActivityContract.Presenter {

    private MainActivityContract.View mainView;
    private static String TAG=MainActivityPresenter.class.getSimpleName();

    public MainActivityPresenter(MainActivityContract.View mainView) {
        this.mainView = mainView;
        initMainActivityPresenter();
    }

    public void initMainActivityPresenter()
    {
        mainView.initView();
    }

    @Override
    public void onClick(View view) {

        getDataFromRXJAVA();
    }

    @Override
    public void getDataFromRXJAVA() {

        ApiClient apiClient= RetroClass.getApiService();
        PostBody user = new PostBody("13.0410733","77.6270171","Bangalore");


        Observable<ListModel> observable = apiClient.getList(user).subscribeOn(Schedulers.io()).doOnNext(e -> Log.e(TAG,"onNextOfData: "+Thread.currentThread().getName())).observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<ListModel>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG,"onSubOfData: "+Thread.currentThread().getName());
                DisposableManager.add(d);
            }

            @Override
            public void onNext(ListModel listModel) {


                models = listModel.getModelArrayList();

                mainView.setViewData(models);
                //modelsToBeShown=models;
                Log.e(TAG,"size-->"+models.size());


            }

            @Override
            public void onError(Throwable e) {

            }

            @Override                     /*Cannot return data from here as return type is void, so storing data in another variable*/
            public void onComplete() {
                Log.e(TAG,"completed fetching data");
                //mainView.setViewData(modelsToBeShown);
            }
        });

        return;
    }




}
