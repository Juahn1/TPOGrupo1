package org.adt.core.adt.utils;

import org.adt.core.adt.definition.IQueue;

public class Punto2_2Generico {
    /*
     * 1 Desarrolle una función que reciba un Stack genérico e invierta sus elementos.
     *
     * 2 Desarrolle una función que copie un Set genérico
     */
    public static <T>SetGenerico <T>copySet(SetGenerico set){
        SetGenerico<T> aux = new SetGenerico();
        SetGenerico<T> aux2 = new SetGenerico();
        while(!set.isEmpty()){
            T i = (T) set.choose();
            aux.add(i);
            set.remove(i);
        }
        while(!aux.isEmpty()){
            T j = (T) aux.choose();
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
    public static void print(StackGenerico stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.getTop());
            stack.remove();
        }
    }


    public static void Invertir(StackGenerico stack){
        QueueGenerico aux = new QueueGenerico();
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
        SetGenerico set = new SetGenerico();
        SetGenerico setCopia = new SetGenerico();
        set.add(1);
        set.add(2);
        set.add(3);
        setCopia = copySet(set);


        StackGenerico stack = new StackGenerico();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        Invertir(stack);
        System.out.println("");
        print(stack);
    }
}
