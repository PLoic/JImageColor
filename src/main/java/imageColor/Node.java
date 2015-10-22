package imageColor;

/**
 * La classe Node est une cellule de la liste
 *
 * @author Loic Mickael
 * @version 1.0
 */
public class Node {

    /**
     * thePixel représente le pixel du noeud dans notre cas le pixel
     *
     * @see Node#Node(Pixel) 
     * @see Node#getThePixel()
     */
    private Pixel thePixel;
    
    /**
     * next est un pointeur sur le noeud suivant, permet de ce déplacer dans la liste
     *
     * @see Node#Node(Pixel)
     * @see Node#getNext()
     * @see Node#setNext(Node)
     */
    private Node next;
    
    /**
     * Pointeur sur le reprensentant de la liste
     *
     * @see Node#getRepresentative()
     * @see Node#setRepresentative(SetLinked.SetL)
     */
    private SetLinked.SetL representative;
    
    /**
     * Constructeur du noeud
     *
     * @param x
     *       Le pixel qui va être instancier
     * 
     * @see Node#thePixel
     * @see Node#next
     * @see Node#representative
     */
    public Node(Pixel x) {
        thePixel = x;
        next = null;
        representative = null;
    }
    
    /**
     * Renvoie le pixel du noeud
     *
     * @return Le pixel du noeud
     * @see Node#thePixel
     */
    public Pixel getThePixel() {
        return thePixel;
    }

    /**
     * Renvoie le pointeur du noeud d'après
     *
     * @return le pointeur noeud d'après
     * @see Node#next
     */
    public Node getNext() {
        return next;
    }

    /**
     * Modifie le pointeur du noeud d'après
     *
     * @param next
     *          Le nouveau pointeur
     * @see Node#next 
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Renvoie le pointeur sur le représentant de la liste
     *
     * @return Le pointeur sur le représentant de la liste
     *
     * @see Node#representative
     */
    public SetLinked.SetL getRepresentative() {
        return representative;
    }

    /**
     * Modifie le représentant d'un noeud
     * 
     * @param representative
     *          Pointeur sur le représentant
     * @see Node#representative
     */
    public void setRepresentative(SetLinked.SetL representative) {
        this.representative = representative;
    }


}
