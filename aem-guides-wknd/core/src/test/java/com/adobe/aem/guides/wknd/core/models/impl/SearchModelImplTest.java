package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.SearchModel;
import com.adobe.aem.guides.wknd.core.services.SearchService;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.osgi.framework.Constants;

import static com.adobe.aem.guides.wknd.core.models.impl.SearchModelImpl.QUERY_PARAM;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
public class SearchModelImplTest {

    @Mock
    private SearchService searchService;

    private final AemContext ctx = new AemContext();

    @BeforeEach
    void setUp() throws Exception {
        ctx.addModelsForClasses(SearchModelImpl.class);
        ctx.load().json("/com/adobe/aem/guides/wknd/core/models/impl/SearchModelImplTest.json","/content");
        ctx.registerService(SearchService.class,searchService, Constants.SERVICE_RANKING,Integer.MAX_VALUE);
    }

    @Test
    public void shouldBeEmptyResultLimit(){
        //given
        final long expected = 0;
        ctx.currentResource("/content/searchModelIsEmpty");
        //when
        SearchModel searchModel = ctx.request().adaptTo(SearchModel.class);
        long actual = searchModel.getLimitOfResults();
        //then
        assertEquals(expected,actual);

    }

    @Test
    public void shouldNotBeEmptyResultLimit(){
        //given
        final long expected = 8;
        ctx.currentResource("/content/searchModelIsNotEmpty");
        //when
        SearchModel searchModel = ctx.request().adaptTo(SearchModel.class);
        long actual = searchModel.getLimitOfResults();
        //then
        assertEquals(expected,actual);
    }

//    @Test
//    public void shouldGetProperQueryParameter(){
//        //given
//        final String expected = QUERY_PARAM;
//        ctx.currentResource("/content/queryParameterExist");
//        //when
//        SearchModel searchModel = ctx.request().adaptTo(SearchModel.class);
//        String actual = searchModel.getQueryParameter();
//        assertEquals(expected,actual);
//    }
}
