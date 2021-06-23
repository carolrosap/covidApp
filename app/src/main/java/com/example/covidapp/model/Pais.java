package com.example.covidapp.model;

public class Pais {
    public double population;
    public double confirmed;
    public double recovered;
    public double deaths;
    public String country;
    public String continent;
    public String abbreviation;

    @Override
    public String toString() {
        return "Pais{" +
                "population=" + population +
                ", confirmed=" + confirmed +
                ", recovered=" + recovered +
                ", deaths=" + deaths +
                ", country='" + country + '\'' +
                ", continent='" + continent + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                '}';
    }
}
