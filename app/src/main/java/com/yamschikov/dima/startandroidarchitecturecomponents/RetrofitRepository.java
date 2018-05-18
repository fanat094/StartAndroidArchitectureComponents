package com.yamschikov.dima.startandroidarchitecturecomponents;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.socks.library.KLog;
import com.yamschikov.dima.startandroidarchitecturecomponents.users.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRepository {

    public static final String BASE_URL = "http://www.zoftino.com/api/";
    public static final String BASE_URL_USERS = "https://jsonplaceholder.typicode.com/";

    private static MutableLiveData<StoreInfo> data = new MutableLiveData<StoreInfo>();

    private static MutableLiveData<List<Users>> datausers = new MutableLiveData<List<Users>>();

    private static Retrofit retrofit = null;

    public static Retrofit getRetrofitClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL_USERS)
                    .addConverterFactory(GsonConverterFactory.create())
                    //execute call back in background thread
                    .callbackExecutor(Executors.newSingleThreadExecutor())
                    .build();
        }
        return retrofit;
    }

    public static LiveData<List<Users>> getIntData() {
        return datausers;
    }

    public static void getStoreInfo() {
        Log.d("", "PROCESSING IN THREAD BEFORE RETROFIT CALL " + Thread.currentThread().getName());
        Call<StoreInfo> call = getRetrofitClient().create(StoreApi.class).getStoreInfo();

        //rest service call runs on background thread and Callback also runs on background thread
        call.enqueue(new Callback<StoreInfo>() {
            @Override
            public void onResponse(Call<StoreInfo> call, Response<StoreInfo> response) {
                StoreInfo si = response.body();
                //use postValue since it is running on background thread.
                data.postValue(si);
               // Log.d("AAConResponse", "PROCESSING IN THREAD IN RETROFIT RESPONSE HANDLER " + Thread.currentThread().getName());
               // KLog.e("AAConResponse", response);
            }

            @Override
            public void onFailure(Call<StoreInfo> call, Throwable t) {
              //  Log.d("AAConFailure", "Error RETROFIT");
             //   KLog.e("AAConFailure", t.getMessage());
            }
        });
    }


    public static void getUsersInfo() {
        Log.d("", "PROCESSING IN THREAD BEFORE RETROFIT CALL " + Thread.currentThread().getName());
        Call<List<Users>> call = getRetrofitClient().create(StoreApi.class).getUsersModel();

        call.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {

                List<Users> users = new ArrayList<>();
                users = response.body();
                datausers.postValue(users);
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {

            }
        });
    }

}