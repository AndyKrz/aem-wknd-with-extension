package com.adobe.aem.guides.wknd.core.servlets;


import com.adobe.aem.guides.wknd.core.services.SearchService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.propertytypes.ServiceDescription;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

@Component
@SlingServletPaths(value = "wknd/components/page")
@ServiceDescription("Search Result Servlet")
public class SearchServlet extends SlingAllMethodsServlet {

    @Reference
    SearchService searchService;

    @Override
    protected void doGet(SlingHttpServletRequest req, SlingHttpServletResponse resp) throws IOException {

//        JSONObject searchResult = null;
        Map<String,String> searchResult = null;
            String searchPath = req.getRequestParameter("searchPath").getString();
//            searchResult = searchService.searchResultSQL2(String,String,long,ResourceResolver);
        resp.setContentType("application/json");
        resp.getWriter().write(searchResult.toString());

    }

}
