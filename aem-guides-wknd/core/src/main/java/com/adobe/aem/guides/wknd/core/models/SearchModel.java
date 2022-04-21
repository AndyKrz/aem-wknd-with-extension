package com.adobe.aem.guides.wknd.core.models;

import com.adobe.cq.wcm.core.components.models.Component;
import com.adobe.xfa.Int;
import com.drew.lang.annotations.NotNull;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.sling.api.resource.Resource;

import java.util.Iterator;

public interface SearchModel{

    String getRootPath();

    String getTitle();

    int getResultsSize();

    long getLimitOfResults();

    Iterator<Resource> getChildNodes();
}
