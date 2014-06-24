package Kaws;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
 

public class FileWriter {
 
    /**
     * @param string the command line arguments
     */
    public FileWriter(String string) throws IOException {
       FileOutputStream out = null;
       out = new FileOutputStream("Res/Score.txt");
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       System.out.println("Enter text:");
       while (true){
               char str = (char) in.read();
               out.write(str);
              
        }
    }
 
}