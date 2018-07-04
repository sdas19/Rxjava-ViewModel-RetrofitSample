package com.example.soumyajitdas.reactdemo.Main;

import com.example.soumyajitdas.reactdemo.ListModel;

import java.util.ArrayList;

public interface MainActivityContract {

    interface View {

        void initView();

        void setViewData(ArrayList<ListModel.Model> data);
    }

    interface Model {

        /*void getDataFromRXJAVA();
        ArrayList<ListModel.Model> getData();*/
    }

    interface Presenter {

        void getDataFromRXJAVA();
        void onClick(android.view.View view);
    }
}
