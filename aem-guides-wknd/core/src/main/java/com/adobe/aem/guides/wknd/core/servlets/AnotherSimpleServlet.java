package com.adobe.aem.guides.wknd.core.servlets;

import com.adobe.cq.export.json.ComponentExporter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import javax.inject.Named;

@Model(adaptables = SlingHttpServletRequest.class, adapters = {
        ComponentExporter.class }, resourceType = AnotherSimpleServlet.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AnotherSimpleServlet implements ComponentExporter {

    protected static final String RESOURCE_TYPE = "wknd/components/somebutton";

    @Inject
    private Resource resource;
    @Self
    private SlingHttpServletRequest request;

    @Override
    public String getExportedType() {
        return null;
    }

    @ValueMapValue
    @Named("Some Button")
    private String SomeButton;

}
