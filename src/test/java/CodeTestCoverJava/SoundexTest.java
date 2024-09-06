package CodeTestCoverJava;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SoundexTest {

  @Test
    void testGenerateSoundexWithCommonNames() {
        assertEquals("C500", Soundex.generateSoundex("Chenna"));
        assertEquals("B200", Soundex.generateSoundex("Bosch"));
        assertEquals("P600", Soundex.generateSoundex("Priya"));
    }
	
	@Test
    void testGenerateSoundexWithSpecialCharacters() {
        assertEquals("S500", Soundex.generateSoundex("Sne$@a"));
        assertEquals("G400", Soundex.generateSoundex("@Goo&le"));
    }

    @Test
    void testGenerateSoundexWithEdgeCases() {
        assertEquals("Z000", Soundex.generateSoundex("Z"));
        assertEquals("A000", Soundex.generateSoundex("AEIOU"));
        assertEquals("L100", Soundex.generateSoundex("Love"));
    }

    @Test
    void testGenerateSoundexWithLongNames() {
        assertEquals("C522", Soundex.generateSoundex("ChennaSaiKumar"));
    }
	
	@Test
    void testGenerateSoundexWithNull() {
        assertEquals("", Soundex.generateSoundex(null));
    }

    @Test
    void testGenerateSoundexWithEmptyString() {
        assertEquals("", Soundex.generateSoundex(""));
    }
}
