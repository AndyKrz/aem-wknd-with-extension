package com.adobe.aem.guides.wknd.core.services.impl;

import com.adobe.aem.guides.wknd.core.configurations.SearchConfiguration;
import com.adobe.aem.guides.wknd.core.models.SearchPageItems;
import com.adobe.aem.guides.wknd.core.services.SearchService;
import com.google.common.collect.Lists;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.query.Query;
import javax.jcr.query.QueryResult;
import java.util.*;


@Component(service = SearchService.class, immediate = true)
@Designate(ocd = SearchConfiguration.class)
public class SearchServiceImpl implements SearchService {

    private static final Logger LOG = LoggerFactory.getLogger(SearchConfiguration.class);

    private SearchConfiguration searchConfiguration;

    public String rootPath;

    public String getRootPath() {
        return rootPath;
    }

    @Activate
    @Modified
    protected void activate(SearchConfiguration searchConfiguration) {
        rootPath = searchConfiguration.getRootPath();
    }
    //    todo change method to more efficient
    private QueryResult querySearch(String title, long limitOfResults, ResourceResolver resourceResolver) throws RepositoryException {
//        final String SQL2_QUERY = String.format("SELECT * FROM [cq:Page] AS page WHERE ISDESCENDANTNODE (page,\"  %s  \")"
//                + "AND NAME() like \" %s \" ORDER BY page.[jcr.title]",rootPath,title);
        String sql2Query = "SELECT * FROM [cq:Page] AS page WHERE ISDESCENDANTNODE (page,\"" + rootPath + "\")"
                + "AND NAME() like \"%" + title + "%\" ORDER BY page.[jcr.title]";
        final Session session = resourceResolver.adaptTo(Session.class);
        final Query query = session.getWorkspace().getQueryManager().createQuery(sql2Query, Query.JCR_SQL2);
        query.setLimit(limitOfResults);
        return query.execute();
    }

    public List<SearchPageItems> searchResultSQL2(String title, long limitOfResults, ResourceResolver resourceResolver) {
        List<SearchPageItems> searchedResults = new ArrayList<>();
        try {
            QueryResult result;
            result = querySearch(title, limitOfResults, resourceResolver);
            NodeIterator pages = result.getNodes();
            while (pages.hasNext()) {
                SearchPageItems items = new SearchPageItems();
                Node page = pages.nextNode();
                items.setName(page.getName());
                items.setPath(page.getPath());
                items.setThumbnail(page.getPath()+"/jcr:content/image/file.thumb.jpg");
                searchedResults.add(items);
            }
        } catch (RepositoryException e) {
            LOG.error("Exception {}", e.toString());
        }
        return searchedResults;
    }

}
