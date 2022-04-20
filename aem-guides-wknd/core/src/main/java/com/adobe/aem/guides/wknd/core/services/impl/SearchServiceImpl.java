package com.adobe.aem.guides.wknd.core.services.impl;

import com.adobe.aem.guides.wknd.core.configurations.SearchConfiguration;
import com.adobe.aem.guides.wknd.core.services.SearchService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component(service = SearchService.class,immediate = true)
@Designate(ocd = SearchConfiguration.class)
public class SearchServiceImpl implements SearchService {

    private static final Logger log = LoggerFactory.getLogger(SearchConfiguration.class);

    private SearchConfiguration searchConfiguration;

    @Reference
    ResourceResolverFactory resourceResolverFactory;


    @Activate
    protected void activate(SearchConfiguration searchConfiguration){

        this.searchConfiguration = searchConfiguration;
//        String resourcePath = "wknd/components/searchtext";
//        ResourceResolver resourceResolver = resourceResolverFactory.getResourceResolver(null);
//        Resource res = resourceResolver.getResource(resourcePath);
//        // todo impl
//        resourceResolver.close();
    }

    @Override
    public String httpCall() throws Exception {
            try {
                boolean enable = searchConfiguration.enableConfig();
                String path = searchConfiguration.getPath();
                String endpoint = searchConfiguration.getEndpoint();
            } catch(Exception e) {
                return "Error occurred" + e.getMessage();
        }

        return httpCall();
    }

    @Override
    public String querySearch(Resource resource) {

        return querySearch(resource);
    }
}
