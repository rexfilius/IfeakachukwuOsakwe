package com.example.ifeakachukwuosakwe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

interface ListFromApiService {

    @GET
    Call<List<ListFromApi>> getFilterFromApi(@Url String url);

}
