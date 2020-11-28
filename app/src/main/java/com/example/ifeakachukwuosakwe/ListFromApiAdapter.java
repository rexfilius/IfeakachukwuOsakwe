package com.example.ifeakachukwuosakwe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Response;

public class ListFromApiAdapter extends RecyclerView.Adapter<ListFromApiAdapter.ViewHolder> {

    private List<ListFromApi> mListFromApi;
    private LayoutInflater mLayoutInflater;

    ListFromApiAdapter(Context context, List<ListFromApi> data) {
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mListFromApi = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(
                R.layout.list_from_api_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListFromApi listFromApi = mListFromApi.get(position);
        holder.screenOneTextStartYear.setText(listFromApi.getStartYear());
        holder.screenOneTextEndYear.setText(listFromApi.getEndYear());
        holder.screenOneTextGender.setText(listFromApi.getGender());
        holder.screenOneTextCountries.setText(listFromApi.getCountries().toString());
        holder.screenOneTextColors.setText(listFromApi.getColors().toString());
        //holder.displayFilteredListFromApi();
    }

    @Override
    public int getItemCount() {
        return 0;
        //return mListFromApi.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView screenOneTextStartYear;
        private TextView screenOneTextEndYear;
        private TextView screenOneTextGender;
        private TextView screenOneTextCountries;
        private TextView screenOneTextColors;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            screenOneTextStartYear = itemView.findViewById(R.id.screenOneTextStartYear);
            screenOneTextEndYear = itemView.findViewById(R.id.screenOneTextEndYear);
            screenOneTextGender = itemView.findViewById(R.id.screenOneTextGender);
            screenOneTextCountries = itemView.findViewById(R.id.screenOneTextCountries);
            screenOneTextColors = itemView.findViewById(R.id.screenOneTextColors);
        }

        public void displayFilteredListFromApi(Response<List<ListFromApi>> response) {
            List<ListFromApi> filteredListFromApi = response.body();

            if (filteredListFromApi != null) {

                for (ListFromApi data : filteredListFromApi) {
                    screenOneTextStartYear.setText(String.valueOf(data.getStartYear()));
                    screenOneTextEndYear.setText(String.valueOf(data.getEndYear()));
                    screenOneTextGender.setText(data.getGender());
                    screenOneTextCountries.setText(data.getCountries().toString());
                    screenOneTextColors.setText(data.getColors().toString());
                }
            }

        }

    }
}
