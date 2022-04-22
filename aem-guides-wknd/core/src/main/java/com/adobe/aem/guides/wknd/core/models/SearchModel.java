package com.adobe.aem.guides.wknd.core.models;

import com.adobe.cq.wcm.core.components.models.Component;
import com.adobe.xfa.Int;
import com.drew.lang.annotations.NotNull;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.sling.api.resource.Resource;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public interface SearchModel{

    String getRootPath();

    String getTitle();

    long getLimitOfResults();

    List<Map<String,String>> getChildNodes();

    String getQueryParameter();
}
