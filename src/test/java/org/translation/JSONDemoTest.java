package org.translation;

import static org.junit.Assert.assertEquals;

import org.json.JSONArray;
import org.junit.Test;

public class JSONDemoTest {

    @Test
    public void getKeyOneOfSecond() {
        String jsonData = "[{\"key1\" : \"string1a\", \"key2\":21}, {\"key1\" : \"string1b\", \"key2\":22}]";
        JSONArray jsonArray = new JSONArray(jsonData);
        assertEquals("string1b", JSONDemo.getKeyOneOfSecond(jsonArray));
    }
}
