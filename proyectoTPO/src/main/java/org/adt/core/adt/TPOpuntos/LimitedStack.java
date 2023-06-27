package org.adt.core.adt.TPOpuntos;

import org.adt.core.adt.definition.IStack;
import org.adt.core.adt.implementation.dynamic.node.Node;

public class LimitedStack implements IStack {
    private Node first;

    private final int max;

    private int count=0;

    public LimitedStack(int a,int M){
        this.first = new Node(a, this.first);
        this.count++;
        this.max=M;
    }
    @Override
    public void add(int a) {
        if((this.count+1)>this.max){
            System.out.println("No se pueden agregar mas elementos");
        }
        if((this.count+1)<=this.max){
            this.first = new Node(a, this.first);
            this.count++;
        }
    }

    @Override
    public void remove() {
        if (this.first == null) {
            System.out.println("No se puede desapilar una pila vacia");
            return;
        }
        this.first = this.first.getNext();
        this.count--;
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public int getTop() {
        if (this.first == null) {
            System.out.println("No se puede obtener el tope una pila vacia");
            return -1;
        }
        return this.first.getValue();
    }
}
