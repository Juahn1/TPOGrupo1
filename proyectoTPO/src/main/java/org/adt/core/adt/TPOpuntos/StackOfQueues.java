package org.adt.core.adt.utils;
import org.adt.core.adt.definition.IQueue;
import org.adt.core.adt.implementation.normal.Queue;

public class StackOfQueues {
    private IQueue[] arrayofQueues = new IQueue[10000];

    private int count=0;
    public StackOfQueues() {
    }

    public void add(IQueue a) {
        this.arrayofQueues[this.count] = a;
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

    public IQueue getTop() {
        if (count == 0) {
            System.out.println("Error, no se puede obtener el tope de una pila vacia");
            return null;
        }
        return this.arrayofQueues[this.count - 1];
    }
    public static void main(String[] args){
        StackOfQueues soq = new StackOfQueues();
        IQueue cola1 = new Queue();
        IQueue cola2 = new Queue();
        IQueue cola3 = new Queue();
        cola1.add(1);
        cola1.add(2);
        cola1.add(3);
        cola2.add(30);
        cola2.add(40);
        cola2.add(50);
        cola3.add(600);
        cola3.add(700);
        cola3.add(800);
        soq.add(cola1);
        soq.add(cola2);
        soq.add(cola3);
        while(!soq.isEmpty()){
            while(!soq.getTop().isEmpty()){
                System.out.println(soq.getTop().getFirst());
                soq.getTop().remove();
            }
            soq.remove();
        }

    }
}
