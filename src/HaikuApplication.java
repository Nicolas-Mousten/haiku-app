import data.HaikuWriter;
import haikuanalysis.HaikuAnalysisEngine;
import haikuanalysis.HaikuPoem;
import ui.MainMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class HaikuApplication {
    private MainMenu menu = new MainMenu();
    private HaikuAnalysisEngine haikuAnalysisEngine = new HaikuAnalysisEngine();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> indexOfVokals = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        HaikuApplication app = new HaikuApplication();
        HaikuWriter writer = new HaikuWriter();


        int amountOfSyllables;
        app.menu.welcomeUser();
        System.out.print("Plz write first line:");
        String firstLine = sc.nextLine();
        System.out.print("\nPlz write second line:");
        String secondLine = sc.nextLine();
        System.out.print("\nPlz write third line:");
        String thirdLine = sc.nextLine();
        HaikuPoem poem = new HaikuPoem(firstLine, secondLine, thirdLine);

        words = app.haikuAnalysisEngine.haikuSplitter(poem);
        amountOfSyllables = app.haikuAnalysisEngine.syllablesCounter(words);

        System.out.println(words);
        System.out.println(amountOfSyllables);
        if (amountOfSyllables == 17) {

            System.out.println("Write your name:");
            String name = sc.nextLine();
            writer.writer(words, name);
        } else {
            System.out.println("Your poem only have " + amountOfSyllables + " syllables. To be approved for this database you need 17 syllables ");
        }
    }
}
//Test Poem:
//"An old silent pond...","A frog jumps into the pond,","splash! Silence again."