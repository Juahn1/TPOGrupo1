package org.adt.core.adt.utils;

import java.util.ArrayList;

public class StackGenerico<T> {

    private final ArrayList<T> array;
    private int count;

    public StackGenerico() {
        this.array = new ArrayList<T>(10000);
        this.count = 0;
    }

    public void add(T a) {
        this.array.add(this.count, a);
        this.count++;
    }

    public void remove() {
        if (count == 0) {
            System.out.println("Error, no se puede desapilar una pila vacia");
            return;
        }
        this.count--;
    }


    public boolean isEmpty() {
        return this.count == 0;
    }


    public T getTop() {
        if (count == 0) {
            System.out.println("Error, no se puede obtener el tope de una pila vacia");
            return null;
        }
        return this.array.get(this.count - 1);
    }
}
