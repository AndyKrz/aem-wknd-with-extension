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
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

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

//    public SlingHttpServletRequest getRequest() {
//        return request;
//    }

//    Map<String,String> getQueryItem = searchService.searchResultSQL2(getRootPath(),getTitle(),getLimitOfResults(),resourceResolver);

    @ValueMapValue
    private long limitOfResults;

    @ValueMapValue
    String title;

    @ValueMapValue
    private int resultSize;

    @Override
    public String getRootPath() {
        return searchService.getRootPath();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getResultsSize() {
        return resultSize;
    }

    @Override
    public long getLimitOfResults() {
        return limitOfResults;
    }

    public Iterator<Resource> getChildNodes() {
        if(getRootPath() == null || getRootPath().isEmpty()) {
            return Collections.emptyIterator();
        }
        final Resource resource = resourceResolver.getResource(getRootPath());
        if(resource == null) {
            return Collections.emptyIterator();
        }
        return resource.listChildren();
    }

}
