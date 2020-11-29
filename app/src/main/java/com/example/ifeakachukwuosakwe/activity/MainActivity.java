package com.example.ifeakachukwuosakwe.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.ifeakachukwuosakwe.R;
import com.example.ifeakachukwuosakwe.adapter.ListFromApiAdapter;
import com.example.ifeakachukwuosakwe.model.ListFromApi;
import com.example.ifeakachukwuosakwe.network.ListFromApiInterface;
import com.example.ifeakachukwuosakwe.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<ListFromApi> mListFromApi;
    private ListFromApiInterface mListFromApiInterface;
    private ListFromApiAdapter mListFromApiAdapter;

    private TextView screenOneTitle;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screenOneTitle = findViewById(R.id.screenOneTitle);
        mRecyclerView = findViewById(R.id.list_from_api_recyclerview);

        getFilteredListFromApi();
    }

    private void getFilteredListFromApi() {
        mListFromApiInterface =
                RetrofitInstance.getRetrofitInstance()
                        .create(ListFromApiInterface.class);

        Call<List<ListFromApi>> call = mListFromApiInterface.getFilterFromApi();

        call.enqueue(new Callback<List<ListFromApi>>() {
            @Override
            public void onResponse(Call<List<ListFromApi>> call,
                                   Response<List<ListFromApi>> response) {

                mListFromApi = response.body();
                mListFromApiAdapter =
                        new ListFromApiAdapter(mListFromApi, MainActivity.this);
                mRecyclerView.setAdapter(mListFromApiAdapter);
            }

            @Override
            public void onFailure(Call<List<ListFromApi>> call, Throwable t) {
                screenOneTitle.setText(R.string.errorMessage);
            }
        });
    }

}
