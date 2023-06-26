package org.adt.core.adt.TPOpuntos;
import org.adt.core.adt.algorithms.*;
import org.adt.core.adt.definition.IPriorityQueue;
import org.adt.core.adt.definition.ISet;
import org.adt.core.adt.definition.IStack;
import org.adt.core.adt.implementation.normal.PriorityQueue;
import org.adt.core.adt.implementation.normal.Set;
import org.adt.core.adt.implementation.normal.Stack;

import static org.adt.core.adt.algorithms.StackAlgorithms.print;


public class Ejercicio2_5 {

    //punto 1 : . Dada una pila de elementos desordenados, generar una nueva pila sin elementos repetidos y ordenados
    // la complejidad computacional en este algoritmo seria O(N logN) ya que al momento de Si utilizas un conjunto para almacenar los elementos únicos de la pila,
    // recorrer la pila y agregar cada elemento al conjunto tendrá una complejidad de O(N), luego ordenar estos elementos en una cola con prioridad tendria coste O(N log N), sumado
    //a reconstruir la pila quedaria una suma de O(N)+O(N log N), lo que quedaria en O(N log N)
    public static IStack OrdenamientoPila(IStack pila){
        ISet auxset = new Set();
        IPriorityQueue auxpq = new PriorityQueue();
        while(!pila.isEmpty()){             //elimina repetidos  O(N)
            auxset.add(pila.getTop());
            pila.remove();
        }
        while(!auxset.isEmpty()){           //ordena con cola con prioridad O(N log N)
            int i = auxset.choose();
            auxpq.add(i,i);
            auxset.remove(i);
        }
        while(!auxpq.isEmpty()){            //Reconstruye la pila O(N)
            pila.add(auxpq.getFirst());
            auxpq.remove();
        }
        return pila;
    }
    //punto 2 . Cree un diccionario que tenga como clave cada letra del alfabeto español, y como valor cada frecuencia
    //asociada. Cree una String en español de mas de 500 caracteres, y que tenga aplicado un cifrado César.
    //Desarrolle un algoritmo que desencripte la String en base a la frecuencia de sus caracteres.


    public static void main(String[] args) {
            //Caso de uso
        IStack pila = new Stack();
        pila.add(1);
        pila.add(1);
        pila.add(2);
        pila.add(3);
        pila.add(4);
        pila.add(4);
        pila.add(4);
        pila.add(5);
        print(OrdenamientoPila(pila));
        System.out.println("-");
        System.out.println();





    }
}
