package org.translation;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class JSONTranslatorTest {

    private final JSONTranslator jsonTranslator = new JSONTranslator();

    @Test
    public void getCountryLanguages() {
        List<String> countryLanguages = jsonTranslator.getCountryLanguages("can");
        assertEquals("There should be 35 languages but got " + countryLanguages.size(), 35, countryLanguages.size());
    }

    @Test
    public void getCountries() {
        List<String> languages = jsonTranslator.getCountries();
        assertEquals("There should be 193 countries but got " + languages.size(), 193, languages.size());

    }

    @Test
    public void translate() {
        assertEquals("Canada", jsonTranslator.translate("can", "en"));
    }
}
