import data.HaikuWriter;
import haikuanalysis.HaikuAnalysisEngine;
import haikuanalysis.HaikuPoem;
import ui.MainMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class HaikuApplication {
    private MainMenu menu = new MainMenu();
    private HaikuAnalysisEngine haikuAnalysisEngine= new HaikuAnalysisEngine();

    public static void main(String[] args) {
        ArrayList<Integer> indexOfVokals = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        HaikuApplication app = new HaikuApplication();
        HaikuWriter writer = new HaikuWriter();
        HaikuPoem poem = new HaikuPoem("An old silent pond...","A frog jumps into the pond,","splash! Silence again.");
        String haikuString;
        int amountOfSyllables;
        app.menu.welcomeUser();

        haikuString = app.haikuAnalysisEngine.haikuToString(poem);
        words = app.haikuAnalysisEngine.haikuSplitter(poem);
        amountOfSyllables = app.haikuAnalysisEngine.syllablesCounter(words);

        System.out.println(words);
        System.out.println(amountOfSyllables);
        if(amountOfSyllables == 17){
            Scanner sc = new Scanner(System.in);
            System.out.println("Write your name:");
            String name = sc.nextLine();
            writer.writer(words,name);
        }
    }
}