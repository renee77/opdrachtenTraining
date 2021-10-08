import java.util.ArrayList;

public class Crypto {

	public static void main(String[] args) {
		String zin = "This is some \"really\" great. (Text)!?";
		System.out.println(zin);
		String encrypted = encryptString(zin, 2, 3);
		String decrypted = decrypt(encrypted, 2);
		
		System.out.println(encrypted);
		System.out.println(decrypted);
		
	}
	
	public static String ungroupify(String zin) {
		zin = zin.replace(" ", "");

		return zin;
	}
	
	public static String decrypt(String zin, int shiftValue) {
		zin = ungroupify(zin);
		ArrayList<Character> letters = new ArrayList();
		String decrypt = "";
		
		for (int i = 0; i < zin.length(); i++) {
			letters.add(zin.charAt(i));
		}
		
		for (int i = 0; i < letters.size(); i++) {
			Character letter = letters.get(i);
			// 65 van de waarde af omdat A begint op 65 maar we willen een waarde tussen de 0 en 26
			int valueLetter = letter - 65;
			// dit is een decrypt methode dus de key wordt er nu van afgetrokken
			valueLetter -= shiftValue;
			// nu de waarde delen door 26 daar blijft een modulus van over tussen de 0 en 25, 65 er bij geeft weer de range 65-90
			valueLetter = Math.abs(valueLetter % 26) + 65;
			
			// nu wordt de waarde weer een char
			letter = (char) valueLetter;
						
			decrypt = decrypt.concat(letter.toString());
//			letters.set(i, letter);			
		}
		
				
		
		return decrypt;
	}
	
//	Write a function called encryptString which takes three parameters: 
// a string to be encrypted, an integer shift value, and a code group size.  
// Your method should return a string which is its cyphertext equivalent. 
// Your function should do the following:
//
//	    Call normalizeText on the input string.
//	    Call obify to obfuscate the normalized text.
//	    Call caesarify to encrypt the obfuscated text.
//	    Call groupify to break the cyphertext into groups of size letters.
//	    Return the result

	public static String encryptString(String sentence, int shiftValue, int groupsize) {
		String codedSentence = groupify(caesarify(normalizeText(sentence), shiftValue), groupsize);
				
		return codedSentence;
	}
	
	
//	1. Removes all the spaces from your text
//	2. Remove any punctuation (. , : ; ’ ” ! ? ( ) )
//	3. Turn all lower-case letters into upper-case letters
//  4. returns the result
	public static String normalizeText(String s) {
		s = s.replaceAll("[.,:;'!?\"() \\s]", "").toUpperCase().strip();
		return s;
	}
	
//	The first argument is a string you want to encrypt, 
//	and the second is an integer that contains the shift value or "key". 
//	The function should return a string, which is the input string 
//    encrypted with the Caesar cypher using the shift value passed in its 
//    second argument. You may assume that the input string is normalized.
	
	public static String caesarify(String s, int key) {
		ArrayList<Character> al = new ArrayList<Character>();
		
		for (int i = 0; i < s.length(); i++) {
			al.add(s.charAt(i));
		}
		
		for (int i = 0; i < al.size(); i++) {
			int cijfer = (int) al.get(i);
			cijfer -= 65;
			cijfer += key;
			cijfer = Math.abs(cijfer % 26) +65;
			
			char letter = (char) cijfer;
			al.set(i, letter);			
		}
		
		String cryptoWoord = "";
		
		for (int i = 0; i < al.size(); i++) {
			cryptoWoord = cryptoWoord.concat(al.get(i).toString());
		}
			
		return cryptoWoord;
	}
	
	public static String shiftAlphabet(int shift) {
	    int start = 0;
	    if (shift < 0) {
	        start = (int) 'Z' + shift + 1;
	    } else {
	        start = 'A' + shift;
	    }
	    String result = "";
	    char currChar = (char) start;
	    for(; currChar <= 'Z'; ++currChar) {
	        result = result + currChar;
	    }
	    if(result.length() < 26) {
	        for(currChar = 'A'; result.length() < 26; ++currChar) {
	            result = result + currChar;
	        }
	    }
	    return result;
	}

//	Write a method called groupify which takes two parameters. 
//	The first parameter is the string that you want to break into groups. 
//	The second argument is the number of letters per group. The function will return a string, 
//	which consists of the input string broken into groups with the number of letters specified 
//	by the second argument. If there aren’t enough letters in the input string to fill out all the groups, 
//	you should “pad” the final group with x’s. 
//	So groupify(“HITHERE”, 2) would return “HI TH ER Ex”.


	
	public static String groupify(String sentence, int lettersPerGroup) {
		String output= "";
		for (int i = 0; i < sentence.length() - (lettersPerGroup - 1); i += lettersPerGroup){
			output = output + sentence.substring(i, i + lettersPerGroup) + " "; 			
			}
		
		if (sentence.length() % lettersPerGroup != 0) {
			output = output + sentence.substring(sentence.length() - (sentence.length() % lettersPerGroup));
			
			for (int i = 0; i < lettersPerGroup - (sentence.length() % lettersPerGroup); i++) {
				output = output + "X";
			}
		}
		return output;
	}
}
