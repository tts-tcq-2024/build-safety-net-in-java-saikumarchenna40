package CodeTestCoverJava;

import static org.junit.Assert.*;

import org.junit.Test;

public class SoundexTest {

  @Test
  public void testGenerateSoundexWithCommonNames() {
        assertEquals("C500", Soundex.generateSoundex("Chenna"));
        assertEquals("B200", Soundex.generateSoundex("Bosch"));
        assertEquals("P600", Soundex.generateSoundex("Priya"));
    }
	
    @Test
    public void testGenerateSoundexWithSpecialCharacters() {
        assertEquals("S500", Soundex.generateSoundex("Sne$@a"));
        assertEquals("G400", Soundex.generateSoundex("@Goo&le"));
    }

    @Test
   public void testGenerateSoundexWithEdgeCases() {
        assertEquals("Z000", Soundex.generateSoundex("Z"));
        assertEquals("A000", Soundex.generateSoundex("AEIOU"));
        assertEquals("L100", Soundex.generateSoundex("Love"));
    }

    @Test
    public void testGenerateSoundexWithLongNames() {
        assertEquals("C522", Soundex.generateSoundex("ChennaSaiKumar"));
    }
	
	@Test
    public void testGenerateSoundexWithNull() {
        assertEquals("", Soundex.generateSoundex(null));
    }

    @Test
    public void testGenerateSoundexWithEmptyString() {
        assertEquals("", Soundex.generateSoundex(""));
    }
}
