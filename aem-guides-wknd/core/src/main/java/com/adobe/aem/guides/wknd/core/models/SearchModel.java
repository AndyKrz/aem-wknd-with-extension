package com.adobe.aem.guides.wknd.core.models;

import java.util.List;

public interface SearchModel{

    String getRootPath();

    long getLimitOfResults();

    List<SearchPageItems> getResults();

    String getQueryParameter();

    boolean isEmptyQuery();

    boolean isResultEmpty();
}
