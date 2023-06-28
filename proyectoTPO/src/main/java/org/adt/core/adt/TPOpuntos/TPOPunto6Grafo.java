package org.adt.core.adt.utils;

public class TPOPunto6Grafo {
    private static GraphPunto6 grafoAleatorio;

    private static double random;

    public static void addNodo(int n){
        int i;
        for(i=0; i<=n; i++){
            grafoAleatorio.addNode(i);
        }
    }
    public static void addArista(int n){
        int i;
        for(i=0; i<n; i++) {
            random= Math.random();
            if(random==0){
                return;
            }
            grafoAleatorio.addEdge(i, i + 1, random);
        }
    }

    public static void main(String[] args) {
        int i=0;
        int n=10; //n maximo es 100 por que en GraphPunto6, el MAX_NODES esta en 100, pero se puede cambiar
        grafoAleatorio = new GraphPunto6();
        addNodo(n);
        addArista(n);
        if(random==0){
            System.out.println("No se puede agregar una probebilidad que sea 0 (Cero)");
            }
            else {
                while(grafoAleatorio.edgeExists(i,i+1)){
                    System.out.println("la probabilidad de la arista del nodo " + i + " a " + (i+1) + " es: " + grafoAleatorio.weight(i, i+1));
                    i++;
                }
            }

    }

}

