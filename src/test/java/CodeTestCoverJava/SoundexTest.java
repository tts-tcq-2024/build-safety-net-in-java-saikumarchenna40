package CodeTestCoverJava;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SoundexTest {

  @Test
    void testGenerateSoundexWithCommonNames() {
        assertEquals("C500", Soundex.generateSoundex("Chenna"), "Soundex for 'Chenna' should be 'C500'");
        assertEquals("B200", Soundex.generateSoundex("Bosch"), "Soundex for 'Bosch' should be 'B200'");
        assertEquals("P600", Soundex.generateSoundex("Priya"), "Soundex for 'Priya' should be 'P600'");
    }
	
	@Test
    void testGenerateSoundexWithSpecialCharacters() {
        assertEquals("S500", Soundex.generateSoundex("Sne$@a"), "Soundex for 'Sne$@a' should be 'S500'");
        assertEquals("G400", Soundex.generateSoundex("@Goo&le"), "Soundex for '@Goo&le' should be 'G400'");
    }

    @Test
    void testGenerateSoundexWithEdgeCases() {
        assertEquals("Z000", Soundex.generateSoundex("Z"), "Soundex for single character 'Z' should be 'Z000'");
        assertEquals("A000", Soundex.generateSoundex("AEIOU"), "Soundex for 'AEIOU' should be 'A000'");
        assertEquals("L100", Soundex.generateSoundex("Love"), "Soundex for 'Love' should be 'L100'");
    }

    @Test
    void testGenerateSoundexWithLongNames() {
        assertEquals("C522", Soundex.generateSoundex("ChennaSaiKumar"), "Soundex for 'ChennaSaiKumar' should be 'C522'");
    }
	
	@Test
    void testGenerateSoundexWithNull() {
        assertEquals("", Soundex.generateSoundex(null), "Soundex for null should be an empty string");
    }

    @Test
    void testGenerateSoundexWithEmptyString() {
        assertEquals("", Soundex.generateSoundex(""), "Soundex for an empty string should be an empty string");
    }
}
