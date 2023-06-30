package org.adt.core.adt.TPOpuntos;

import java.util.Objects;

public class DoubleCyclicQueueNode {
    private int value;
    private DoubleCyclicQueueNode next;
    private DoubleCyclicQueueNode previous;

    public DoubleCyclicQueueNode(int value, DoubleCyclicQueueNode next, DoubleCyclicQueueNode previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public DoubleCyclicQueueNode getNext() {
        return next;
    }

    public void setNext(DoubleCyclicQueueNode next) {
        this.next = next;
    }

    public DoubleCyclicQueueNode getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleCyclicQueueNode previous) {
        this.previous = previous;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleCyclicQueueNode node = (DoubleCyclicQueueNode) o;
        return getValue() == node.getValue() &&
                Objects.equals(getNext(), node.getNext()) &&
                Objects.equals(getPrevious(), node.getPrevious());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getNext(), getPrevious());
    }
}
