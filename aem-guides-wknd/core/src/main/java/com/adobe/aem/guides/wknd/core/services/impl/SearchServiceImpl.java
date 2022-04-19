package com.adobe.aem.guides.wknd.core.services.impl;

import com.adobe.aem.guides.wknd.core.services.SearchService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Reference;

public class SearchServiceImpl implements SearchService {

    @Reference
    ResourceResolverFactory resourceResolverFactory;


    @Activate
    protected final void activate() throws Exception {
        String resourcePath = "wknd/components/searchtext";
        ResourceResolver resourceResolver = resourceResolverFactory.getResourceResolver(null);
        Resource res = resourceResolver.getResource(resourcePath);
        // todo impl
        resourceResolver.close();
    }

    @Override
    public String querySearch(Resource resource) {

        return querySearch(resource);
    }
}
