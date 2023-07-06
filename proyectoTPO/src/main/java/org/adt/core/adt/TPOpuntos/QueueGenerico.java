package org.adt.core.adt.utils;

import java.util.ArrayList;

public class QueueGenerico<T> {
    private final ArrayList<T> array;
    private int count;

    public QueueGenerico() {
        this.array = new ArrayList<T>(10000);
        this.count = 0;
    }

    public void add(T a) {
        this.array.add(this.count,a);
        this.count++;
    }

    public void remove() {
        if (count == 0) {
            System.out.println("Error, no se puede desacolar una cola vacia");
            return;
        }
        for (int i = 0; i < this.array.size() - 1; i++) {
            this.array.set(i, this.array.get(i + 1));
        }
        this.count--;
    }


    public boolean isEmpty() {
        return this.count == 0;
    }


    public T getFirst() {
        if (count == 0) {
            System.out.println("Error, no se puede obtener el primero de una cola vacia");
            return null;
        }
        return this.array.get(0);
    }
}
