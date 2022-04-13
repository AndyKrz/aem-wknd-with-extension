package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.SomeButtonModel;
import com.adobe.cq.wcm.core.components.models.Button;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Model(adaptables = SlingHttpServletRequest.class, adapters = {
        Button.class }, resourceType = SomeButtonModelImpl.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SomeButtonModelImpl implements SomeButtonModel {


    // todo
    protected static final String RESOURCE_TYPE = "wknd/components/somebutton";

    @Inject
    private Resource resource;
    @Self
    private SlingHttpServletRequest request;

    @ValueMapValue
    private String name;

    @ValueMapValue
    private String text;

    @ValueMapValue
    private List<String> occupations;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public List<String> getOccupations() {
        if (occupations != null) {
            Collections.sort(occupations);
            return new ArrayList<String>(occupations);
        } else {
            return Collections.emptyList();
        }
    }
}
