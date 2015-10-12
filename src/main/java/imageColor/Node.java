package imageColor;

/**
 * Created by loic on 09/10/15.
 */
public class Node {

    private Node referant;
    private Node next;

    private int x;
    private int y;
    private Integer[] color;

    public Node(int x, int y, Integer[] coloring) {
        this.x = x;
        this.y = y;
        this.color = coloring;
        next = null;
        referant = this;
    }

    public void setNext (Node next) {
        this.next = next;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Node findSet() {
        return referant;
    }

    public void setReferant(Node referant) {
        this.referant = referant;
    }

    public Integer[] getColor() {
        return color;
    }

    public void setColor(Integer[] color) {
        this.color = color;
    }

    public Node getNext() {
        return next;
    }

    public Node getReferant() {
        return referant;
    }
}
