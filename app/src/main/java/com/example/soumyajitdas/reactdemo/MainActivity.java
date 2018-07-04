package com.example.soumyajitdas.reactdemo;

import android.app.ActivityManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.soumyajitdas.reactdemo.Main.MainActivityContract;
import com.example.soumyajitdas.reactdemo.Main.MainActivityPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final String restoreListKey="key";

    public static ArrayList<ListModel.Model> models;


    MainActivityPresenter mainActivityPresenter;


    RecyclerView recyclerView;


    Button getDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mainActivityPresenter=new MainActivityPresenter(this);

        if(savedInstanceState!=null)
        {
            Log.e(TAG,"saved instance");
            models=savedInstanceState.getParcelableArrayList(restoreListKey);
            setViewData(models);
        }

        ButterKnife.bind(this);

        //demo1();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if(models!=null)
        {
            outState.putParcelableArrayList(restoreListKey,models);
        }


    }

    @Override
    public void initView() {

        recyclerView=(RecyclerView) findViewById(R.id.recycler);
        getDataButton=(Button) findViewById(R.id.get_data_button);


        getDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mainActivityPresenter.onClick(v);
            }
        });

    }

    @Override
    public void setViewData(ArrayList<ListModel.Model> data) {

        if(data!=null)
        {
            CustomAdapter customAdapter=new CustomAdapter(this,data);
            recyclerView.setAdapter(customAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
            recyclerView.setHasFixedSize(true);
        }
    }

    @Override
    protected void onDestroy() {

        DisposableManager.dispose();

        super.onDestroy();
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        ActivityManager am = (ActivityManager)this.getSystemService(this.ACTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            am.clearApplicationUserData();
        }


    }

    /*private void demo1() {

        Observable.just("First item","Second item")
                .subscribeOn(Schedulers.io())
                .doOnNext(e -> Log.d(MainActivity.class.getSimpleName(),"onNext: "+Thread.currentThread().getName()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(e -> Log.d(MainActivity.class.getSimpleName(),"onSub: "+Thread.currentThread().getName()));
    }*/


}
