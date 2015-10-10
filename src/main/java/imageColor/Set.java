package imageColor;

import java.util.ArrayList;

/**
 * Created by loic on 09/10/15.
 */
public class Set<E> extends ArrayList<E> {

    private E head;
    private E tail;

    public Set<E> makeSet (E n){
        head = n;
        tail = n;
        super.add(n);
        return this;
    }
   
    public void setHead (E head) {
        this.head = head; 
    }

    public void setTail (E tail) {
        this.tail = tail;
    }

    public E getHead() {
        return head;
    }

    public E getTail() {
        return tail;
    }
}
