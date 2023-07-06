package org.adt.core.adt.utils;

import java.util.ArrayList;
import java.util.Random;

public class SetGenerico<T> {

    private final ArrayList<T> array;
    private int count;

    public SetGenerico() {
        this.array = new ArrayList<T>(10000);
        this.count = 0;
    }

    public void add(T a) {
        for (int i = 0; i < this.count; i++) {
            if (this.array.get(i) == a) {
                return;
            }
        }

        this.array.add(this.count,a);
        this.count++;
    }

    public void remove(T a) {
        for (int i = 0; i < this.count; i++) {
            if (this.array.get(i) == a) {
                if (i == this.count - 1) {
                    this.count--;
                    return;
                }
                this.array.set(i, this.array.get(this.count - 1));
                this.count--;
            }
        }
    }


    public boolean isEmpty() {
        return this.count == 0;
    }


    public T choose() {
        if (this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacio");
            return null;
        }
        int randomIndex = (new Random()).nextInt(this.count);
        return this.array.get(randomIndex);
    }

}
