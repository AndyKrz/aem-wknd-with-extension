package com.adobe.aem.guides.wknd.core.services;

import org.apache.sling.api.resource.Resource;

public interface SearchService {

    String httpCall() throws Exception;

    String querySearch(Resource resource);

}
