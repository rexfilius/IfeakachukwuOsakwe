package com.example.ifeakachukwuosakwe.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit sRetrofit = null;

    private static final String BASE_URL =
            "https://run.mocky.io/v3/b4cdeed3-327b-4591-9b06-aaf043e65497/";

    public static Retrofit getRetrofitInstance() {
        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sRetrofit;
    }

}
