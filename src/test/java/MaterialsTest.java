import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MaterialsTest {

    @Test
    void getInstance() {

        assertNotNull(Materials.getInstance());
    }

    @Test
    void setCreditValueToMaterial() {

        Materials.getInstance().setCreditValueToMaterial(MaterialType.Silver, 5);
        assertEquals(Materials.getInstance().getCreditValueForMaterial(MaterialType.Silver), 5);
    }

    @Test
    void getCreditValueForMaterial() {
        assertEquals(Materials.getInstance().getCreditValueForMaterial(MaterialType.Dirt), 0);
    }

    @Test
    void setMaterialsFromCollection(){

        ArrayList<String>  galaticUnitData = new ArrayList<String>();
        galaticUnitData.add("glob is I");
        galaticUnitData.add("prok is V");
        galaticUnitData.add("pish is X");

        GalacticUnits.getInstance().setGalaticValues(galaticUnitData);

        ArrayList<String> testdata = new ArrayList<String>();
        testdata.add("glob glob Silver is 34 Credits");
        testdata.add("glob prok Gold is 57800 Credits");
        testdata.add("pish pish Iron is 3910 Credits");

        Materials.getInstance().setMaterialsFromCollection(testdata);

        assertEquals(Materials.getInstance().getCreditValueForMaterial(MaterialType.Silver), 17);
        assertEquals(Materials.getInstance().getCreditValueForMaterial(MaterialType.Gold), 14450);
        assertEquals(Materials.getInstance().getCreditValueForMaterial(MaterialType.Iron), 195);
        assertEquals(Materials.getInstance().getCreditValueForMaterial(MaterialType.Dirt), 0);

    }
}