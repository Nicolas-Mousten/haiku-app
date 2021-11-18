package data;

import java.io.*;
import java.util.ArrayList;

public class HaikuWriter {
    public void writer(ArrayList<String> poem,String user ){
        File file = new File("Resources/Poem.csv");





        //----------------------------------------------------------
        try(FileWriter fw = new FileWriter("Resources/Poem.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(poemID+";"+user+";"+poem);
        } catch (IOException e) {
        }
    }
}
