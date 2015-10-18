package imageColor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by loic on 09/10/15.
 */
public class Generator {

    String filename;

    public Generator(String filename) {
        this.filename = filename;
    }

    public void generate(Integer heightPixel, Integer widthPixel){

        try {

            FileWriter fileWriter = new FileWriter(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("P1");
            bufferedWriter.newLine();

            bufferedWriter.write(widthPixel.toString() + " " + heightPixel.toString());
            bufferedWriter.newLine();

            int returnLine = 0;
            boolean jumpLine = false;
            if (widthPixel < 70) {
                jumpLine = true;
            }

            for (int i = 0; i < heightPixel; ++i) {
                for (int j = 0; j < widthPixel; ++j) {
                    int randomNum = ThreadLocalRandom.current().nextInt(2);
                    bufferedWriter.write(new Integer(randomNum).toString());
                    if (((++returnLine % 70) == 0) && !jumpLine) {
                        bufferedWriter.newLine();
                    }
                }
                if (jumpLine) {
                    bufferedWriter.newLine();
                }
            }

            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main (String[] args) {
        Generator generate = new Generator(args[0]);
        generate.generate(Integer.valueOf(args[2]), Integer.valueOf(args[3]));
        Coloring coloring = new Coloring();
        coloring.coloring(args[0], args[1]);
        
    }
}
