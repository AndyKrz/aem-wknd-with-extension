//package com.adobe.aem.guides.wknd.core.models.impl;
//
//import com.adobe.aem.guides.wknd.core.models.SearchModel;
//import io.wcm.testing.mock.aem.junit5.AemContext;
//import io.wcm.testing.mock.aem.junit5.AemContextExtension;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//@ExtendWith({AemContextExtension.class, MockitoExtension.class})
//public class SearchModelImplTest {
//
//    private final AemContext ctx = new AemContext();
//
//    @BeforeEach
//    void setUp() throws Exception {
//        ctx.addModelsForClasses(SearchModelImpl.class);
//        ctx.load().json("com/adobe/aem/guides/wknd/core/models/impl/SearchModelImplTest.json","/content");
//    }
//
//    @Test
//    public void shouldBeProperPath(){
//        //given
//        final String expected = "";
//        ctx.currentResource("/content/");
//        //when
//        SearchModel searchModel = ctx.request().adaptTo(SearchModel.class);
//        //then
//
//    }
//
//
//}
