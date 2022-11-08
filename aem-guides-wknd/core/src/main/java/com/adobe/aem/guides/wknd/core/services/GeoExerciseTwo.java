package com.adobe.aem.guides.wknd.core.services;

import com.adobe.aem.guides.wknd.core.models.City;
import com.adobe.aem.guides.wknd.core.models.Country;
import com.adobe.aem.guides.wknd.core.models.impl.CityDao;
import com.adobe.aem.guides.wknd.core.models.impl.CountryDao;
import com.adobe.aem.guides.wknd.core.models.impl.DataWorldDao;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.maxBy;

public class GeoExerciseTwo {
//    public static void main(String[] args) {
//
////         take capitals from list of cities
//        DataWorldDao dataWorldDao = new DataWorldDao();
//        Optional<Country> capital = dataWorldDao.findAllCountries()
//                .stream()
////                .map(City::isCapital)
//                .map(Country::getCities)
////                .map(dataWorldDao::findCityById)
//                .filter(Objects::nonNull)
//                        .collect(comparing(City::getPopulation));
////                .collect(maxBy(comparing(City::getPopulation)));
//        capital.ifPresent(out::println);
//    }
}
