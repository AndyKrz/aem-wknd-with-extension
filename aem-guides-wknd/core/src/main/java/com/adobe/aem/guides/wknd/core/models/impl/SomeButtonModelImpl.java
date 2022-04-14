package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.SomeButtonModel;
import com.adobe.cq.wcm.core.components.models.Button;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = {SomeButtonModel.class },
        resourceType = SomeButtonModelImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class SomeButtonModelImpl implements SomeButtonModel {

    // todo
    protected static final String RESOURCE_TYPE = "wknd/components/somebutton";

    @Inject
    private Resource resource;

    @Inject
    private String filePath;

    @Inject
    private ResourceResolver resourceResolver;

    @Self
    private SlingHttpServletRequest request;

    @ValueMapValue
    private String name;

//    @ValueMapValue
//    private List<String> childNodes;


    private Iterator<Resource> childNodes;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Iterator<Resource> getChildNodes() {
        if(filePath == null || filePath.isEmpty()) {
            return Collections.emptyIterator();
        }

        final Resource resource = resourceResolver.getResource(filePath);

        if(resource == null) {
            return Collections.emptyIterator();
        }
        return resource.listChildren();
    }
//    @Override
//    public List<String> getChildNodes() {
//        if (childNodes != null) {
//            Collections.sort(childNodes);
//            return new ArrayList<String>(childNodes);
//        } else {
//            return Collections.emptyList();
//        }
//    }
}
