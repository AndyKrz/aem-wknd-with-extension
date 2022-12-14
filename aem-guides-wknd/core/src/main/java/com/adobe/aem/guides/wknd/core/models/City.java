package com.adobe.aem.guides.wknd.core.models;

public class City {
    private int id;
    private String name;
    private int population;
    private String countryCode;
    private boolean capital;

    public City() {
    }

    public City(int id, String name, String countryCode, int population, boolean capital) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.countryCode = countryCode;
        this.capital = capital;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return this.population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    public String toString() {
        return "City [id=" + this.id + ", name=" + this.name + ", population=" + this.population +
                ", countryCode=" + this.countryCode + ", capital=" + this.capital + "]";
    }

    public boolean getCapital() { return this.capital;
    }
}