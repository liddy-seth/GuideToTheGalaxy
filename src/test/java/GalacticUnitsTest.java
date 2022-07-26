import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GalacticUnitsTest {

    @Test
    void getInstance() {

        assertNotNull(GalacticUnits.getInstance());
    }


    @Test
    void setGalaticValues(){

        System.out.println("Units are currently at: " + GalacticUnits.galacticUnitsMap.size());
        ArrayList<String> testdata = new ArrayList<String>();
        testdata.add("glob is I");
        testdata.add("prok is V");
        testdata.add("pish is X");
        testdata.add("tegi is L");

        GalacticUnits.setGalaticValues(testdata);

        assertEquals(5, GalacticUnits.galacticUnitsMap.size());

    }

}