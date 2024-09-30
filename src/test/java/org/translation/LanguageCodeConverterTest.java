package org.translation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LanguageCodeConverterTest {

    @Test
    public void fromLanguageCodeEn() {
        LanguageCodeConverter converter = new LanguageCodeConverter();
        assertEquals("English", converter.fromLanguageCode("en"));
    }

    @Test
    public void fromLanguageCodeAllLoaded() {
        LanguageCodeConverter converter = new LanguageCodeConverter();
        assertEquals(184, converter.getNumLanguages());
    }
}
