package imageColor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by loic on 08/10/15.
 */
public class Reader {

    private String filename;


    public Reader(String filename) {
        this.filename = filename;
    }

    public int[][][] read() {
        String line;

        int[][][] matrix = null;

        try {

            FileReader myFileReader = new FileReader(this.filename);
            BufferedReader myBufferedReader = new BufferedReader(myFileReader);

            line = myBufferedReader.readLine();

            if(!line.equals("P1")) throw new IOException("Error Format");

            Integer widthMatrix;
            Integer heightMatrix;

            line = myBufferedReader.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(line," ");

            widthMatrix = new Integer(stringTokenizer.nextToken());
            heightMatrix = new Integer(stringTokenizer.nextToken());

            matrix = new int[heightMatrix][widthMatrix][3];


            int widthTMP = 0;
            int heightTMP = 0;

            while ((line = myBufferedReader.readLine()) != null ){
                for(char c : line.toCharArray()){
                    if (c == '#') break;
                    else if (c == '1' || c == '0'){
                        int tmp = c - '0';
                        if(tmp == 1){
                            matrix[heightTMP][widthTMP][0] = 0;
                            matrix[heightTMP][widthTMP][1] = 0;
                            matrix[heightTMP][widthTMP][2] = 0;
                        }
                        else{
                            matrix[heightTMP][widthTMP][0] = 255;
                            matrix[heightTMP][widthTMP][1] = 255;
                            matrix[heightTMP][widthTMP][2] = 255;
                        }

                        if (widthTMP++ == (widthMatrix - 1)) {
                            widthTMP = 0;
                            ++heightTMP;
                        }
                    }
                }
            }

            myBufferedReader.close();
            myFileReader.close();


        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return matrix;
    }

    public static void main (String[] args) {
        Reader reader = new Reader("carte_france.pbm");
        int[][][] matrix = reader.read();
        for (final int[][] i : matrix) {
            for (final int[] j : i) {
                for(Integer k : j)
                    System.out.print(k);
            }
            System.out.println("");
        }
    } 

}
