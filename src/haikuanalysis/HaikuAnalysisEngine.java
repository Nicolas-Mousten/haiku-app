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
            String word = "";
            for (int j = 0; j < line1[i].length(); j++) {
                if(!String.valueOf(line1[i].charAt(j)).equalsIgnoreCase(".") && !String.valueOf(line1[i].charAt(j)).equalsIgnoreCase("!")&& !String.valueOf(line1[i].charAt(j)).equalsIgnoreCase(",")){
                    word += String.valueOf(line1[i].charAt(j));
                }
            }
            wordArray.add(word);
        }
        for (int i = 0; i < line2.length; i++) {
            String word = "";
            for (int j = 0; j < line2[i].length(); j++) {
                if(!String.valueOf(line2[i].charAt(j)).equalsIgnoreCase(".") && !String.valueOf(line2[i].charAt(j)).equalsIgnoreCase("!")&& !String.valueOf(line2[i].charAt(j)).equalsIgnoreCase(",")){
                    word += String.valueOf(line2[i].charAt(j));
                }
            }
            wordArray.add(word);
        }
        for (int i = 0; i < line3.length; i++) {
            String word = "";
            for (int j = 0; j < line3[i].length(); j++) {
                if(!String.valueOf(line3[i].charAt(j)).equalsIgnoreCase(".") && !String.valueOf(line3[i].charAt(j)).equalsIgnoreCase("!")&& !String.valueOf(line3[i].charAt(j)).equalsIgnoreCase(",")){
                    word += String.valueOf(line3[i].charAt(j));
                }
            }
            wordArray.add(word);
        }
        return wordArray;
    }
    public int syllablesCounter(ArrayList<String> words){
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
            //---------------------------------Code Above to find 1 vokal words---------------------------------
            if(vokalCount >1) {                 //The words with more than 2 vokals is specifyed here:
                for (int j = 0; j < words.get(i).length(); j++) {
                    String character = String.valueOf(words.get(i).charAt(j));
                    if(!konsonants.contains(character)){
                        String vokalLetter = character;
                        int vokalLetterIndex = j;
                        try {
                            int konOneIndex = vokalLetterIndex+1;
                            int konTwoIndex = vokalLetterIndex+2;
                            String konOne =String.valueOf(words.get(i).charAt(konOneIndex));
                            String konTwo =String.valueOf(words.get(i).charAt(konTwoIndex));
                            if(!vokals.contains(konOne)){
                                syllables++;
                            }else if(!vokals.contains(konTwo)){
                                syllables++;
                            }else{

                            }
                        }catch (StringIndexOutOfBoundsException e){

                        }
                    }

                }
            }


            //----------------------------Code Above to find how many syllables in multi vokal words.
            else if(vokalCount<=1){
                syllables++;
            }
        }
        return syllables;
    }
}


