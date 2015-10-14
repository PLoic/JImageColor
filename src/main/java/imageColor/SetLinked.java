package imageColor;

import java.util.ArrayList;

/**
 * Created by loic on 09/10/15.
 */
public class SetLinked {

    public class SetL{
        public Node head;
        public Node tail;

        public  SetL(Node x)
        {
            head = x;
            tail = x;
        }
    }


    public Node makeSet(Object x)
    {
        Node node = new Node(x);
        SetL disjointSet = new SetL(node);
        node.representative = disjointSet;
        return node;
    }

    public void union(Node x, Node y)
    {
        SetL xSet = findSet(x);
        SetL ySet = findSet(y);
        append(xSet, ySet);
    }

    private void append(SetL first, SetL second)
    {
        for (Node x = second.head; x != null; x = x.next){
            x.representative = first;
            ((Value) x.theObject).color = ((Value)first.head.representative.head.theObject).color;
        }

        first.tail.next = second.head;
        first.tail = second.tail;


        second.head = null;
        second.tail = null;
    }

    public SetL findSet(Node x)
    {
        return x.representative;
    }

    public String printSet(Node x)
    {
        SetL set = findSet(x);
        return set.toString();
    }
}
