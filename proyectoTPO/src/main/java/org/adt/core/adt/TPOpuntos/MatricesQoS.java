package org.adt.core.adt.TPOpuntos;

import org.adt.core.adt.definition.IStack;
import org.adt.core.adt.implementation.normal.Stack;

public class MatricesQoS {
    public static int pop(IStack a) {
        int x = a.getTop();
        a.remove();
        return x;
    }

        public static int[][] crearMatrizDesdeColaDePilas(QueueOfStacks qos) {
        int dimension = 3;
        int[][] matriz = new int[dimension][dimension];

        int fila = 0;
        int columna = 0;

        while (!qos.isEmpty() && fila < dimension) {
            IStack pila = qos.getFirst();
            columna = 0;

            while (!pila.isEmpty() && columna < dimension) {
                matriz[columna][fila] = pop(pila);
                columna++;
            }
            qos.remove();
            fila++;
        }

        return matriz;
    }
    public static void imprimirMatriz(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }}
    public static void printQos(QueueOfStacks a) {
        QueueOfStacks aux = new QueueOfStacks();
        while (!a.isEmpty()) {

            aux.add(a.getFirst());
            print(a.getFirst());
            a.remove();
        }
        while (!aux.isEmpty()) {
            a.add(aux.getFirst());
            aux.remove();
        }
    }
    public static void print(IStack stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.getTop());
            stack.remove();
        }
        System.out.println("-");
    }
    public static void main(String[] args) {
        //pruebas
        IStack stack = new Stack();
        stack.add(1);
        stack.add(2);
        stack.add(3);

        IStack stack2 = new Stack();
        stack2.add(10);
        stack2.add(20);
        stack2.add(30);

        IStack stack3 = new Stack();
        stack3.add(100);
        stack3.add(200);
        stack3.add(300);

        QueueOfStacks qos = new QueueOfStacks();
        qos.add(stack);
        qos.add(stack2);
        qos.add(stack3);


        int[][] matrix = crearMatrizDesdeColaDePilas(qos);
        imprimirMatriz(matrix);
    }
}

