import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Process {
    private ArrayList<String> rawQuestions = new ArrayList<String>();
    private ArrayList<String> rawMaterials = new ArrayList<String>();
    private ArrayList<String> rawUnits = new ArrayList<String>();

    private void populateCollections(List<String> linesOfText){

        for (String line : linesOfText) {
            //setting boolean based on key words found in the lines
            boolean containIs = line.contains("is");
            boolean containsHow = line.contains("how");
            boolean containCredit = line.contains("Credits");

            if (containIs && containCredit) {
                // Set the Materials credit value
                rawMaterials.add(line);
            } else if (containIs && !containsHow) {
                // Map the Roman Numeral to Credit
                rawUnits.add(line);
            } else {
                //assuming rest are questions as there are only 3 types of lines available for now
                rawQuestions.add(line);
            }

        }
    }

    public void parseFile(String inputFile, String outputFile ) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(inputFile));

        populateCollections(lines);

        GalacticUnits.setGalaticValues(rawUnits);
        Materials.getInstance().setMaterialsFromCollection(rawUnits);
        Questions.answerQuestions(rawQuestions);

        ReadWriteFileHelper.writeAnsersToOutFile(Questions.answerQuestions(rawQuestions), outputFile );
    }

}

