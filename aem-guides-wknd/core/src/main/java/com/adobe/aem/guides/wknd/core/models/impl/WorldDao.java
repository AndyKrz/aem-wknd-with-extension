package com.adobe.aem.guides.wknd.core.models.impl;

import java.util.Set;

public interface WorldDao extends CountryDao, CityDao {
    Set<String> getAllContinents();
}