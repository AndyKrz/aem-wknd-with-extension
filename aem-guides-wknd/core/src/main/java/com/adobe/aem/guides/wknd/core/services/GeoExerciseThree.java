package com.adobe.aem.guides.wknd.core.services;

import com.adobe.aem.guides.wknd.core.models.Country;
import com.adobe.aem.guides.wknd.core.models.impl.DataWorldDao;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class GeoExerciseThree {
    // how many cities are in single country
    public static void main(String[] args) {
        DataWorldDao dataWorldDao = new DataWorldDao();
        Collection<Country> countries = dataWorldDao.findAllCountries();
        Comparator<Country> comparePopulationToArea =
                Comparator.comparingDouble(country -> country.getSurfaceArea() / country.getPopulation());
        countries
                .stream()
                .sorted(comparePopulationToArea.reversed())
                .collect(Collectors.toList())
                .forEach(country -> System.out.printf("%s | %s | %d%n", country.getName(),country.getContinent(), country.getCities().size()));
    }
}