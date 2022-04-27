package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.SearchModel;
import com.adobe.aem.guides.wknd.core.models.SearchPageItems;
import com.adobe.aem.guides.wknd.core.services.SearchService;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.request.RequestParameter;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import java.util.*;

@Model(
        adaptables = {SlingHttpServletRequest.class},
        adapters = {SearchModel.class},
        resourceType = {SearchModelImpl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class SearchModelImpl implements SearchModel {

    public static final String QUERY_PARAM = "q";

    protected static final String RESOURCE_TYPE = "apps/wknd/components/searchtext";

    @OSGiService
    SearchService searchService;

    @Self
    private SlingHttpServletRequest request;

    @ValueMapValue
    private long limitOfResults;

    @ValueMapValue
    private String queryParameter;

    @PostConstruct
    public void init(){
        queryParameter = getQueryParameter();
        limitOfResults = getLimitOfResults();
    }

    public SlingHttpServletRequest getRequest() {
        return request;
    }

    //rootPath visibility
    @Override
    public String getRootPath() {
        return searchService.getRootPath();
    }

    @Override
    public long getLimitOfResults() {
        return limitOfResults;
    }

    @Override
    public String getQueryParameter() {
        return Optional
                .ofNullable(request)
                .map(request ->request.getRequestParameter(QUERY_PARAM))
                .map(RequestParameter::getString)
                .orElse("");
    }

    @Override
    public List<SearchPageItems> getResults() {
        ResourceResolver resourceResolver = getRequest().getResourceResolver();
        List<SearchPageItems> resultsFromSearch = searchService.searchResultSQL2(queryParameter,limitOfResults,resourceResolver);
        if(resultsFromSearch == null || resultsFromSearch.isEmpty()) {
            return Collections.emptyList();
        }
        return resultsFromSearch;
    }

    @Override
    public boolean isEmptyQuery(){
        return StringUtils.isBlank(queryParameter);
    }

    @Override
    public boolean isResultEmpty(){
        List<SearchPageItems> emptyResult = getResults();
        return emptyResult.isEmpty();
    }

}
