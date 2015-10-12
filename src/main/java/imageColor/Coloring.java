package imageColor;

import java.util.HashSet;
import java.util.Random;
import java.awt.Color;

class Coloring {

    public void union (Set<Node> bigSet, Set<Node> littleSet, java.util.Set<Node> headSet) {
        Integer[] color;
        color = bigSet.getHead().findSet().getColor();

        for(Node n = littleSet.getHead(); n != null ; n = n.getNext()) {
            n.setReferant(bigSet.getHead());
            n.setColor(color);
        }
        bigSet.getTail().setNext(littleSet.getHead());
        littleSet.setHead(bigSet.getHead());
        bigSet.setTail(littleSet.getTail());
        headSet.add(bigSet.getHead().getReferant());
    }

    private void createMatrixSet (Set<Node>[][] matrixSet, Integer[][][] matrix) {
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
                    Set<Node> set = new Set<>();
                    Integer[] tmp1 = {r,g,b};
                    matrixSet[i][j] = set.makeSet(new Node (i, j, tmp1));
                }else {
                    Set<Node> set = new Set<>();
                    Integer[] tmp1 = {0,0,0};
                    matrixSet[i][j] = set.makeSet(new Node (i, j, tmp1));
                }
            }
        }
    }

    private void makeAllUnion(Set<Node>[][] matrixSet) {
        for (int i = 0; i < matrixSet.length; ++i) {
            for (int j = 0; j < matrixSet[0].length; ++j) {
                // Faire l'union entre tous la fatigue djkqsdjqsdjq 
            }
        }
    }

    public void coloring () {
        Reader reader = new Reader("feep.pbm");
        Integer[][][] matrix = reader.read();

        Set<Node>[][] sets = new Set[matrix.length][matrix[0].length];

        createMatrixSet(sets, matrix);

        java.util.Set<Node> headSet = new HashSet<>();

        for(int i = 0; i < sets.length; ++i) {
            for (int j = 0; j < sets[0].length; ++j) {
                Set<Node> a;

                if(i == sets.length - 1 && j == sets[0].length - 1) continue;

                if(sets[i][j].getHead().getColor()[0] == 0 && sets[i][j].getHead().getColor()[1] == 0 && sets[i][j].getHead().getColor()[2] == 0) continue;

                if(j == sets[0].length - 1){
                    if((sets[i][j]).getHead() != (a = sets[i+1][j]).getHead() && sets[i+1][j].getHead().getColor()[0] != 0 && sets[i+1][j].getHead().getColor()[1] != 0 && sets[i+1][j].getHead().getColor()[2] != 0 )
                        union(sets[i][j],a,headSet);
                }
                if(i == sets.length - 1){
                    if ((sets[i][j]).getHead() != (a = sets[i][j+1]).getHead() && sets[i][j+1].getHead().getColor()[0] != 0 && sets[i][j+1].getHead().getColor()[1] != 0 && sets[i][j+1].getHead().getColor()[2] != 0)
                        union(sets[i][j],a,headSet);
                }

                if (j+1 < sets[0].length && i+1 < sets.length){
                    if ((sets[i][j]).getHead() != (a = sets[i][j+1]).getHead() && sets[i][j+1].getHead().getColor()[0] != 0 && sets[i][j+1].getHead().getColor()[1] != 0 && sets[i][j+1].getHead().getColor()[2] != 0)
                        union(sets[i][j],a,headSet);
                    if((sets[i][j]).getHead() != (a = sets[i+1][j]).getHead() && sets[i+1][j].getHead().getColor()[0] != 0 && sets[i+1][j].getHead().getColor()[1] != 0 && sets[i+1][j].getHead().getColor()[2] != 0 )
                        union(sets[i][j],a,headSet);
                }


            }
        }

        System.out.println(headSet);
        for (Node  n : headSet){
            for (Node tmp = n; tmp != null; tmp = tmp.getNext()) {
                matrix[tmp.getX()][tmp.getY()][0] = tmp.getColor()[0];
                matrix[tmp.getX()][tmp.getY()][1] = tmp.getColor()[1];
                matrix[tmp.getX()][tmp.getY()][2] = tmp.getColor()[2];
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
