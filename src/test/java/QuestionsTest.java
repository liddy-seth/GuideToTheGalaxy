import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class QuestionsTest {

    @BeforeAll
    public static void setUp() {
        ArrayList<String> galaticUnitData = new ArrayList<String>();
        galaticUnitData.add("glob is I");
        galaticUnitData.add("prok is V");
        galaticUnitData.add("pish is X");
        galaticUnitData.add("tegj is L");
        GalacticUnits.getInstance().setGalaticValues(galaticUnitData);

        ArrayList<String> testData = new ArrayList<String>();
        testData.add("glob glob Silver is 34 Credits");
        testData.add("glob prok Gold is 57800 Credits");
        testData.add("pish pish Iron is 3910 Credits");
        Materials.getInstance().setMaterialsFromCollection(testData);

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void answerQuetions() {

        ArrayList<String> answers = new ArrayList<String>();

        ArrayList<String> questions = new ArrayList<String>();
        questions.add("how much is pish tegj glob glob");
        questions.add("how many Credits is glob prok Silver");
        questions.add("how many Credits is glob prok Gold");
        questions.add("how many Credits is glob prok Iron");
        questions.add("how much wood could a woodchuck chuck if a woodchuck could chuck wood?");

        answers = Questions.answerQuestions(questions);

        assertEquals(answers.get(0), "pish tegj glob glob is 42");
        assertEquals(answers.get(1) , "glob prok Silver is 68 Credits");
        assertEquals(answers.get(2) , "glob prok Gold is 57800 Credits");
        assertEquals(answers.get(3) , "glob prok Iron is 782 Credits");
        assertEquals(answers.get(4) , "I have no idea what you are talking about");











    }
}