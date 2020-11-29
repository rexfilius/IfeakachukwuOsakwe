package com.example.ifeakachukwuosakwe.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ListFromApi {

    private int id;

    @SerializedName("start_year")
    private int startYear;

    @SerializedName("end_year")
    private int endYear;

    private String gender;

    private ArrayList<String> countries;

    private ArrayList<String> colors;

    public ListFromApi(int startYear, int endYear, String gender,
                       ArrayList<String> countries, ArrayList<String> colors) {
        this.startYear = startYear;
        this.endYear = endYear;
        this.gender = gender;
        this.countries = countries;
        this.colors = colors;
    }

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
