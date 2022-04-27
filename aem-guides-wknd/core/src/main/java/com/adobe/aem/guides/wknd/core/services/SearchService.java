package com.adobe.aem.guides.wknd.core.services;

import com.adobe.aem.guides.wknd.core.models.SearchPageItems;
import org.apache.sling.api.resource.ResourceResolver;

import java.util.List;

public interface SearchService {

    List<SearchPageItems> searchResultSQL2(String title, long limitOfResults, ResourceResolver resourceResolver);

    String getRootPath();
}
