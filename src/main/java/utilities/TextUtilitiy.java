package utilities;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import responseComponents.TextLength;

public class TextUtilitiy {
	
	public static TextLength CountCharacters(String text) {
		char[] textAsCharArray = text.toCharArray();
		int withSpaces = textAsCharArray.length;
		int whiteSpaces = 0;
		for (char character : textAsCharArray ) {
			if (Character.isWhitespace(character)) {
				whiteSpaces ++;
			}
		}
		int withoutSpaces = withSpaces - whiteSpaces;
		TextLength textLength = new TextLength();
		textLength.setWithSpaces(withSpaces);
		textLength.setWithoutSpaces(withoutSpaces);
		return textLength;
	}
	
	public static int CountWords(String text) {
		if ( text == null || text.isEmpty()) {
			return 0;
		}
		int noOfWords = text.trim().split(" ").length;
		return  noOfWords;
	}
	
	public static ArrayList<Entry<Character, Integer>> CountCharacterOccurance(String text){
		char[] textAsCharArray = text.toLowerCase().toCharArray();
		Map<Character, Integer> characterCountMap = new TreeMap<Character, Integer>();
		for ( int asciiValue = 97 ; asciiValue <= 122; asciiValue ++  ) {
			int noOfOccurance = 0;
			char characterToFind = 0;
			for (char character : textAsCharArray ) {
				if ( asciiValue == (int)character ) {
					noOfOccurance ++;
					if ( characterToFind == 0 ) {
						characterToFind = character;
						characterCountMap.put(characterToFind, noOfOccurance);
					}
				}
			}
			
			if ( characterToFind != 0 ) {
				characterCountMap.replace(characterToFind, noOfOccurance);
			}
		}

		Set<Entry<Character, Integer>> entrySet = characterCountMap.entrySet();
		ArrayList<Entry<Character, Integer>> listOfEntry = new ArrayList<Entry<Character, Integer>>(entrySet);
		return listOfEntry;
	}

}
