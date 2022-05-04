package com.adobe.aem.guides.wknd.core.models;

import java.util.ArrayList;
import java.util.List;

public class Country {
    private String code;
    private String name;
    private String continent;
    private double surfaceArea;
    private int population;
    private int capital;
    private List<City> cities = new ArrayList();

    public Country() {
    }

    public Country(String code, String name, String continent, int population, double surfaceArea) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.surfaceArea = surfaceArea;
        this.population = population;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return this.continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public double getSurfaceArea() {
        return this.surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public int getPopulation() {
        return this.population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<City> getCities() {
        return this.cities;
    }

    public String toString() {
        return "Country [ name=" + this.name + ", population=" + this.population + "]";
    }
}
