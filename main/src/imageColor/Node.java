package imageColor;

/**
 * Created by loic on 09/10/15.
 */
public class Node {

    private Node referant;

    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
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

    public Node getReferant() {
        return referant;
    }

    public void setReferant(Node referant) {
        this.referant = referant;
    }
}
