package org.adt.core.adt.TPOpuntos;

import org.adt.core.adt.definition.ISet;
import org.adt.core.adt.definition.IStack;
import org.adt.core.adt.algorithms.StackAlgorithms;
import org.adt.core.adt.implementation.normal.Stack;

import java.util.Queue;

public class QueueOfStacks {
    private IStack[] arrayofstacks;
    private int max;
    private int count;


    public QueueOfStacks(int n) {
        this.arrayofstacks = new IStack[n];
        this.count = 0;
        this.max = n;
    }





    private static int contador(IStack a) {
        int cont = 0;
        IStack aux = new Stack();
        while (!a.isEmpty()) {
            aux.add(a.getTop());
            cont++;
            a.remove();
        }
        while (!aux.isEmpty()) {
            a.add(aux.getTop());
            aux.remove();
        }
        return cont;
    }

    /*
     * #Precondicion: Que los stack tengan si o si 3 elementos
     * */
    public void add(IStack a) {
        if (this.count<this.max-1 && contador(a)==this.max) {
            this.arrayofstacks[this.count] = a;
        }
        this.count++;
    }

    public void remove() {
        if (count == 0) {
            System.out.println("Error, no se puede desacolar una cola vacia");
            return;
        }
        for (int i = 0; i < this.arrayofstacks.length - 1; i++) {
            this.arrayofstacks[i] = this.arrayofstacks[i + 1];
        }
        this.count--;
    }




    public boolean isEmpty() {
        return this.count == 0;
    }


    public IStack getFirst() {
        if (count == 0) {
            System.out.println("Error, no se puede obtener el primero de una cola vacia");
            return null;
        }
        return this.arrayofstacks[0];
    }


}

