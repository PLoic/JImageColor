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

    public Integer[][] read() {
        String line;

        Integer[][] matrix = null;

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

            matrix = new Integer[heightMatrix][widthMatrix];


            int widthTMP = 0;
            int heightTMP = 0;

            while ((line = myBufferedReader.readLine()) != null ){
                for(char c : line.toCharArray()){
                    if (c == '#') break;
                    else if (c == '1' || c == '0'){
                        matrix[heightTMP][widthTMP] = c - '0';
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
        Reader reader = new Reader("/home/micka/Bureau/test.pbm");
        Integer[][] matrix = reader.read();
        for (final Integer[] i : matrix) {
            for (final Integer j : i) {
                System.out.print(j);
            }
            System.out.println("");
        }
    } 

}
