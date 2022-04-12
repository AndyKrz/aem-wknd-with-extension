package com.adobe.aem.guides.wknd.core.models.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import com.adobe.aem.guides.wknd.core.models.Byline;
import com.adobe.cq.wcm.core.components.models.Image;
import com.google.common.collect.ImmutableList;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.sling.api.resource.Resource;

import java.util.List;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
public class BylineImplTest {

    private final AemContext ctx = new AemContext();

    @Mock
    private Image image;

    @Mock
    private ModelFactory modelFactory;

    @BeforeEach
    void setUp() throws Exception {
        ctx.addModelsForClasses(BylineImpl.class);
        ctx.load().json("/com/adobe/aem/guides/wknd/core/models/impl/BylineImplTest.json", "/content");

        lenient().when(modelFactory.getModelFromWrappedRequest(eq(ctx.request()), any(Resource.class), eq(Image.class)))
                .thenReturn(image);

        ctx.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
    }

    @Test
    public void testGetName_shouldReturnGoodName_when_properJSONGiven() {
        //given
        final String expected = "Jane Doe";

        ctx.currentResource("/content/byline");

        //when
        Byline byline = ctx.request().adaptTo(Byline.class);

        String actual = byline.getName();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void testGetName_shouldNotReturnGoodName_when_wrongJSONGiven() {
        //given
        final String expected = "Jane Doe";

        ctx.currentResource("/content/bylineBad");

        //when
        Byline byline = ctx.request().adaptTo(Byline.class);

        String actual = byline.getName();

        //then
        assertNotEquals(expected, actual);
    }

    @Test
    public void testGetOccupations_shouldReturnGoodList_when_properJSONGiven() {
        //given
        List<String> expected = new ImmutableList.Builder<String>()
                .add("Blogger")
                .add("Photographer")
                .add("YouTuber")
                .build();

        ctx.currentResource("/content/byline");

        //when
        Byline byline = ctx.request().adaptTo(Byline.class);

        List<String> actual = byline.getOccupations();

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void testGetOccupations_shouldNotReturnGoodList_when_properJSONGivenAndListIsSorted() {
        //given
        List<String> expected = new ImmutableList.Builder<String>()
                .add("Blogger")
                .add("YouTuber")
                .add("Photographer")
                .build();

        ctx.currentResource("/content/byline");

        //when
        Byline byline = ctx.request().adaptTo(Byline.class);

        List<String> actual = byline.getOccupations();

        //then
        assertNotEquals(expected, actual);
    }

    @Test
    public void testGetOccupations_shouldNotReturnGoodList_when_wrongJSONGiven() {
        //given
        List<String> expected = new ImmutableList.Builder<String>()
                .add("Blogger")
                .add("Photographer")
                .add("YouTuber")
                .build();

        ctx.currentResource("/content/bylineBad");

        //when
        Byline byline = ctx.request().adaptTo(Byline.class);

        List<String> actual = byline.getOccupations();

        //then
        assertNotEquals(expected, actual);
    }

    @Test
    public void testIsEmpty() {
        //given
        ctx.currentResource("/content/empty");

        //when
        Byline byline = ctx.request().adaptTo(Byline.class);

        //then
        assertTrue(byline.isEmpty());
    }

    @Test
    public void testIsEmpty_WithoutName() {
        //given
        ctx.currentResource("/content/without-name");

        //when
        Byline byline = ctx.request().adaptTo(Byline.class);

        //then
        assertTrue(byline.isEmpty());
    }

    @Test
    public void testIsEmpty_WithoutOccupations() {
        //given
        ctx.currentResource("/content/without-occupations");

        //when
        Byline byline = ctx.request().adaptTo(Byline.class);

        //then
        assertTrue(byline.isEmpty());
    }

    @Test
    public void testIsEmpty_WithoutImage() {
        //given
        ctx.currentResource("/content/byline");

        //when
        lenient().when(modelFactory.getModelFromWrappedRequest(eq(ctx.request()),
                any(Resource.class),
                eq(Image.class))).thenReturn(null);

        Byline byline = ctx.request().adaptTo(Byline.class);

        //then
        assertTrue(byline.isEmpty());
    }

    @Test
    public void testIsEmpty_WithoutImageSrc() {
        //given
        ctx.currentResource("/content/byline");

        //when
        when(image.getSrc()).thenReturn("");
        Byline byline = ctx.request().adaptTo(Byline.class);

        //then
        assertTrue(byline.isEmpty());
    }

    @Test
    public void testIsNotEmpty() {
        //given
        ctx.currentResource("/content/byline");

        //when
        when(image.getSrc()).thenReturn("/content/bio.png");
        Byline byline = ctx.request().adaptTo(Byline.class);

        //then
        assertFalse(byline.isEmpty());
    }
}