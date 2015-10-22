package imageColor;

import java.util.Random;

/**
 * Classe dédié à la coloration et l'execution final de l'algorithme
 *
 * @author Loic Mickael
 * @version 1.0
 */
class Coloring {

    /**
     * Création de la totalité des sets dans la matrice de nodes, initialise la matrice de nodes à partir de la matrice de int
     *
     * @param nodes
     *          La matrice de noeud reliant déstiné à être unifié
     * @param matrix
     *          La matrice de int lus à la lecture
     * @param linked
     *          L'ensemble de lien, utilisé pour créé des ensemble dans la matrice de noeud
     */
    private void makeAllSet(Node[][] nodes, int[][][] matrix, SetLinked linked) {
        Random randomGenerator = new Random();
        for(int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j][0] == 255 && matrix[i][j][1] == 255 && matrix[i][j][2] == 255) {
                    int r = randomGenerator.nextInt(256);
                    int g = randomGenerator.nextInt(256);
                    int b = randomGenerator.nextInt(256);
                    matrix[i][j][0] = r;
                    matrix[i][j][1] = g;
                    matrix[i][j][2] = b;
                    int[] tmp1 = {r,g,b};
                    nodes[i][j] = linked.makeSet(new Pixel(i, j, tmp1));
                }
            }
        }
    }

    /**
     * Réalise la totalité des unions dans la matrice
     *
     * @param nodes
     *          La matrice de noeuds
     * @param linked
     *          L'instance de liste s'occupant de l'union de la totalité des nodes
     */
    private void makeAllUnion(Node[][] nodes, SetLinked linked) {

        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[i].length ; j++) {

                if (nodes[i][j] == null) continue;

                 if (j == nodes[0].length-1 && i+1 < nodes.length) {
                    if (nodes[i+1][j] != null && !(nodes[i][j].getRepresentative().equals(nodes[i+1][j].getRepresentative()))) {
                        linked.union2(nodes[i][j], nodes[i + 1][j]);
                        ((nodes[i+1][j].getThePixel())).setColor((nodes[i][j].getThePixel()).getColor());
                    }
                } else if(i == nodes.length - 1 && j + 1 < nodes[0].length) {
                    if (nodes[i][j+1] != null && !(nodes[i][j].getRepresentative().equals(nodes[i][j+1].getRepresentative()))) {
                        linked.union2(nodes[i][j], nodes[i][j + 1]);
                        nodes[i][j+1].getThePixel().setColor(nodes[i][j].getThePixel().getColor());
                    }
                } else if (j + 1 < nodes[0].length && i + 1 < nodes.length) {
                    if (nodes[i+1][j] != null && !(nodes[i][j].getRepresentative().equals(nodes[i+1][j].getRepresentative()))) {
                        linked.union2(nodes[i][j], nodes[i + 1][j]);
                        nodes[i+1][j].getThePixel().setColor(nodes[i][j].getThePixel().getColor());
                    }
                    if (nodes[i][j+1] != null && !(nodes[i][j].getRepresentative().equals(nodes[i][j+1].getRepresentative()))) {
                        linked.union2(nodes[i][j], nodes[i][j + 1]);
                        nodes[i][j+1].getThePixel().setColor(nodes[i][j].getThePixel().getColor());
                    }
                }
                
            }
        }

    }

    /**
     * Réalise la transformation de la matrice de noeux en matrice de int en préparation pour l'écriture
     *
     * @param nodes
     *          Matrice contenant la totalité des noeuds fusionné
     * @param matrix
     *          Matrice de int attendant la modification des couleurs
     */
    private void switchNodeToMatrix(Node[][] nodes, int[][][] matrix) {

        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                if (nodes[i][j] != null) matrix[i][j] = ((Pixel)nodes[i][j].getRepresentative().getHead().getThePixel()).getColor();
                else{
                    int[] blackColor = {0,0,0};
                    matrix[i][j] = blackColor;
                }
            }
        }


    }

    /**
     * Algorithme final colorisant l'image
     *
     * @param fileRead
     *              Le fichier en lecture
     * @param filePrint
     *              Le nom du fichier en écriture
     */
    public void coloring (String fileRead, String filePrint) {
        Reader reader = new Reader(fileRead);
        int[][][] matrix = reader.read();

        Node[][] nodes = new Node[matrix.length][matrix[0].length];
        SetLinked linked = new SetLinked();

        makeAllSet(nodes, matrix, linked);
        makeAllUnion(nodes, linked);
        switchNodeToMatrix(nodes, matrix);

        Writer writer = new Writer(matrix);
        writer.writeMatrix(filePrint);
    }


    public static void main (String[] args) {
        Coloring coloring = new Coloring();
        coloring.coloring(args[0], args[1]);
    }
   

}
