package com.yamschikov.dima.startandroidarchitecturecomponents;

import com.yamschikov.dima.startandroidarchitecturecomponents.users.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StoreApi {

    @GET("storeOffers/")
    Call<StoreInfo> getStoreInfo();

    @GET("posts") ////метод запиту
    Call<List<Users>> getUsersModel();
}

