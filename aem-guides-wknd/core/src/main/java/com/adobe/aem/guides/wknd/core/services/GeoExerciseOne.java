package com.adobe.aem.guides.wknd.core.services;

import com.adobe.aem.guides.wknd.core.models.Country;
import com.adobe.aem.guides.wknd.core.models.impl.DataWorldDao;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GeoExerciseOne {
    public static void main(String[] args) {

        DataWorldDao dataWorldDao = new DataWorldDao();
        Comparator<Country> sortByCities = (Comparator.comparing(country -> country.getCities().size()));
//        Predicate<Country> countryHaveNoCity = country -> country.getCities().isEmpty();
        List<Country> countryList = dataWorldDao.findAllCountries()
                .stream()
//                .filter(countryHaveNoCity.negate())
                .sorted(sortByCities.reversed())
                .collect(Collectors.toList());
        countryList.forEach(country -> System.out.printf("%s %d%n", country.getName(), country.getCities().size()));
    }
}
