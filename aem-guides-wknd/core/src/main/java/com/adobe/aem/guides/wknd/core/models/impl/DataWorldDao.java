package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.City;
import com.adobe.aem.guides.wknd.core.models.Country;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataWorldDao implements WorldDao {
    private final Map<String, Country> countries = new HashMap();
    private final Map<Integer, City> cities = new HashMap();
    private final Set<String> continents;

    public void createCities() {
        this.cities.put(1, new City(1, "Praga", "CZE", 1780000));
        this.cities.put(2, new City(2, "Berlin", "GER", 5237500));
        this.cities.put(3, new City(3, "Krakow", "POL", 2500000));
        this.cities.put(4, new City(4, "Rome", "ITA", 6780000));
        this.cities.put(5, new City(5, "Pekin", "CHI", 21540000));
        this.cities.put(6, new City(6, "Rio de Janeiro", "BRA", 6740000));
        this.cities.put(7, new City(7, "Wroclaw", "POL", 674000));
    }

    public void createCountries() {
        this.countries.put("ITA", new Country("ITA", "Italy", "Europe", 59720000, 302073.0D));
        this.countries.put("POL", new Country("POL", "Poland", "Europe", 37950000, 312679.0D));
        this.countries.put("GER", new Country("GER", "Germany", "Europe", 83240000, 357588.0D));
        this.countries.put("CZE", new Country("CZE", "Czech Republic", "Europe", 10740000, 78871.0D));
        this.countries.put("BRA", new Country("BRA", "Brasil", "South America", 212000000, 8516000.0D));
        this.countries.put("CHI", new Country("CHI", "China", "Asia", 1400740000, 9597000.0D));
    }

    public DataWorldDao() {
        this.createCountries();
        this.createCities();
        Iterator var1 = this.cities.values().iterator();

        while(var1.hasNext()) {
            City city = (City)var1.next();
            Country country = (Country)this.countries.get(city.getCountryCode());
            if (country == null) {
                System.out.println("No such countryCode: " + city.getCountryCode());
            } else {
                country.getCities().add(city);
            }
        }

        this.continents = new HashSet();
        var1 = this.countries.values().iterator();

        while(var1.hasNext()) {
            Country country = (Country)var1.next();
            this.continents.add(country.getContinent());
        }

    }

    public Country findCountryByCode(String code) {
        return (Country)this.countries.get(code);
    }

    public Set<String> getAllContinents() {
        return this.continents;
    }

    public List<Country> findCountriesByContinent(String continent) {
        List<Country> result = new ArrayList();
        Iterator var3 = this.countries.values().iterator();

        while(var3.hasNext()) {
            Country country = (Country)var3.next();
            if (continent.equals(country.getContinent())) {
                result.add(country);
            }
        }

        return result;
    }

    public List<Country> findAllCountries() {
        return new ArrayList(this.countries.values());
    }

    public City findCityById(int id) {
        return (City)this.cities.get(id);
    }

    public List<City> findAllCities() {
        return new ArrayList(this.cities.values());
    }

    public List<City> findCitiesByCountryCode(String countryCode) {
        return this.findCountryByCode(countryCode).getCities();
    }
}
