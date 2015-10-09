import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

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

            Integer returnLine = 0;
            boolean jumpLine = false;

            if( widthPixel > 70) jumpLine = true;

            Random randomGenerator = new Random();

            for (int i = 0; i < heightPixel; ++i)
            {

                for (int j = 0; j < widthPixel; ++j)
                {
                    Integer randomPixel = randomGenerator.nextInt(100);
                    bufferedWriter.write(randomPixel.toString());
                    if (++returnLine % 70 == 0)
                    {
                        bufferedWriter.newLine();
                    }
                }
                if (jumpLine)
                {
                    bufferedWriter.newLine();
                }
            }

            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();




        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
