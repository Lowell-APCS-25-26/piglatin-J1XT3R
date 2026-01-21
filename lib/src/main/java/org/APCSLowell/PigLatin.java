package org.APCSLowell;

public class PigLatin {
    public int findFirstVowel(String sWord) {
        //precondition: sWord is a valid String of length greater than 0.
        //postcondition: returns the position of the first vowel in sWord.  If there are no vowels, returns -1
	    String vowels = "AEIOUaeiou";

        for (int i = 0; i < sWord.length(); i++) {
            if (vowels.indexOf(sWord.charAt(i)) != -1) {
                return i;
            }

            if (i > 0 && (sWord.charAt(i) == 'y' || sWord.charAt(i) == 'Y')) {
                return i;
            }
        }

        return -1;
    }

    public String pigLatin(String sWord) {
        //precondition: sWord is a valid String of length greater than 0
        //postcondition: returns the pig latin equivalent of sWord
        int firstVowel = findFirstVowel(sWord);
        
        if (firstVowel == 0) {
            return sWord + "way";
        }
        
        if (sWord.length() > 1 && sWord.substring(0, 2).toLowerCase().equals("qu")) {
            return sWord.substring(2) + sWord.substring(0, 2) + "ay";
        }
        
        if (firstVowel != -1) {
            boolean hasRealVowel = false;
            String realVowels = "AEIOUaeiou";
            for (int i = 0; i < sWord.length(); i++) {
                if (realVowels.indexOf(sWord.charAt(i)) != -1) {
                    hasRealVowel = true;
                    break;
                }
            }

            if (!hasRealVowel && (sWord.charAt(firstVowel) == 'y' || sWord.charAt(firstVowel) == 'Y')) {
                return sWord + "ay";
            }
        }
        
        if (firstVowel == -1) {
            return sWord + "ay";
        }
        
        return sWord.substring(firstVowel) + sWord.substring(0, firstVowel) + "ay";
    }
}
