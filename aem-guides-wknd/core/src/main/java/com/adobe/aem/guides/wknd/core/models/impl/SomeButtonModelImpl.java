package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.SomeButtonModel;
import com.adobe.cq.wcm.core.components.models.Button;
import org.apache.commons.collections.CollectionUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = {SomeButtonModel.class },
        resourceType = SomeButtonModelImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class SomeButtonModelImpl implements SomeButtonModel {

    protected static final String RESOURCE_TYPE = "/content/wknd/us/en/magazine/guide-la-skateparks";

    @ValueMapValue
    private Resource resource;

    @Self
    private SlingHttpServletRequest request;

    @ValueMapValue(name = "jcr:title")
    private String name;

    @ValueMapValue
    private List<String> childNodes;

    @Override
    public String getName() {
        return name;
    }

    @ValueMapValue
    String resourceType = "/content/wknd/us/en/magazine/guide-la-skateparks";

     @SlingObject
     private ResourceResolver resourceResolver;

    public Iterator<Resource> getChildButtonNodes() {
        if(resourceType == null || resourceType.isEmpty()) {
            return Collections.emptyIterator();
        }
        final Resource resource = resourceResolver.getResource(resourceType);
        if(resource == null) {
            return Collections.emptyIterator();
        }
        return resource.listChildren();
    }

    @Override
    public List<String> getChildNodes() {
        if (CollectionUtils.isNotEmpty(childNodes)) {
            Collections.sort(childNodes);
            return childNodes;
        } else {
            return Collections.emptyList();
        }
    }
}
