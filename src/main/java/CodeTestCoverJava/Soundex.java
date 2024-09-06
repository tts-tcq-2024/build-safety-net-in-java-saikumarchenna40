package CodeTestCoverJava;

import java.util.*;

public class Soundex {
	
	static Map<Character, Character> soundexCodes = new HashMap<>();
	
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
		appendInitialCharacter(soundex, name);
        processRemainingCharacters(soundex, name);
		checkAndAddPadding(soundex);

        return soundex.toString();
    }
	
	// Handles appending the first character of the name
	private static void appendInitialCharacter(StringBuilder soundex, String name) {
		char firstChar = name.charAt(0);
		soundex.append(Character.toUpperCase(firstChar));
	}
	
	// Processes and appends the remaining characters based on Soundex encoding
	private static void processRemainingCharacters(StringBuilder soundex, String name) {
		char prevCode = getSoundexCode(name.charAt(0));
		char currentCode = getSoundexCode(currentChar);

		updateSoundex(soundex, currentCode, prevCode);
	}

    private static void updateSoundex(StringBuilder soundex, char currentChar, char prevCode) {
		// Append the code only if it differs from the previous code and is not '0'
			if (currentCode != '0' && currentCode != prevCode) {
				soundex.append(currentCode);
				prevCode = currentCode;
			}
	}
	
	private static void checkAndAddPadding(StringBuilder soundex) {
		while (soundex.length() < 4) {
            soundex.append('0');
        }
	}
	
    private static char getSoundexCode(char c) {
        c = Character.toUpperCase(c);
        return soundexCodes.getOrDefault(c, '0');
    }
}
