import org.junit.jupiter.api.Test;

import java.io.IOException;

class ProcessTest {


    @Test
    void convertToStringArray() throws IOException {

        new Process().parseFile(getClass().getResource("testInputFile.txt").getPath(), "c://TestFile.txt");



    }

    @Test
    void mapGalacticUnitsToRoman() throws IOException {
        //String[] stringArrayFromInput = ProcessInputFile.convertFileToStringArrayInputFile(getClass().getResource("testInputFile.txt").getPath().toString());
    }

}