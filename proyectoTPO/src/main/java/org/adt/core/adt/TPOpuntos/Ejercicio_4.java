package org.adt.core.adt.TPOpuntos;

public class Ejercicio_4 {
    /*En set:

    public Set addBuilder(int a) {
        if (this.first == null) {
            this.first = new Node(a, null);
            this.count++;
            return this;
        }

        if (this.first.getValue() == a) {
            return this;
        }

        Node candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
            if (candidate.getValue() == a) {
                return this;
            }
        }
        candidate.setNext(new Node(a, null));
        this.count++;
        return this;
    }

    public Set addAll(Set a) {
        while(!a.isEmpty()){
            int x= a.choose();
            this.add(x);
            a.remove(x);
        }
        return this;
    }
     */

    /*En Stack:

    public Stack addBuilder(int a) {
        this.first = new Node(a, this.first);
        return this;
    }

    public Stack addAll(Set a) {
        while(!a.isEmpty()){
            int x= a.choose();
            this.add(x);
            a.remove(x);
        }
        return this;
    }
     */

    /* En normal Queue:

    public Queue(Integer...values){
        this.array=new int[10000];
        this.count=0;
        for (Integer value : values) {
            this.add(value);
        }
    }
     */
}
