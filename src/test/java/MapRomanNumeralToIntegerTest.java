import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapRomanNumeralToIntegerTest {

    @Test
    void romanToInteger() {

        assertEquals(MapRomanNumeralToInteger.romanToInteger("I"), 1);
        assertEquals(MapRomanNumeralToInteger.romanToInteger("V"), 5);
        assertEquals(MapRomanNumeralToInteger.romanToInteger("X"), 10);
        assertEquals(MapRomanNumeralToInteger.romanToInteger("C"), 100);
        assertEquals(MapRomanNumeralToInteger.romanToInteger("D"), 500);
        assertEquals(MapRomanNumeralToInteger.romanToInteger("M"), 1000);

        assertEquals(MapRomanNumeralToInteger.romanToInteger("MM"), 2000);
        assertEquals(MapRomanNumeralToInteger.romanToInteger("MCMIII"), 1903);
        assertEquals(MapRomanNumeralToInteger.romanToInteger("MCMXLIV"), 1944);
        assertEquals(MapRomanNumeralToInteger.romanToInteger("MMVI"), 2006);
        assertEquals(MapRomanNumeralToInteger.romanToInteger("XXXIX"), 39);

        assertEquals(MapRomanNumeralToInteger.romanToInteger("XXXX"), 0);


    }

}