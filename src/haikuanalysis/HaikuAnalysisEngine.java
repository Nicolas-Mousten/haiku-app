package haikuanalysis;

import java.util.ArrayList;
import java.util.Arrays;

public class HaikuAnalysisEngine {
    private static String vokals = "aeiouyæøå";
    private static String konsonants = "bcdfghjklmnpqrstvwxz";

    public String haikuToString(HaikuPoem words) {
        String haikuString = "";
        haikuString += words.getFirstLine() +" ";
        haikuString += words.getSecondLine()+" ";
        haikuString += words.getThirdLine();
        return haikuString;
    }
    public ArrayList<Integer> indexOfVokals(String words){
        ArrayList<Integer> indexOfVokals = new ArrayList<>();
        for (int i = 0; i < words.length(); i++) {
            for (int j = 0; j < vokals.length(); j++) {
                String character = String.valueOf(words.charAt(i));
                String vokal = String.valueOf(vokals.charAt(j));
                if(character.equalsIgnoreCase(vokal)){
                    indexOfVokals.add(i);
                }
            }
        }
        return indexOfVokals;
    }

    public ArrayList<String> haikuSplitter(HaikuPoem words){
        String[] line1 = words.getFirstLine().split(" ");
        String[] line2 = words.getSecondLine().split(" ");
        String[] line3 = words.getThirdLine().split(" ");
        ArrayList<String> wordArray = new ArrayList<>();
        for (int i = 0; i < line1.length; i++) {
            wordArray.add(line1[i]);
        }
        for (int i = 0; i < line2.length; i++) {
            wordArray.add(line2[i]);
        }
        for (int i = 0; i < line3.length; i++) {
            wordArray.add(line3[i]);
        }
        return wordArray;
    }
    public int syllablesCounter(ArrayList<String> words,ArrayList<Integer>indexOfVokals){
        int syllables = 0;
        for (int i = 0; i < words.size(); i++) {            //Looks at one words at the time
            int vokalCount = 0;

            for (int j = 0; j < words.get(i).length(); j++) {               //Looks at the character in the word

                for (int k = 0; k < vokals.length(); k++) {                         //compares the character with the vokals
                    String character = String.valueOf(words.get(i).charAt(j));
                    String vokal = String.valueOf(vokals.charAt(k));

                    if(character.equalsIgnoreCase(vokal)){
                        vokalCount++;
                    }
                }
            }
            if(vokalCount >1) {                 //The words with more than 2 vokals is specifyed here:
                System.out.println(words.get(i));


            }else if(vokalCount<=1){
                syllables++;
            }
        }
        return syllables;
    }
}