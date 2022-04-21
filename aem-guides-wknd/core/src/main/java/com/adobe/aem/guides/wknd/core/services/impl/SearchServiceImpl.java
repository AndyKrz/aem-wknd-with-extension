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
import java.util.HashMap;
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
    public String httpResponse(){
                boolean enable = searchConfiguration.enableConfig();
                String rootPath = searchConfiguration.getRootPath();
        return httpResponse();
    }

    private QueryResult querySearch(String rootPath, String title, long limitOfResults, ResourceResolver resourceResolver) throws RepositoryException {
        String sql2Query = "SELECT * FROM [nt:unstructured] AS node WHERE ISDESCENDANTNODE (node," + rootPath + ") ORDER BY node.[jcr.title]"
                + "AND NAME() like %\"" + title + "%\"";
        final Session session = resourceResolver.adaptTo(Session.class);
        final Query query = session.getWorkspace().getQueryManager().createQuery(sql2Query,Query.JCR_SQL2);
        query.setLimit(limitOfResults);
        return query.execute();
    }


    public Map<String,String> searchResultSQL2(String rootPath, String title, long limitOfResults,ResourceResolver resourceResolver) throws RepositoryException {
        Map<String,String> searchedResults = new HashMap<>();
        QueryResult result;

        try {
            result = (QueryResult) searchResultSQL2(rootPath,title,limitOfResults,resourceResolver);
            NodeIterator pages = result.getNodes();
            while(pages.hasNext()){
                Node page = pages.nextNode();
                if(page.hasProperty("jcr:title")) {
                    searchedResults.put("title",page.getProperty("jcr:title").getString());
                    searchedResults.put("name",page.getName());
                    searchedResults.put("created",page.getProperty("jcr:created").getString());
                }
            }
        } catch (RepositoryException e) {
            LOG.error("Exception {}",e.toString());
        }
        return searchedResults;
    }

    @Override
    public String getConfigPath() {
        return searchConfiguration.getRootPath();
    }

}
