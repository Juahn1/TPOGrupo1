package org.adt.core.adt.TPOpuntos;

import org.adt.core.adt.definition.IStack;
import org.adt.core.adt.implementation.normal.Stack;

public class MatricesQoS {
    public static int pop(IStack a) {
        int x = a.getTop();
        a.remove();
        return x;
    }

    public static IStack poll(QueueOfStacks qos){
        IStack i = qos.getFirst();
        qos.remove();
        return i;
    }





        public static int[][] createMatrixFromQueueOfStacks(QueueOfStacks qos) {
            int rows =qos.getMax() ;
            int cols = qos.getMax();
            int[][] matrix = new int[rows][cols];

            int rowIndex = 0;
            while (!qos.isEmpty()) {
                IStack stack = poll(qos);
                int colIndex = 0;
                while (!stack.isEmpty()) {
                    matrix[colIndex][rowIndex] = pop(stack);
                    colIndex++;
                }
                rowIndex++;
            }

            return matrix;
        }


    public static int calcularTraza(QueueOfStacks qos) {
        int[][] matrix = createMatrixFromQueueOfStacks(qos);

        int traza = 0;
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            traza += matrix[i][i];
        }
        return traza;
    }

    public static void imprimirMatriz(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printQos(QueueOfStacks a) {
        QueueOfStacks aux = new QueueOfStacks(3);
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
    public static int[][] obtenerMatrizTraspuesta(QueueOfStacks qos) {
        int [][] matriz = createMatrixFromQueueOfStacks(qos);
        int filas = matriz.length;
        int columnas = matriz[0].length;

        int[][] matrizTraspuesta = new int[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizTraspuesta[j][i] = matriz[i][j];
            }
        }

        return matrizTraspuesta;
    }
    public static int[][] sumarMatrices(QueueOfStacks qos1,QueueOfStacks qos2 ) {
        int[][] matrizA = createMatrixFromQueueOfStacks(qos1);
        int[][] matrizB = createMatrixFromQueueOfStacks(qos2);
        int filas = matrizA.length;
        int columnas = matrizA[0].length;

        int[][] resultado = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }

        return resultado;
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
        IStack stack4 = new Stack();
        stack4.add(1);
        stack4.add(2);
        stack4.add(3);

        IStack stack5 = new Stack();
        stack5.add(10);
        stack5.add(20);
        stack5.add(30);

        IStack stack6 = new Stack();
        stack6.add(100);
        stack6.add(200);
        stack6.add(300);

        QueueOfStacks qos = new QueueOfStacks(3);
        qos.add(stack);
        qos.add(stack2);
        qos.add(stack3);

        QueueOfStacks qos2 = new QueueOfStacks(3);
        qos2.add(stack4);
        qos2.add(stack5);
        qos2.add(stack6);

        imprimirMatriz(sumarMatrices(qos,qos2));
        //printQos(qos);

        //imprimirMatriz(createMatrixFromQueueOfStacks(qos));

        //System.out.println(calcularTraza(qos));
//        System.out.println(calcularTraza(qos));

    }
}

