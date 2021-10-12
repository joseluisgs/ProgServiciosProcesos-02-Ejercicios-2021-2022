package TDA;

import java.util.ArrayDeque;

public class Cola<E> extends ArrayDeque<E> implements ICola<E> {

    public void encolar(E item) {
        this.add(item);
    }

    public E desencolar() {
        return this.removeFirst();
    }
}