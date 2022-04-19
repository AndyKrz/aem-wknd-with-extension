package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.SearchModel;
import com.adobe.xfa.Int;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

public class SearchModelImpl implements SearchModel {

    protected static final String RESOURCE_TYPE = "/content/wknd";

    @ValueMapValue
    String name;

    @ValueMapValue
    Int id;

    @Override
    public Int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}
