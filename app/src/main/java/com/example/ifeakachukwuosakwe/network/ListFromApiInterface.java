package com.example.ifeakachukwuosakwe.network;

import com.example.ifeakachukwuosakwe.model.ListFromApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ListFromApiInterface {

    @GET("https://run.mocky.io/v3/b4cdeed3-327b-4591-9b06-aaf043e65497/")
    Call<List<ListFromApi>> getFilterFromApi();

}
