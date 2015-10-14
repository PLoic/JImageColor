package imageColor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class Coloring {

    public void coloring () {
        Reader reader = new Reader("biang.pbm");
        int[][][] matrix = reader.read();

        Node[][] a = new Node[matrix.length][matrix[0].length];


        SetLinked linked = new SetLinked();

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
                    a[i][j] = linked.makeSet(new Value(i, j, tmp1));
                } else {
                    int[] tmp1 = {0,0,0};
                    a[i][j] = linked.makeSet(new Value(i, j, tmp1));
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length ; j++) {

                if (((Value)a[i][j].theObject).color[0] == 0 && ((Value)a[i][j].theObject).color[1] == 0 && ((Value)a[i][j].theObject).color[2] == 0) continue;

                if (j+1 < a[0].length && i+1 < a.length){
                    if(!(a[i][j].representative.head.equals(a[i+1][j].representative.head)) && ((Value)a[i+1][j].theObject).color[0] != 0 && ((Value)a[i+1][j].theObject).color[1] != 0 && ((Value)a[i+1][j].theObject).color[2] != 0){
                        linked.union(a[i][j], a[i + 1][j]);
                    }
                    if(!(a[i][j].representative.head.equals(a[i][j+1].representative.head)) && ((Value)a[i][j+1].theObject).color[0] != 0 && ((Value)a[i][j+1].theObject).color[1] != 0 && ((Value)a[i][j+1].theObject).color[2] != 0){
                        linked.union(a[i][j], a[i][j + 1]);
                    }
                }
                else if(j == a[0].length-1 && i+1 < a.length){
                    if(!(a[i][j].representative.head.equals(a[i+1][j].representative.head)) && ((Value)a[i+1][j].theObject).color[0] != 0 && ((Value)a[i+1][j].theObject).color[1] != 0 && ((Value)a[i+1][j].theObject).color[2] != 0){
                        linked.union(a[i][j], a[i + 1][j]);
                    }
                }
                else if(i == a.length-1 && j+1 < a[0].length){
                    if(!(a[i][j].representative.head.equals(a[i][j+1].representative.head)) && ((Value)a[i][j+1].theObject).color[0] != 0 && ((Value)a[i][j+1].theObject).color[1] != 0 && ((Value)a[i][j+1].theObject).color[2] != 0){
                        linked.union(a[i][j], a[i][j + 1]);
                    }
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                matrix[i][j] = ((Value)a[i][j].representative.head.theObject).color;
            }
        }

        Writer writer = new Writer(matrix);
        writer.writeMatrix("con.ppm");
    }


    public static void main (String[] args) {
        Coloring coloring = new Coloring();
        coloring.coloring();
    }
   

}
