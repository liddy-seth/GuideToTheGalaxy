import java.util.*;

public class Questions {


    public static ArrayList<String> answerQuestions (List<String> stringListFromInput){
        // setting variables to make a bit easier to read.
        int numberOfQuestions = stringListFromInput.toArray().length;
        String tempString;
        int romanNumberal;
        MaterialType tempMaterial;
        double totalCreditValue = 0;
        ArrayList<String> answers = new ArrayList<String>();

        for (int counterOfInput = 0; counterOfInput < numberOfQuestions; counterOfInput++ ) {

            tempString = stringListFromInput.get(counterOfInput);

            if (stringListFromInput.get(counterOfInput).matches("how much is(.*)")){
                //assume question is around galatic to roman
                // additional checks to be added later to ensure galatic values is within the known list
                tempString = tempString.substring(12);
                romanNumberal = GalacticUnits.getInstance().getRomanValuesFromGalacitsUnitsString(tempString);
                if(romanNumberal == 0 ){
                    answers.add(tempString + " is an invalid number");
                }
                else {
                    answers.add(tempString + " is " + romanNumberal);
                }

            } else if (stringListFromInput.get(counterOfInput).matches("how many Credits is (.*)")) {
                //assume question is around credits for Material
                tempString = tempString.substring(20);

                tempMaterial = MaterialType.valueOf(stringListFromInput.get(counterOfInput).replaceAll("^.*?(\\w+)\\W*$", "$1"));
                tempString = tempString.replaceAll(" " + tempMaterial.toString() + " *?","");
                totalCreditValue = GalacticUnits.getRomanValuesFromGalacitsUnitsString(tempString) * Materials.getInstance().getCreditValueForMaterial(tempMaterial);
                answers.add(tempString + " " + tempMaterial.toString() + " is " + (int)totalCreditValue +" Credits");
            }else{
                //unclear the question
                answers.add("I have no idea what you are talking about");
            }

        }
        return answers;
    }


}
