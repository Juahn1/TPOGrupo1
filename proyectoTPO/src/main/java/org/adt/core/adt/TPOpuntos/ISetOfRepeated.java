package org.adt.core.adt.TPOpuntos;

public interface ISetOfRepeated {
    /**
     * Postcondicion: Agrega un valor al conjunto.
     *
     * @param a valor a agregar.
     * @param b cantidad a agregar.
     */
    void add(int a,int b);

    /**
     * Postcondicion: Quita el uno de la cantidad del elemento indicado si existe, de lo contrario no hace nada.
     *
     * @param a valor a quitar.
     */
    void remove(int a);

    /**
     * @return <code>true</code> si es el conjunto vacio, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     * @return Devuelve el un elemento del conjunto.
     */
    int choose();
}
