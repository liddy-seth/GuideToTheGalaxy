
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Debated about using Enum class but instead
 */
public class MapRomanNumeralToInteger {

    public static final int romanToInteger(String romanStringInput) {

        Map<Character, Integer> values = new LinkedHashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        int number = 0;

        if (isValidRomanString(romanStringInput)) {
            for (int i = 0; i < romanStringInput.length(); i++) {
                if (i + 1 == romanStringInput.length() || values.get(romanStringInput.charAt(i)) >= values.get(romanStringInput.charAt(i + 1))) {
                    number += values.get(romanStringInput.charAt(i));
                } else {
                    number -= values.get(romanStringInput.charAt(i));
                }
            }
        }
        return number;
    }

    private static boolean isValidRomanString (String stringToValidate) {

        //My regex is off below.... let me know what I missed
        Pattern patternCheckingRepeatOfFourCharactersInARow = Pattern.compile ("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
        //Pattern patternCheckingRepeatOfFourCharactersInARow = Pattern.compile ("(.)\1{3,3}$");
        Matcher matcher = patternCheckingRepeatOfFourCharactersInARow.matcher(stringToValidate);

        return matcher.find();
    }
}
