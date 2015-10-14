package imageColor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by loic on 09/10/15.
 */
public class Writer {

    private int[][][] matrix;

    public Writer(int[][][] matrix) {
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

            bufferedWriter.write("255");
            bufferedWriter.newLine();

            for (int i = 0; i < matrix.length; ++i) {

                int count = 0;

                for (int j = 0; j < matrix[0].length; ++j) {

                    if (matrix[i][j][0] > 255 || matrix[i][j][0] < 0) throw new IOException("Bad format");

                    count = count + String.valueOf(matrix[i][j][0]).length() + String.valueOf(matrix[i][j][1]).toString().length() + String.valueOf(matrix[i][j][2]).toString().length() + 3;

                    bufferedWriter.write(matrix[i][j][0]+ " " + matrix[i][j][1]+ " " + matrix[i][j][2]+ " ");

                    if(count % 70 == 0) {
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
