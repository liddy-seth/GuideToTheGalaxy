import java.util.*;

//setting MaterialType so consumers are able to see what the list of materials is available
enum MaterialType {
    Dirt,
    Iron,
    Silver,
    Gold
}

class Materials {
    //public const String Dirt = "Dirt";
    // Is there a readonly concept in Java...only settable in constructor
    private static Materials materialsInstance = null;
    private HashMap<MaterialType, Double> materialsMap = new LinkedHashMap<>();
    private Materials(){
        materialsMap.put(MaterialType.Dirt, 0.0 );
        materialsMap.put(MaterialType.Iron, 0.0);
        materialsMap.put(MaterialType.Silver, 0.0);
        materialsMap.put(MaterialType.Gold, 0.0);
    }

    private double getRomanValueInStringArray(String[] splitStringBySpace){

        String romanNumber = new String();
        double romanValue = 0;
        int locationOfMatrialname = splitStringBySpace.length - 4;

        for (int counter = 0; counter < locationOfMatrialname ; counter ++){
            romanNumber += GalacticUnits.getRomanValueForGalactic(splitStringBySpace[counter]);
        }

        romanValue = MapRomanNumeralToInteger.romanToInteger(romanNumber);

        return romanValue;
    }


    public static Materials getInstance () {
        if (materialsInstance == null) {
            materialsInstance = new Materials();
        }
        return materialsInstance;
    }

    public void setCreditValueToMaterial(MaterialType materialtype, double creditValue) {
        materialsMap.replace(materialtype, creditValue);
    }

    public double getCreditValueForMaterial(MaterialType materialtype ) {

        return materialsMap.get(materialtype);
    }

    public void setMaterialsFromCollection(ArrayList<String> arrayOfMaterialWithValues){

        double credit = 0;
        double inputCredits = 0;
        double romanValue = 0;
        int lengthOfStringArray = arrayOfMaterialWithValues.toArray().length;
        String[] splitStringBySpace;

        for (int counterOfInput = 0; counterOfInput < lengthOfStringArray; counterOfInput++ ) {
            splitStringBySpace =  arrayOfMaterialWithValues.get(counterOfInput).split("\\s+");

            //assume for now credit value is always 2 word from last

            //  System.out.println("Credits in String" + Integer.parseInt(splitStringBySpace[splitStringBySpace.length - 1]));

            inputCredits = Integer.parseInt(splitStringBySpace[splitStringBySpace.length-2]);
            romanValue = materialsInstance.getRomanValueInStringArray(splitStringBySpace);
            credit = inputCredits / romanValue;

            //assuming for now that material is always 4 from last

            setCreditValueToMaterial( MaterialType.valueOf(splitStringBySpace[splitStringBySpace.length - 4]), credit);
        }
    }



}
