package imageColor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by loic on 09/10/15.
 */
public class Writer {

    private Integer[][] matrix;

    public Writer(Integer[][] matrix) {
        this.matrix = matrix;
    }

    public void writeMatrix(String filename){

        try {

            FileWriter fileWriter = new FileWriter(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("P3");
            bufferedWriter.newLine();

            bufferedWriter.write(matrix[0].length + " " + matrix.length);
            bufferedWriter.newLine();

            for (int i = 0; i < matrix.length; ++i){

                int count = 0;

                for (int j = 0; j < matrix[0].length; ++j){
                    count++;
                    if (matrix[i][j] > 255 || matrix[i][j] < 0) throw new IOException("Bad format");

                    bufferedWriter.write(matrix[i][j]);

                    if(count % 70 == 0){
                        bufferedWriter.newLine();
                    }
                }

                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
