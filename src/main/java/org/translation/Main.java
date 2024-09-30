package org.translation;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Main class for this program.
 * Complete the code according to the "to do" notes.<br/>
 * The system will:<br/>
 * - prompt the user to pick a country name from a list<br/>
 * - prompt the user to pick the language they want it translated to from a list<br/>
 * - output the translation<br/>
 * - at any time, the user can type quit to quit the program<br/>
 */
public class Main {

    private static final String QUIT_COMMAND = "quit";

    /**
     * This is the main entry point of our Translation System!<br/>
     * A class implementing the Translator interface is created and passed into a call to runProgram.
     * @param args not used by the program
     */
    public static void main(String[] args) {

        Translator translator = new JSONTranslator();

        runProgram(translator);
    }

    /**
     * This is the method which we will use to test your overall program, since
     * it allows us to pass in whatever translator object that we want!
     * See the class Javadoc for a summary of what the program will do.
     * @param translator the Translator implementation to use in the program
     */
    public static void runProgram(Translator translator) {
        while (true) {
            String country = promptForCountry(translator);
            if (QUIT_COMMAND.equals(country)) {
                break;
            }

            String countryCode = CountryCodeConverter.fromCountry(country);

            String language = promptForLanguage(translator, country);
            if (QUIT_COMMAND.equals(language)) {
                break;
            }

            String languageCode = LanguageCodeConverter.fromLanguage(language);

            System.out.println(country + " in " + language + " is " + translator.translate(country, language));
            System.out.println("Press enter to continue or quit to exit.");
            Scanner s = new Scanner(System.in);
            String textTyped = s.nextLine();

            if (QUIT_COMMAND.equals(textTyped)) {
                break;
            }
        }
    }

    private static String promptForCountry(Translator translator) {
        List<String> countries = translator.getCountries();

        for (int i = 0; i < countries.size(); i++) {
            countries.set(i, CountryCodeConverter.fromCountryCode(countries.get(i)));
        }

        Collections.sort(countries);

        for (String country : countries) {
            System.out.println(country);
        }

        System.out.println("select a country from above:");

        Scanner s = new Scanner(System.in);
        return s.nextLine();

    }

    private static String promptForLanguage(Translator translator, String country) {
        List<String> languages = translator.getCountryLanguages(country);

        for (int i = 0; i < languages.size(); i++) {
            languages.set(i, LanguageCodeConverter.fromLanguageCode(languages.get(i)));
        }

        Collections.sort(languages);

        for (String language : languages) {
            System.out.println(language);
        }

        System.out.println("Select a language from above:");

        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }
}
