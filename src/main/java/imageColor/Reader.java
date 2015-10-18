package imageColor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * La classe est Reader est dédié a lire le fichier donné à la construction et le stocker dans une matrice de couleur
 *
 * @author Mickael Loic
 * @version 1.0 
 */
public class Reader {

    /**
     * Le nom du fichier à lire
     *
     * @see Reader#Reader(String)
     * @see Reader#read()
     */
    private String filename;

    /**
     * Le constructeur du Reader
     * <p> 
     *     S'occupe d'initialiser le nom du fichier
     * </p>
     *
     * @param filename
     *              Le nom du fichier a lire
     *
     * @see Reader#filename
     */
    public Reader(String filename) {
        this.filename = filename;
    }
    
    /**
     * Lis le fichier instancié et créé une matrice de int contenant les valeurs lues.
     *
     *
     * @return Renvoie la matrice créé avec un tableau contenant 255, 255, 255 si la valeur lue est blanche et 0, 0, 0 si la valeur 
     *         est noir 
     *
     * @see Reader#filename
     *
     */
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

            while ((line = myBufferedReader.readLine()) != null) {
                for(char c : line.toCharArray()) {
                    if (c == '#') break;
                    else if (c == '1' || c == '0') {
                        int tmp = c - '0';
                        if(tmp == 1) {
                            matrix[heightTMP][widthTMP][0] = 0;
                            matrix[heightTMP][widthTMP][1] = 0;
                            matrix[heightTMP][widthTMP][2] = 0;
                        } else {
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

}
