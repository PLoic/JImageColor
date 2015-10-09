package imageColor;

import java.util.ArrayList;

/**
 * Created by loic on 09/10/15.
 */
public class Set<E> extends ArrayList<E> {

    private Node head;
    private Node tail;

    public Set makeSet(Node n){
        ArrayList<Node> a = new ArrayList<>();
        head = n;
        tail = n;
        a.add(n);
        return (Set) a;
    }

    public Node findReferant(Node x){
        return x.getReferant();
    }


}
