package com.yamschikov.dima.startandroidarchitecturecomponents;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.Date;

public class DataRepository {

    private static MutableLiveData<Long> data = new MutableLiveData<Long>();

    //sets latest time to LiveData
    public static LiveData<Long> getData(){
        data.setValue(new Date().getTime());
        return data;
    }
}
