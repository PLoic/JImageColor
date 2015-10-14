package imageColor;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by loic on 09/10/15.
 */
public class SetLinked {

    public class SetL {
        
        private Node head;
        private Node tail;
        private int size;

        public Node getHead() {
            return head;
        }

        public Node getTail() {
            return tail;
        }

        public int getSize() {
            return size;
        }
        
        public void setHead(Node head) {
            this.head = head;
        }

        public void setTail(Node tail) {
            this.tail = tail;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public  SetL(Node x) {
            head = x;
            tail = x;
            size = 1;
        }
    }


    public Node makeSet(Object x) {
        Node node = new Node(x);
        SetL disjointSet = new SetL(node);
        node.setRepresentative(disjointSet);
        return node;
    }

    public void union(Node x, Node y) {

        SetL xSet = findSet(x);
        SetL ySet = findSet(y);

        if (xSet.getSize() >= ySet.getSize())
            append(xSet, ySet);
        else
            append(ySet, xSet);
    }

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

    public SetL findSet(Node x) {
        return x.getRepresentative();
    }

}
