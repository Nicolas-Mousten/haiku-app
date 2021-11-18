package data;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HaikuWriter {
    public void writer(ArrayList<String> poem, String user) {
        File file = new File("Resources/Poem.txt");
        int linesCount = 0;
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                linesCount++;
                sc.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        //----------------------------------------------------------
        try (FileWriter fw = new FileWriter("Resources/Poem.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(linesCount + "    " + user + "    " + poem);
        } catch (IOException e) {
        }
    }
}
