package imageColor;

import java.util.ArrayList;

class Coloring {

    public void union (Set<Node> bigSet, Set<Node> littleSet) {
        bigSet.getTail().setNext(littleSet.getHead()); 
        bigSet.setTail(littleSet.getTail());
        for(Node node : littleSet) {
            node.setReferant(bigSet.getHead());
        }
    }

    private void createMatrixSet (Set<Node>[][]matrixSet, Integer[][] matrix, Set<Node> set) {
        for(int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    Node node = new Node (i, j);
                    matrixSet[i][j] = set.makeSet(node);
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
        Reader reader = new Reader("/home/micka/Bureau/test.pbm");
        Integer[][] matrix = reader.read();

        // Marche pas a cause de la genericité Set<Node>[][] matrixSet = new ArrayList<Node>[matrix.length][matrix[0].length]; 
        // Chercher comment remplacer
        Set<Node> set = new Set<Node>(); // A changer

        createMatrixSet(matrixSet, matrix, set); // A factoriser avec makeAllUnion plus tard
        makeAllUnion(matrixSet);
    }


    public static void main (String[] args) {
        Coloring coloring = new Coloring();
        coloring.coloring();
    }
   

}
