package imageColor;

/**
 * Created by loic on 09/10/15.
 */
public class Node {

    public Object theObject;
    public Node next;
    public SetLinked.SetL representative;

    public Node(Object x)
    {
        theObject = x;
        next = null;
        representative = null;
    }

    public String toString()
    {
        return theObject.toString();
    }

}
