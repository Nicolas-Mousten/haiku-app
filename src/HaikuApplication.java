import haikuanalysis.HaikuAnalysisEngine;
import haikuanalysis.HaikuPoem;
import ui.MainMenu;

import java.util.ArrayList;

public class HaikuApplication {
    private MainMenu menu = new MainMenu();
    private HaikuAnalysisEngine haikuAnalysisEngine= new HaikuAnalysisEngine();

    public static void main(String[] args) {
        ArrayList<Integer> indexOfVokals = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        HaikuApplication app = new HaikuApplication();
        HaikuPoem poem = new HaikuPoem("An old silent pond...","A frog jumps into the pond,","splash! Silence again.");
        String haikuString;
        int amountOfSyllables;
        app.menu.welcomeUser();

        haikuString = app.haikuAnalysisEngine.haikuToString(poem);
        indexOfVokals = app.haikuAnalysisEngine.indexOfVokals(haikuString);
        words = app.haikuAnalysisEngine.haikuSplitter(poem);
        amountOfSyllables = app.haikuAnalysisEngine.syllablesCounter(words,indexOfVokals);

        System.out.println(words);
        System.out.println(indexOfVokals);
        System.out.println(amountOfSyllables);
    }
}
