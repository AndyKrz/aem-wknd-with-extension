package com.adobe.aem.guides.wknd.core.services;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;

import javax.jcr.RepositoryException;
import javax.jcr.query.QueryResult;
import java.util.Map;

public interface SearchService {

    String httpResponse();

    Map<String,String> searchResultSQL2(String rootPath, String titleOfNode, long limitOfResults,ResourceResolver resourceResolver)
            throws RepositoryException;

    String getConfigPath();

}
