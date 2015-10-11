package imageColor;

import java.util.ArrayList;

class Coloring {

    public void union (Set<Node> bigSet, Set<Node> littleSet) {
        (bigSet.getTail()).setNext(littleSet.getHead());
        bigSet.setTail(littleSet.getTail());
        for(Node node : littleSet) {
            node.setReferant(bigSet.getHead());
        }
    }

    private void createMatrixSet (Set<Node>[][] matrixSet, Integer[][] matrix) {
        for(int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                     Set<Node> set = new Set<>();
                    matrixSet[i][j] = set.makeSet(new Node (i, j));
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
        Reader reader = new Reader("carte_france.pbm");
        Integer[][] matrix = reader.read();

        Set<Node>[][] sets = new Set[matrix.length][matrix[0].length];

        createMatrixSet(sets, matrix);

        for(int i = 0; i < sets.length; ++i) {
            for (int j = 0; j < sets[0].length; ++j) {
                Set<Node> a;
                if (i > 0 && j > 0 && j+1 < sets[0].length && i+1 < sets[0].length ){
                    if (sets[i-1][j] != null && sets[i][j] != null && (sets[i][j]).getHead() != (a = sets[i-1][j]).getHead() )
                        union(sets[i][j],a);
                    if(sets[i][j-1] != null &&  sets[i][j] != null && (sets[i][j]).getHead() != (a = sets[i][j-1]).getHead())
                        union(sets[i][j],a);
                    if(sets[i+1][j] != null &&  sets[i][j] != null && (sets[i][j]).getHead() != (a = sets[i+1][j]).getHead())
                        union(sets[i][j],a);
                    if(sets[i][j+1] != null &&  sets[i][j] != null && (sets[i][j]).getHead() != (a = sets[i][j+1]).getHead())
                        union(sets[i][j],a);

                }else if(i == 0 && j > 0 && j+1 < sets[0].length ){
                    if (sets[i][j-1] != null &&  sets[i][j] != null && (sets[i][j]).getHead() != (a = sets[i][j-1]).getHead())
                        union(sets[i][j],a);
                    if(sets[i+1][j] != null && sets[i][j] != null && (sets[i][j]).getHead() != (a = sets[i+1][j]).getHead())
                        union(sets[i][j],a);
                    if(sets[i][j+1] != null &&  sets[i][j] != null && (sets[i][j]).getHead() != (a = sets[i][j+1]).getHead())
                        union(sets[i][j],a);
                }
                else if (j == 0 && i > 0 && i+1 < sets[0].length){
                    if (sets[i-1][j] != null &&  sets[i][j] != null && (sets[i][j]).getHead() != (a = sets[i-1][j]).getHead())
                        union(sets[i][j],a);
                    if(sets[i+1][j] != null && sets[i][j] != null && (sets[i][j]).getHead() != (a = sets[i+1][j]).getHead())
                        union(sets[i][j],a);
                    if(sets[i][j+1] != null  && sets[i][j] != null && (sets[i][j]).getHead() != (a = sets[i][j+1]).getHead())
                        union(sets[i][j],a);
                }
                else if( i == 0 && j == 0 && i+1 < sets[0].length && j+1 < sets[0].length){
                    if(sets[i+1][j] != null && sets[i][j] != null && (sets[i][j]).getHead() != (a = sets[i+1][j]).getHead())
                        union(sets[i][j],a);
                    if(sets[i][j+1] != null && sets[i][j] != null && (sets[i][j]).getHead() != (a = sets[i][j+1]).getHead())
                        union(sets[i][j],a);
                }
            }
        }
        System.out.println(sets);
    }


    public static void main (String[] args) {
        Coloring coloring = new Coloring();
        coloring.coloring();
    }
   

}
