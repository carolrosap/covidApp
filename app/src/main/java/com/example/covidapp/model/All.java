package com.example.covidapp.model;

public class All {
    private Country All = new Country();

    public All(){
        super();
    }

    public All(Country c){
        All = ((Country) c);
    }



    @Override
    public String toString() {
        return "Pais: " + All.toString();
    }

    public Country getCountry() {
        return All;
    }

    public void setCountry(Country all) {
        All = all;
    }


}
