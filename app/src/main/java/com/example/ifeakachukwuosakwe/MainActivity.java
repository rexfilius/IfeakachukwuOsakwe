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
    private TextView screenOneTextStartYear;
    private TextView screenOneTextEndYear;
    private TextView screenOneTextGender;
    private TextView screenOneTextCountries;
    private TextView screenOneTextColors;

    private FilteredListFromApiService filteredListFromApiService;
    private final String BASE_URL =
            "https://run.mocky.io/v3/b4cdeed3-327b-4591-9b06-aaf043e65497/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screenOneTitle = findViewById(R.id.screenOneTitle);
        screenOneTextStartYear = findViewById(R.id.screenOneTextStartYear);
        screenOneTextEndYear = findViewById(R.id.screenOneTextEndYear);
        screenOneTextGender = findViewById(R.id.screenOneTextGender);
        screenOneTextCountries = findViewById(R.id.screenOneTextCountries);
        screenOneTextColors = findViewById(R.id.screenOneTextColors);

        createRetrofitInstance();

        getFilteredListFromApi();
    }

    private void createRetrofitInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        filteredListFromApiService = retrofit.create(FilteredListFromApiService.class);
    }

    private void getFilteredListFromApi() {
        Call<List<FilteredListFromApi>> call =
                filteredListFromApiService.getFilterFromApi(BASE_URL);

        call.enqueue(new Callback<List<FilteredListFromApi>>() {
            @Override
            public void onResponse(Call<List<FilteredListFromApi>> call,
                                   Response<List<FilteredListFromApi>> response) {

                if (!response.isSuccessful()) {
                    screenOneTitle.setText(R.string.errorMessage);
                    return;
                }
                displayFilteredListFromApi(response);
            }

            @Override
            public void onFailure(Call<List<FilteredListFromApi>> call, Throwable t) {
                screenOneTitle.setText(R.string.errorMessage);
            }
        });
    }

    private void displayFilteredListFromApi(Response<List<FilteredListFromApi>> response) {
        List<FilteredListFromApi> filteredListFromApi = response.body();

        if (filteredListFromApi != null) {

            for (FilteredListFromApi data : filteredListFromApi) {
                screenOneTextStartYear.setText(String.valueOf(data.getStartYear()));
                screenOneTextEndYear.setText(String.valueOf(data.getEndYear()));
                screenOneTextGender.setText(data.getGender());
                screenOneTextCountries.setText(data.getCountries().toString());
                screenOneTextColors.setText(data.getColors().toString());
            }
        }

    }

}