package com.amigoscode;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String[] texts = {
                "Selam ben meltem.",
                "Bugün hava çok güzel.",
                "Java programlama dili kullanıyorum.",
                "Kodlama yapmayı seviyorum.",
                "Müzik dinlemek benim için çok keyifli."
        };

        String mergedText=mergeDuplicateTexts(texts);
        System.out.println("Merged Text: " + mergedText);
    }

    private static String mergeDuplicateTexts(String [] texts){
        Set<Character> uniqueCharacters=new HashSet<>();

        // Find text containing first repeated character
        String firstTextWithDuplicates=null;
        for(String text:texts){
            if(hasDuplicatesCharacter(text)){
                firstTextWithDuplicates=text;
                break;
            }
        }
        // Add unique characters to Set
        if(firstTextWithDuplicates!=null){
            for(char c:firstTextWithDuplicates.toCharArray()){
                uniqueCharacters.add(c);
            }
        }
        // Find text containing second repeated character
        String secondTextWithDuplicates=null;
        for(String text:texts){
            if(hasDuplicatesCharacter(text) && !text.equals(firstTextWithDuplicates)){
                secondTextWithDuplicates=text;
            }
        }

        // Add unique characters to Set
        if(secondTextWithDuplicates!=null){
            for(char c:secondTextWithDuplicates.toCharArray()){
                uniqueCharacters.add(c);
            }
        }

        StringBuilder mergedText=new StringBuilder();
        for(char c:uniqueCharacters){
            mergedText.append(c);
        }

        return mergedText.toString();
    }

    private static boolean hasDuplicatesCharacter(String text) {
        Set<Character> uniqueText=new HashSet<>();
        for(char c:text.toCharArray()){
            if(uniqueText.contains(c)){
                return true;
            }
            uniqueText.add(c);
        }
        return false;
    }
}

