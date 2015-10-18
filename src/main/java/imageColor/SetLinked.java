package imageColor;

import java.util.ArrayList;
import java.util.Set;

/**
 * Classe dédié à la mise en place de la liste et au fonction associé
 *
 * @author Loic Mickaël
 * @version 1.0
 */
public class SetLinked {

    /**
     * Sous-Classe dédié à initié la liste avec ses méthodes de bases
     *
     * @author Loic Mickaël
     * @version 1.0
     */
    public class SetL {
        
        /**
         * Pointeur sur le noeud de tête
         *
         * @see SetL#getHead()
         * @see SetL#setHead(Node)
         * @see SetL#SetL(Node)
         */
        private Node head;
        
        /**
         * Pointeur sur le noeud de queue 
         *
         * @see SetL#getTail()
         * @see SetL#setTail(Node)
         * @see SetL#SetL(Node)
         */
        private Node tail;

        /**
         * Taille de la liste
         *
         * @see SetL#getSize()
         * @see SetL#setSize(Node)
         * @see SetL#SetL(Node)
         */
        private int size;

        /**
         * Renvoie la tête de la liste
         *
         * @return La tête de la liste
         * @see SetL#head
         */
        public Node getHead() {
            return head;
        }

        /**
         * Renvoie la queue de la liste
         *
         * @return La queue de la liste 
         * @see SetL#tail
         */
        public Node getTail() {
            return tail;
        }

        /**
         * Renvoie la taille de la liste
         *
         * @return la taille de la liste
         * @see SetL#size
         */
        public int getSize() {
            return size;
        }
       
        /**
         * Modifie la tête de la liste
         *
         * @param head
         *          La nouvelle tête de la liste
         * @see SetL#head
         */ 
        public void setHead(Node head) {
            this.head = head;
        }

        /**
         * Modifie la queue de la liste
         *
         * @param tail 
         *            La nouvelle queue de la liste
         * @see SetL#tail
         */
        public void setTail(Node tail) {
            this.tail = tail;
        }

        /**
         * Modifie la taille de la liste
         *
         * @param size
         *          La nouvelle taille de la liste
         * @see SetL#size
         */
        public void setSize(int size) {
            this.size = size;
        }

        /**
         * Le constructeur de liste
         *
         * @param x
         *          Le noeud utilisé pour construire une liste
         * @see SetL#head 
         * @see SetL#tail 
         * @see SetL#size 
         */
        public  SetL(Node x) {
            head = x;
            tail = x;
            size = 1;
        }
    }

    /**
     * Crée un set par rapport à un objet dans notre cas un pixel
     *
     * @param x
     *        Répresente un objet à ajouter à un set
     * @return Le noeud crée a partir de l'objet
     */
    public Node makeSet(Object x) {
        Node node = new Node(x);
        SetL disjointSet = new SetL(node);
        node.setRepresentative(disjointSet);
        return node;
    }

    /**
     * Réalise l'union entre deux sets, a partir de deux nodes
     *
     * @param x
     *         Le premier noeud
     * @param y 
     *         Le second noeud
     */
    public void union(Node x, Node y) {

        SetL xSet = findSet(x);
        SetL ySet = findSet(y);

        if (xSet.getSize() >= ySet.getSize())
            append(xSet, ySet);
        else
            append(ySet, xSet);
    }

    /**
     * Réalise l'algorithme  de la fusion entre deux sets
     *
     * @param first
     *         Le premier noeud
     * @param second 
     *         Le second noeud
     */
    private void append(SetL first, SetL second) {
        for (Node x = second.getHead(); x != null; x = x.getNext()) {
            x.setRepresentative(first);
        }

        first.getTail().setNext(second.getHead());
        first.setTail(second.getTail());
        first.setSize(first.getSize() + second.getSize());

        second.setHead(null);
        second.setTail(null);
        second.setSize(0);

    }

    /**
     * Renvoie le set correspondant au Noeud
     *
     * @param x
     *         Le noeud renvoyant son representant
     * @return Renvoie le representant
     */
    public SetL findSet(Node x) {
        return x.getRepresentative();
    }

}
