package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.Country;
import java.util.List;
import java.util.Set;

public interface CountryDao {
    Country findCountryByCode(String var1);

    List<Country> findAllCountries();

    List<Country> findCountriesByContinent(String var1);

    Set<String> getAllContinents();
}
