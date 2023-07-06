package org.adt.core.adt.utils;

import java.util.ArrayList;

public class PriorityQueueGenerico<T> {

    private static final int LENGTH = 10000;

    private final ArrayList<T> array;
    private final int[] priorities;
    private int count;

    public PriorityQueueGenerico() {
        this.array = new ArrayList<T>(LENGTH);
        this.priorities = new int[LENGTH];
        this.count = 0;
    }

    public void add(T a, int priority) {
        int index = binarySearch(priority);

        for (int i = this.count; i > index; i--) {
            this.array.set(i, this.array.get(i - 1));
            this.priorities[i] = this.priorities[i - 1];
        }

        this.array.set(index, a);
        this.priorities[index] = priority;

        this.count++;
    }

    // Solo para prioridades no repetidas, sino debe utilizarse otra tecnica
    private int binarySearch(int priority) {
        int low = 0;
        int high = this.count - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (this.priorities[mid] == priority) {
                return mid;
            } else if (this.priorities[mid] < priority) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public void remove() {
        if (count == 0) {
            System.out.println("Error, no se puede desacolar una cola vacia");
            return;
        }
        for (int i = 0; i < this.array.size() - 1; i++) {
            this.array.set(i, this.array.get(i + 1));
            this.priorities[i] = this.priorities[i + 1];
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

    public int getPriority() {
        if (count == 0) {
            System.out.println("Error, no se puede obtener la prioridad del primero de una cola vacia");
            return -1;
        }
        return this.priorities[0];
    }
}
