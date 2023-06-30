package org.adt.core.adt.TPOpuntos;

import org.adt.core.adt.definition.IQueue;

public class DoubleCyclicQueue implements IQueue {
    private DoubleCyclicQueueNode first;
    private DoubleCyclicQueueNode last;

    @Override
    public void add(int a) {
        DoubleCyclicQueueNode node = new DoubleCyclicQueueNode(a, null, null);
        if (isEmpty()) {
            this.first = node;
            this.last = node;
        } else {
            node.setNext(this.first);
            this.first.setPrevious(node);
            this.first = node;
        }
        this.first.setPrevious(this.last);
        this.last.setNext(this.first);
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            System.out.println("No se puede desacolar una cola vacía");
            return;
        }
        if (this.first == this.last) {
            this.first = null;
            this.last = null;
        } else {
            DoubleCyclicQueueNode newLast = this.last.getPrevious();
            newLast.setPrevious(this.first);
            this.first.setPrevious(newLast);
            this.last = newLast;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public int getFirst() {
        if (isEmpty()) {
            System.out.println("No se puede obtener el primero de una cola vacía");
            return -1;
        }
        return this.last.getValue();
    }
}
