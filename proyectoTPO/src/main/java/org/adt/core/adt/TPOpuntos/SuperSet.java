package org.adt.core.adt.TPOpuntos;

import org.adt.core.adt.definition.ISet;
import org.adt.core.adt.implementation.dynamic.Set;
import org.adt.core.adt.implementation.dynamic.node.Node;

import java.util.Objects;
import java.util.Random;

public class SuperSet implements ISet {
    private Node first;
    private int count;

    @Override
    public void add(int a) {
        if (this.first == null) {
            this.first = new Node(a, null);
            this.count++;
            return;
        }

        if (this.first.getValue() == a) {
            return;
        }

        Node candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
            if (candidate.getValue() == a) {
                return;
            }
        }
        candidate.setNext(new Node(a, null));
        this.count++;
    }

    @Override
    public void remove(int a) {
        if (this.first == null || (this.first.getNext() == null && this.first.getValue() != a)) {
            return;
        }

        if (this.first != null && this.first.getNext() == null) {
            if (this.first.getValue() == a) {
                this.first = null;
                this.count--;
            }
            return;
        }

        if (this.first.getValue() == a) {
            this.first = this.first.getNext();
            this.count--;
            return;
        }

        Node backup = this.first;
        Node candidate = this.first.getNext();

        while (candidate != null) {
            if (candidate.getValue() == a) {
                backup.setNext(candidate.getNext());
                this.count--;
                return;
            }
            backup = candidate;
            candidate = candidate.getNext();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int choose() {
        if (this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacio");
            return -1;
        }
        int randomIndex = (new Random()).nextInt(this.count);
        Node candidate = this.first;
        for (int i = 1; i <= randomIndex; i++) {
            candidate = candidate.getNext();
        }
        return candidate.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperSet set = (SuperSet) o;
        return count == set.count && Objects.equals(first, set.first);
    }
    public boolean isIn(int a) {
        Node current = this.first;
        while (current != null) {
            if (current.getValue() == a) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
    public SuperSet copySet(){
        int[] values= new int[this.count];
        SuperSet V= new SuperSet();
        int count=0;
        while(!this.isEmpty()){
            int x=this.choose();
            values[count]=x;
            count++;
            V.add(x);
            this.remove(x);
        }
        for (int value : values) {
            this.add(value);
        }
        return V;
    }
    public boolean subSet(Set a){
        Set Scopy=a.copySet();
        SuperSet SScopy=this.copySet();
        if (SScopy.isEmpty()) {
            return false;
        }
        if (Scopy.isEmpty()) {
            return true;
        }
        while (!Scopy.isEmpty()) {
            int x;
            x = Scopy.choose();
            if (!SScopy.isIn(x)) {
                return false;
            } else {
                SScopy.remove(x);
                Scopy.remove(x);
            }
        }
        return Scopy.isEmpty();
    }

    public Set complemento(Set a){
        if(!this.subSet(a)){
            throw new IllegalArgumentException("El conjunto no es subconjunto del Supeconjunto.");
        }
        SuperSet copy= this.copySet();
        Set complemento= new Set();
        while(!copy.isEmpty()){
            int x=copy.choose();
            if(!a.isIn(x)){
                complemento.add(x);
            }
            copy.remove(x);
        }
        return complemento;
    }
}
