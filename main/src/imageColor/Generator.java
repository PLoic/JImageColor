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

    public void generate(Integer widthPixel, Integer heightPixel){

        try {

            FileWriter fileWriter = new FileWriter(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("P1");
            bufferedWriter.newLine();

            bufferedWriter.write(widthPixel.toString() + " " + heightPixel.toString());
            bufferedWriter.newLine();

            for (int i = 0; i < heightPixel; ++i)
            {
                int count = 0;
                for (int j = 0; j < widthPixel; ++j)
                {
                    int randomNum = ThreadLocalRandom.current().nextInt(2);
                    bufferedWriter.write(new Integer(randomNum).toString());
                    count++;
                    if (count == 70)
                    {
                        bufferedWriter.newLine();
                    }
                }
            }

            bufferedWriter.close();
            fileWriter.close();




        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
