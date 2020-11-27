package com.example.ifeakachukwuosakwe;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FilteredListFromApi {

    private int id;

    @SerializedName("start_year")
    private int startYear;

    @SerializedName("end_year")
    private int endYear;

    private String gender;

    private ArrayList<String> countries;

    private ArrayList<String> colors;

    public int getId() {
        return id;
    }

    public int getStartYear() {
        return startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public String getGender() {
        return gender;
    }

    public ArrayList<String> getCountries() {
        return countries;
    }

    public ArrayList<String> getColors() {
        return colors;
    }
}
