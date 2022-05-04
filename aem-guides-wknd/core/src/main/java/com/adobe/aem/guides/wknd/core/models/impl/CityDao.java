package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.City;
import java.util.List;

public interface CityDao {
    City findCityById(int var1);

    List<City> findAllCities();

    List<City> findCitiesByCountryCode(String var1);
}
