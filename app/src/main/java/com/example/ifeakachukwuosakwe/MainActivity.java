package com.example.ifeakachukwuosakwe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView screenOneTitle;

    private List<ListFromApi> mListFromApi;
    private ListFromApiService filteredListFromApiService;
    private final String BASE_URL =
            "https://run.mocky.io/v3/b4cdeed3-327b-4591-9b06-aaf043e65497/";

    ListFromApiAdapter mListFromApiAdapter;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screenOneTitle = findViewById(R.id.screenOneTitle);

        mRecyclerView = findViewById(R.id.list_from_api_recyclerview);
        mListFromApiAdapter = new ListFromApiAdapter(this, mListFromApi);
        mRecyclerView.setAdapter(mListFromApiAdapter);

        createRetrofitInstance();
        getFilteredListFromApi();

    }

    private void createRetrofitInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        filteredListFromApiService = retrofit.create(ListFromApiService.class);
    }

    private void getFilteredListFromApi() {
        Call<List<ListFromApi>> call =
                filteredListFromApiService.getFilterFromApi(BASE_URL);

        call.enqueue(new Callback<List<ListFromApi>>() {
            @Override
            public void onResponse(Call<List<ListFromApi>> call,
                                   Response<List<ListFromApi>> response) {

                if (!response.isSuccessful()) {
                    screenOneTitle.setText(R.string.errorMessage);
                    return;
                }

                mListFromApi = response.body();
                Log.d(TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<List<ListFromApi>> call, Throwable t) {
                screenOneTitle.setText(R.string.errorMessage);
            }
        });
    }

    // removed code from onResponse
    //List<ListFromApi> filteredListFromApi = response.body();
    //                if (filteredListFromApi != null) {
//
//                    for (ListFromApi data : filteredListFromApi) {
//                        ListFromApiAdapter.ViewHolder.displayFilteredListFromApi(response);
//                    }
//                }

//                if (mListFromApi != null) {
//                    for (ListFromApi data : mListFromApi) {
//
//                    }
//                }

}