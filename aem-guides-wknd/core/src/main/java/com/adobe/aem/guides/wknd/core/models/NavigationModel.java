package com.adobe.aem.guides.wknd.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
import java.util.Collections;
import java.util.Iterator;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NavigationModel {

    @Inject
    private String filePath;

    @Inject
    private ResourceResolver resourceResolver;

    public Iterator<Resource> getChildNodes() {
        if (filePath == null || filePath.isEmpty()) {
            return Collections.emptyIterator();
        }

        final Resource resource = resourceResolver.getResource(filePath);

        if (resource == null) {
            return Collections.emptyIterator();
        }

        return resource.listChildren();
    }
}
