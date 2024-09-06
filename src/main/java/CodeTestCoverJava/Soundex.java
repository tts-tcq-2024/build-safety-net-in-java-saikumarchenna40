package CodeTestCoverJava;

import java.util.*;

public class Soundex {
	
	static Map<Character, Character> soundexCodes = new HashMap<>();
	static List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o','u');

	private static void initSoundexCodes() {
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
        initSoundexCodes();
        StringBuilder soundex = new StringBuilder();
        name = name.replaceAll("[^a-zA-Z0-9]", "");
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
		 for (int i = 1; i < name.length() && soundex.length() < 4; i++) {
		     // [a,e,i,o,u]
			char currentChar = name.charAt(i);
			char currentCode = getSoundexCode(currentChar);
			prevCode = updateSoundex(soundex, currentCode, prevCode, checkVowels(name, i));
		 }
	}
	
	private static boolean checkVowels(String name, int index) {
	    if (index > 1) {
	        char firstChar = Character.toLowerCase(name.charAt(index-1));
	        char secondChar = Character.toLowerCase(name.charAt(index-2));
	        return vowels.contains(firstChar) && vowels.contains(secondChar);
	    }
	    return false;
	}

    private static char updateSoundex(StringBuilder soundex, char currentCode, char prevCode, boolean isVowels) {
		// Append the code only if it differs from the previous code and is not '0'
			if (currentCode != '0' && currentCode != prevCode || isVowels) {
				soundex.append(currentCode);
				prevCode = currentCode;
			}
			return prevCode;
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
