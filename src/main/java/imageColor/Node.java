package imageColor;

/**
 * Created by loic on 09/10/15.
 */
public class Node {

    private Object theObject;
    private Node next;
    private SetLinked.SetL representative;

    public Node(Object x) {
        theObject = x;
        next = null;
        representative = null;
    }

    public Object getTheObject() {
        return theObject;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public SetLinked.SetL getRepresentative() {
        return representative;
    }

    public void setRepresentative(SetLinked.SetL representative) {
        this.representative = representative;
    }

    public String toString() {
        return theObject.toString();
    }

}
