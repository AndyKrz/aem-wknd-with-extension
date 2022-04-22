package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.SearchModel;
import com.adobe.aem.guides.wknd.core.services.SearchService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.osgi.service.component.annotations.Reference;

import javax.jcr.RepositoryException;
import java.util.*;

@Model(
        adaptables = {SlingHttpServletRequest.class},
        adapters = {SearchModel.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class SearchModelImpl implements SearchModel {

    @OSGiService
    SearchService searchService;

    @Self
    private SlingHttpServletRequest request;

    @SlingObject
    private ResourceResolver resourceResolver;

    public SlingHttpServletRequest getRequest() {
        return request;
    }

    @ValueMapValue
    private long limitOfResults;

    @ValueMapValue
    String title;

    @Override
    public String getRootPath() {
        return searchService.getRootPath();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public long getLimitOfResults() {
        return limitOfResults;
    }

    @Override
    public String getQueryParameter() {
        return request.getQueryString();
    }

    public List<Map<String,String>> getChildNodes() {
        ResourceResolver resourceResolver = request.getResourceResolver();
        List<Map<String,String>> resultsFromSearch = searchService.searchResultSQL2(getRootPath(),getQueryParameter(),getLimitOfResults(),resourceResolver);
        if(resultsFromSearch == null || resultsFromSearch.isEmpty()) {
            Map<String,String> noResults = new HashMap<>();
            noResults.put("title", "Not match for: " + getQueryParameter() + " . Try other query.");
            assert resultsFromSearch != null;
            resultsFromSearch.add(noResults);
        }
        return resultsFromSearch;
    }

}
