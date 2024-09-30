package org.translation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JSONTranslationExampleTest {

    private JSONTranslationExample jsonTranslationExample = new JSONTranslationExample();

    @Test
    public void getCountryNameTranslation() {
        String expected = jsonTranslationExample.getCanadaCountryNameSpanishTranslation();
        String result = jsonTranslationExample.getCountryNameTranslation("can", "es");
        assertEquals("Translating 'can' to 'es' should be " + expected + " but was " + result, expected, result);
    }
}
