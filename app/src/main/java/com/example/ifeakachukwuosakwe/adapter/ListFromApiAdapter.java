package com.example.ifeakachukwuosakwe.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ifeakachukwuosakwe.model.ListFromApi;
import com.example.ifeakachukwuosakwe.R;

import java.util.List;

public class ListFromApiAdapter extends RecyclerView.Adapter<ListFromApiAdapter.ViewHolder> {

    private List<ListFromApi> mListFromApi;
    private Context mContext;

    public ListFromApiAdapter(List<ListFromApi> lists, Context context) {
        this.mListFromApi = lists;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_from_api_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListFromApi listFromApi = mListFromApi.get(position);
        holder.screenOneTextStartYear.setText(String.valueOf(listFromApi.getStartYear()));
        holder.screenOneTextEndYear.setText(String.valueOf(listFromApi.getEndYear()));
        holder.screenOneTextGender.setText(listFromApi.getGender());
        holder.screenOneTextCountries.setText(listFromApi.getCountries().toString());
        holder.screenOneTextColors.setText(listFromApi.getColors().toString());
    }

    @Override
    public int getItemCount() {
        return mListFromApi.size();
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

    }

}
