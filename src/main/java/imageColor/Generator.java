package imageColor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Classe déstiné à generer des fichiers pbm aléatoirement.
 *
 * @author Mickael Loic
 * @version 1.0
 */
public class Generator {

    /**
     * Nom du fichier à génerer
     *
     * @see Generator(String)
     * @see generate(Integer, Integer)
     */
    String filename;

    /**
     * Constructeur de la géneration, instancie le nom du fichier
     * 
     * @param filename
     *          Le nom du fichier a instancié 
     * 
     * @see Generator#filename
     */
    public Generator(String filename) {
        this.filename = filename;
    }


    /**
     * Fonction destiné à generer le fichier et à écrire dedans
     *
     * @param heightPixel
     *                  La hauteur de l'image géneré
     * @param widthPixel
     *                  La largeur de l'image géneré
     * 
     * @see Generator#filename
     */
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
    
    /**
     * Main génerant un fichier et le coloriant
     * 
     * @param args
     *          Tableau des arguments d'execution le première argument et le nom du fichier géneré, le deuxième le fichier à écrire
     *          Le troisième la longueur du fichier et le quatrième la largeur
     *
     * @see Generator#generate
     * @see Coloring#coloring
     */
    public static void main (String[] args) {
        Generator generate = new Generator(args[0]);
        generate.generate(Integer.valueOf(args[2]), Integer.valueOf(args[3]));
        Coloring coloring = new Coloring();
        coloring.coloring(args[0], args[1]);
        
    }
}
