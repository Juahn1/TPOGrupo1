package org.adt.core.adt.TPOpuntos;

import java.util.Objects;

public class CountNode {
    private int value;
    private CountNode next;
    private int cantidad;

    public CountNode(int value,int cantidad, CountNode next) {
        this.value = value;
        this.cantidad=cantidad;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public CountNode getNext() {
        return next;
    }

    public void setNext(CountNode next) {
        this.next = next;
    }

    public int getCantidad() {return cantidad;}

    public void setCantidad(int cantidad) {this.cantidad = cantidad;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountNode node = (CountNode) o;
        return getValue() == node.getValue() && Objects.equals(getNext(), node.getNext());
    }

    public int hashCode() {
        return Objects.hash(value, next);
    }
}
