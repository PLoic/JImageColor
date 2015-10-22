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
        StringTokenizer stringTokenizer = new StringTokenizer(filename,".");
        stringTokenizer.nextToken();

        if(!stringTokenizer.nextToken().equals("pbm")) try {

            throw new IOException("Erreur nom de fichier");

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        this.filename = filename;
    }
    
    /**
     * Méthode privé pas dans la javadoc mais commenté pour relecture du développeur
     * Vérifie si une ligne est un commentaire 
     * 
     * @param line 
     *           Vérification de la ligne 
     * @return Renvoie vrai si la ligne est un commentaire faux sinon
     *
     * @see Reader#read()
     */
    private boolean lineIsComment(String line) {
        String tmp = line.replaceAll(" ", "");
        return (tmp.charAt(0) == '#');
    }
    
    /**
     * Méthode privé pas dans la javadoc mais commenté pour relecture du développeur
     * Passe tous les lignes commenté
     * 
     * @param myBufferedReader 
     *          Le flux de lecture qui va lire de nouvelles ligne si la ligne actuel est un commentaire 
     * @return Renvoie la dernière ligne non commenté lue par le flux de lecture
     *
     * @see Reader#read()
     */
    private String passLineComment(BufferedReader myBufferedReader) {
        try {
            String line = myBufferedReader.readLine();
            while (lineIsComment(line)) {
                line = myBufferedReader.readLine();
            }
            return line;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
        String line = new String();

        int[][][] matrix = null;

        try {

            FileReader myFileReader = new FileReader(this.filename);
            BufferedReader myBufferedReader = new BufferedReader(myFileReader);
            // Gérer les commentaires
            line = passLineComment(myBufferedReader);
            
            if(!(line.charAt(0) == 'P' && line.charAt(1) == '1')) throw new IOException("Error Format");
            //if(!line.equals("P1")) throw new IOException("Error Format");
            
            line = passLineComment(myBufferedReader);
    
            Integer widthMatrix;
            Integer heightMatrix;
            
            StringTokenizer stringTokenizer = new StringTokenizer(line," ");

            widthMatrix = new Integer(stringTokenizer.nextToken());
            heightMatrix = new Integer(stringTokenizer.nextToken());

            matrix = new int[heightMatrix][widthMatrix][3];
            

            int widthTMP = 0;
            int heightTMP = 0;
            
            line = passLineComment(myBufferedReader);
            
            do {
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
                    } else if (c != ' ') {
                        throw new IOException("Bad Value During Read");
                    }
                }
            } while ((line = myBufferedReader.readLine()) != null);

            myBufferedReader.close();
            myFileReader.close();


        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        return matrix;
    }

}
