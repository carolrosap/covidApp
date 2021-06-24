package com.example.covidapp.model;

public class Country {
    private Long population;
    private Long confirmed;
    private Long recovered;
    private Long deaths;
    private String country;
    private String continent;
    private String abbreviation;



    public Long getPopulation() {
        return population;
    }

    public Long getConfirmed() {
        return confirmed;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public Long getDeaths() {
        return deaths;
    }

    public Long getRecovered() {
        return recovered;
    }

    public String getContinent() {
        return continent;
    }

    public String getCountry() {
        return country;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public void setConfirmed(Long confirmed) {
        this.confirmed = confirmed;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDeaths(Long deaths) {
        this.deaths = deaths;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public void setRecovered(Long recovered) {
        this.recovered = recovered;
    }

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
