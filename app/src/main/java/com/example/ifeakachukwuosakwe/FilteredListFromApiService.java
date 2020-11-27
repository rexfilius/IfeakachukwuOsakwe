package com.example.ifeakachukwuosakwe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

interface FilteredListFromApiService {

    @GET
    Call<List<FilteredListFromApi>> getFilterFromApi(@Url String url);

}
