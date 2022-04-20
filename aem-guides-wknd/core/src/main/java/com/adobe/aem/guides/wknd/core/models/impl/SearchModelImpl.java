package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.SearchModel;
import com.drew.lang.annotations.NotNull;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.factory.ModelFactory;
import org.json.JSONObject;

import javax.json.JsonObject;
import java.util.HashMap;
import java.util.Map;

@Model(
        adaptables = {SlingHttpServletRequest.class},
        adapters = {SearchModel.class},
        resourceType = {SearchModelImpl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class SearchModelImpl implements SearchModel {

    protected static final String RESOURCE_TYPE = "/content/wknd";

    @Self
    private SlingHttpServletRequest request;

    @OSGiService
    private ModelFactory modelFactory;

    @ValueMapValue
    String title;

    @ValueMapValue
    int resultSize;

    @ValueMapValue
    int searchTermMinimumLength;


    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getResultsSize() {
        return 0;
    }

    @Override
    public int getSearchTermMinimumLength() {
        return 0;
    }

}
