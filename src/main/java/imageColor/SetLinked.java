package imageColor;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by loic on 09/10/15.
 */
public class SetLinked {

    public class SetL{
        public Node head;
        public Node tail;
        public int size;

        public  SetL(Node x)
        {
            head = x;
            tail = x;
            size = 1;
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

        if (xSet.size >= ySet.size)
            append(xSet, ySet);
        else
            append(ySet, xSet);
    }

    private void append(SetL first, SetL second)
    {
        for (Node x = second.head; x != null; x = x.next){
            x.representative = first;
        }

        first.tail.next = second.head;
        first.tail = second.tail;
        first.size += second.size;

        second.head = null;
        second.tail = null;
        second.size = 0;

    }

    public SetL findSet(Node x)
    {
        return x.representative;
    }

}
