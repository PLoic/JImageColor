package imageColor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class Coloring {

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

    private void makeAllUnion(Node[][] nodes, SetLinked linked) {

        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[i].length ; j++) {

                if (nodes[i][j] == null) continue;

                 if (j == nodes[0].length-1 && i+1 < nodes.length) {
                    if (nodes[i+1][j] != null && !(nodes[i][j].getRepresentative().equals(nodes[i+1][j].getRepresentative()))) {
                        linked.union(nodes[i][j], nodes[i + 1][j]);
                        ((Pixel)(nodes[i+1][j].getTheObject())).setColor(((Pixel)nodes[i][j].getTheObject()).getColor());
                    }
                } else if(i == nodes.length - 1 && j + 1 < nodes[0].length) {
                    if (nodes[i][j+1] != null && !(nodes[i][j].getRepresentative().equals(nodes[i][j+1].getRepresentative()))) {
                        linked.union(nodes[i][j], nodes[i][j + 1]);
                        ((Pixel)(nodes[i][j+1].getTheObject())).setColor(((Pixel)nodes[i][j].getTheObject()).getColor());
                    }
                } else if (j + 1 < nodes[0].length && i + 1 < nodes.length) {
                    if (nodes[i+1][j] != null && !(nodes[i][j].getRepresentative().equals(nodes[i+1][j].getRepresentative()))) {
                        linked.union(nodes[i][j], nodes[i + 1][j]);
                        ((Pixel)(nodes[i+1][j].getTheObject())).setColor(((Pixel)nodes[i][j].getTheObject()).getColor());
                    }
                    if (nodes[i][j+1] != null && !(nodes[i][j].getRepresentative().equals(nodes[i][j+1].getRepresentative()))) {
                        linked.union(nodes[i][j], nodes[i][j + 1]);
                        ((Pixel)(nodes[i][j+1].getTheObject())).setColor(((Pixel)nodes[i][j].getTheObject()).getColor());
                    }
                }
            }
        }

    }

    private void switchNodeToMatrix(Node[][] nodes, int[][][] matrix) {

        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                if (nodes[i][j] != null) matrix[i][j] = ((Pixel)nodes[i][j].getRepresentative().getHead().getTheObject()).getColor();
                else{
                    int[] blackColor = {0,0,0};
                    matrix[i][j] = blackColor;
                }
            }
        }


    }

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
