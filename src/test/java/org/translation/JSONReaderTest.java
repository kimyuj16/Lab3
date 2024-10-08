package org.translation;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class JSONReaderTest {

    private JSONTranslationExample jsonTranslationExample;

    @Before
    public void setUp() {
        jsonTranslationExample = new JSONTranslationExample();
    }

    @Test
    public void testGetCountryNameTranslationUsaEn() {
        String result = jsonTranslationExample.getCountryNameTranslation("usa", "en");
        assertEquals("United States of America", result);
    }

    @Test
    public void testGetCountryNameTranslationFraFr() {
        String result = jsonTranslationExample.getCountryNameTranslation("fra", "fr");
        assertEquals("France", result);
    }

    @Test
    public void testGetCountryNameTranslationDeuDe() {
        String result = jsonTranslationExample.getCountryNameTranslation("deu", "de");
        assertEquals("Deutschland", result);
    }

    @Test
    public void testGetCountryNameTranslationInvalidCountry() {
        String result = jsonTranslationExample.getCountryNameTranslation("ut", "en");
        assertEquals("Country not found", result);
    }

}
