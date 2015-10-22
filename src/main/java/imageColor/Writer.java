package imageColor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Writer est une classe dédié à l'écriture de la matrice dans un nouveau fichier PPM
 * 
 * @author Loic Mickael
 * @version 1.0
 */
public class Writer {

    /**
     * Matrice contenant les nouvelles couleurs
     *
     * @see Writer#Writer(int[][][])
     * @see Writer#writeMatrix(String)
     */
    private int[][][] matrix;

    /**
     * Le constructeur de writer instancie l'object avec la matrice lue et modifié par le Lecteur et le set
     *
     * @param matrix
     *      La matrice venant d'être lue
     *
     * @see Writer#matrix
     */
    public Writer(int[][][] matrix) {
        this.matrix = matrix;
    }

    /**
     * Ecris la matrice dans le fichier désiré
     *
     * @param filename
     *          Le fichier dans lequel écrire
     *
     * @see Writer#matrix
     *
     */
    public void writeMatrix(String filename){

        try {

            StringTokenizer stringTokenizer = new StringTokenizer(filename,".");
            stringTokenizer.nextToken();

            if (!stringTokenizer.nextToken().equals("ppm")) throw new IOException("Bad Writer filename");

            FileWriter fileWriter = new FileWriter(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("P3");
            bufferedWriter.newLine();

            bufferedWriter.write(matrix[0].length + " " + matrix.length);
            bufferedWriter.newLine();

            bufferedWriter.write("255");
            bufferedWriter.newLine();

            int count = 0;
            for (int i = 0; i < matrix.length; ++i) {

                for (int j = 0; j < matrix[0].length; ++j) {

                    if (matrix[i][j][0] > 255 || matrix[i][j][0] < 0 &&
                        matrix[i][j][1] > 255 || matrix[i][j][1] < 0 &&
                        matrix[i][j][2] > 255 || matrix[i][j][2] < 0    ){
                        throw new IOException("Bad format");
                    }

                    int currentSize = String.valueOf(matrix[i][j][0]).length() + String.valueOf(matrix[i][j][1]).toString().length() + String.valueOf(matrix[i][j][2]).toString().length() + 3;

                    if (count + currentSize > 70) {

                        count = currentSize;
                        bufferedWriter.newLine();
                        bufferedWriter.write(matrix[i][j][0] + " " + matrix[i][j][1] + " " + matrix[i][j][2] + " ");

                    } else {

                        count += currentSize;
                        bufferedWriter.write(matrix[i][j][0] + " " + matrix[i][j][1] + " " + matrix[i][j][2] + " ");

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
