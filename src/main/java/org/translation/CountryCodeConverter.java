package org.translation;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class provides the service of converting country codes to their names.
 */
public class CountryCodeConverter {

    private static final Map<String, String> CODE_TO_COUNTRY_MAP = new HashMap<>();
    private static final Map<String, String> COUNTRY_TO_CODE_MAP = new HashMap<>();

    /**
     * Default constructor which will load the country codes from "country-codes.txt"
     * in the resources folder.
     */
    public CountryCodeConverter() {
        this("country-codes.txt");
    }

    /**
     * Overloaded constructor which allows us to specify the filename to load the country code data from.
     * @param filename the name of the file in the resources folder to load the data from
     * @throws RuntimeException if the resource file can't be loaded properly
     */
    public CountryCodeConverter(String filename) {

        try {
            List<String> lines = Files.readAllLines(Paths.get(getClass()
                    .getClassLoader().getResource(filename).toURI()));

            for (String line:lines) {
                if (line.startsWith("Country")) {
                    continue;
                }

                String[] parts = line.split("\t");
                String countryName = parts[0];
                String alpha3Code = parts[2].toLowerCase();

                CODE_TO_COUNTRY_MAP.put(alpha3Code, countryName);
                COUNTRY_TO_CODE_MAP.put(countryName, alpha3Code);
            }

        }
        catch (IOException | URISyntaxException ex) {
            throw new RuntimeException(ex);
        }

    }

    /**
     * Returns the name of the country for the given country code.
     * @param code the 3-letter code of the country
     * @return the name of the country corresponding to the code
     */
    public static String fromCountryCode(String code) {
        return CODE_TO_COUNTRY_MAP.get(code);
    }

    /**
     * Returns the code of the country for the given country name.
     * @param country the name of the country
     * @return the 3-letter code of the country
     */
    public static String fromCountry(String country) {
        return COUNTRY_TO_CODE_MAP.get(country);
    }


    /**
     * Returns how many countries are included in this code converter.
     * @return how many countries are included in this code converter.
     */
    public int getNumCountries() {
        return CODE_TO_COUNTRY_MAP.size();
    }
}
