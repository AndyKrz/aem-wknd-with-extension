package com.adobe.aem.guides.wknd.core.services.impl;

import com.adobe.aem.guides.wknd.core.configurations.SearchConfiguration;
import com.adobe.aem.guides.wknd.core.models.impl.SearchModelImpl;
import com.adobe.aem.guides.wknd.core.services.SearchService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.query.Query;
import javax.jcr.query.QueryResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component(service = SearchService.class,immediate = true)
@Designate(ocd = SearchConfiguration.class)
public class SearchServiceImpl implements SearchService {

    private static final Logger LOG = LoggerFactory.getLogger(SearchConfiguration.class);

    private SearchConfiguration searchConfiguration;

    @Self
    private SlingHttpServletRequest request;

    @Activate
    @Modified
    protected void activate(SearchConfiguration searchConfiguration){
        this.searchConfiguration = searchConfiguration;
    }

    @Override
    public boolean enableConfig() {
        return searchConfiguration.enableConfig();
    }

    @Override
    public String getRootPath(){
        return searchConfiguration.getRootPath();
    }

    private QueryResult querySearch(String path, String title, long limitOfResults, ResourceResolver resourceResolver) throws RepositoryException {
        String sql2Query = "SELECT * FROM [nt:unstructured] AS node WHERE ISDESCENDANTNODE (node," + path + ") ORDER BY node.[jcr.title]"
                + "AND NAME() like %\"" + title + "%\"";
        final Session session = resourceResolver.adaptTo(Session.class);
        assert session != null;
        final Query query = session.getWorkspace().getQueryManager().createQuery(sql2Query,Query.JCR_SQL2);
        query.setLimit(limitOfResults);
        return query.execute();
    }


    public List<Map<String,String>> searchResultSQL2(String path, String title, long limitOfResults, ResourceResolver resourceResolver) {
        List<Map<String,String>> searchedResults = new ArrayList<>();
        QueryResult result;
        try {
            result = querySearch(path,title,limitOfResults,resourceResolver);
            NodeIterator pages = result.getNodes();
            while(pages.hasNext()){
                Map<String, String> pagesProperty = new HashMap<>();
                Node page = pages.nextNode();
                if(page.hasProperty("jcr:title")) {
                    pagesProperty.put("title",page.getProperty("jcr:title").getString());
                    pagesProperty.put("name",page.getName());
                    pagesProperty.put("path", page.getPath());
                    pagesProperty.put("created",page.getProperty("jcr:created").getString());
                    searchedResults.add(pagesProperty);
                }
            }
        } catch (RepositoryException e) {
            LOG.error("Exception {}",e.toString());
        }
        return searchedResults;
    }

}
