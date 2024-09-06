package CodeTestCoverJava;

import java.util.*;

public class Soundex {
	
	Map<Character, Character> soundexCodes = new HashMap<>();
	
	public Soundex() {
		initSoundexCodes();
	}

	private void initSoundexCodes() {
		soundexCodes.put('B', '1');
		soundexCodes.put('F', '1');
		soundexCodes.put('P', '1');
		soundexCodes.put('V', '1');
		soundexCodes.put('C', '2');
		soundexCodes.put('G', '2');
		soundexCodes.put('J', '2');
		soundexCodes.put('K', '2');
		soundexCodes.put('Q', '2');
		soundexCodes.put('S', '2');
		soundexCodes.put('X', '2');
		soundexCodes.put('Z', '2');
		soundexCodes.put('D', '3');
		soundexCodes.put('T', '3');
		soundexCodes.put('L', '4');
		soundexCodes.put('M', '5');
		soundexCodes.put('N', '5');
		soundexCodes.put('R', '6');
	}
	
    public static String generateSoundex(String name) {
        if (name == null || name.isEmpty()) {
            return "";
        }

        StringBuilder soundex = new StringBuilder();
        updateSoundex(soundex);

        return soundex.toString();
    }
	
	private void updateSoundex(StringBuilder soundex) {
		
		soundex.append(Character.toUpperCase(name.charAt(0)));
        char prevCode = getSoundexCode(name.charAt(0));

        for (int i = 1; i < name.length() && soundex.length() < 4; i++) {
            char code = getSoundexCode(name.charAt(i));
            if (code != '0' && code != prevCode) {
                soundex.append(code);
                prevCode = code;
            }
        }

        while (soundex.length() < 4) {
            soundex.append('0');
        }
		
	}

    private static char getSoundexCode(char c) {
        c = Character.toUpperCase(c);
        return soundexCodes.getOrDefault(c, '0');
    }
}
