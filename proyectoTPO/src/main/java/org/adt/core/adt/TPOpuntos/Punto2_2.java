package org.adt.core.adt.TPOpuntos;

import org.adt.core.adt.definition.IQueue;
import org.adt.core.adt.definition.ISet;
import org.adt.core.adt.definition.IStack;
import org.adt.core.adt.implementation.normal.Queue;
import org.adt.core.adt.implementation.normal.Set;
import org.adt.core.adt.implementation.normal.Stack;

public class Punto2_2 {
    /*
    * 1 Desarrolle una función que reciba un Stack genérico e invierta sus elementos.
    *
    * 2 Desarrolle una función que copie un Set genérico
     */
    public static ISet copySet(ISet set){
        ISet aux = new Set();
        ISet aux2 = new Set();
        while(!set.isEmpty()){
            int i = set.choose();
            aux.add(i);
            set.remove(i);
        }
        while(!aux.isEmpty()){
            int j = aux.choose();
            set.add(j);
            aux2.add(j);
            aux.remove(j);
        }
        return aux2;
    }
    public static void print(IQueue queue) {
        while (!queue.isEmpty()) {
            System.out.println(queue.getFirst());
            queue.remove();
        }
    }
    public static void print(IStack stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.getTop());
            stack.remove();
        }
    }


    public static void Invertir(IStack stack){
        IQueue aux = new Queue();
        while(!stack.isEmpty()){
            aux.add(stack.getTop());
            stack.remove();
        }
        while(!aux.isEmpty()){
            System.out.println(aux.getFirst());
            stack.add(aux.getFirst());
            aux.remove();
        }
    }
    public static void main(String[] args) {
        ISet set = new Set();
        set.add(1);
        set.add(2);
        set.add(3);

//        IStack stack = new Stack();
//        stack.add(1);
//        stack.add(2);
//        stack.add(3);
//        Invertir(stack);
    }
}
