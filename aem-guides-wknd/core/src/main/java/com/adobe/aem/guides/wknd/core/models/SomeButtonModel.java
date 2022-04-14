package com.adobe.aem.guides.wknd.core.models;


import org.apache.sling.api.resource.Resource;

import java.util.Iterator;
import java.util.List;

public interface SomeButtonModel {

    String getName();

    List<String> getChildNodes();

    Iterator<Resource> getChildButtonNodes();

}
