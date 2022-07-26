import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.function.DoubleToIntFunction;

public class GalacticUnits {

    private static GalacticUnits galacticUnitsInstance = null;
    public static HashMap<String, String> galacticUnitsMap = new LinkedHashMap<>();

    public GalacticUnits(){
        galacticUnitsMap.put("Unknown", "?");
    }

    public static GalacticUnits getInstance() {
        if (galacticUnitsInstance == null) {
            galacticUnitsInstance = new GalacticUnits();
        }
        return galacticUnitsInstance;
    }

    public void setGalacticValueToRomanNumeral(String galacticlName, String romanNumeral) {
        galacticUnitsMap.putIfAbsent(galacticlName, romanNumeral);
    }

    public static String getRomanValueForGalactic(String galacticlName) {
        return galacticUnitsMap.getOrDefault(galacticlName,galacticUnitsMap.get("Unknown"));
    }

    public static void setGalaticValues (ArrayList<String> stringArrayFromInput){
        // setting variables to make a bit easier to read.
        String galacitcSymbol = new String();
        String romanSymbol = new String();
        int lengthOfStringArray = stringArrayFromInput.toArray().length;
        String[] splitString;

        for (int counterOfInput = 0; counterOfInput < lengthOfStringArray; counterOfInput++ ) {

            splitString = stringArrayFromInput.get(counterOfInput).split("\\s+");
            /*
            Making some assumptions that these three words are valid is 3 words long but should error check.
             */
            galacitcSymbol = splitString[0].toString();
            romanSymbol = splitString[2].toString();
            galacticUnitsInstance.setGalacticValueToRomanNumeral(galacitcSymbol, romanSymbol);
        }
    }


    public static int getRomanValuesFromGalacitsUnitsString(String galaticUnitsString){
        String romanString = new String();
        String[] convertedString = galaticUnitsString.split("\\s+");

        for (int counterofUnits = 0; counterofUnits < convertedString.length; counterofUnits++) {
            romanString = romanString + getRomanValueForGalactic(convertedString[counterofUnits]);
        }
// need to put in some logic to catch bad data error
        return MapRomanNumeralToInteger.romanToInteger(romanString);

    }


}
