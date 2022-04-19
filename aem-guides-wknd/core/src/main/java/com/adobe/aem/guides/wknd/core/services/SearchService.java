package com.adobe.aem.guides.wknd.core.services;

import org.apache.sling.api.resource.Resource;

public interface SearchService {

    String PROP_NAME = "service_name";

    String querySearch(Resource resource);
}
