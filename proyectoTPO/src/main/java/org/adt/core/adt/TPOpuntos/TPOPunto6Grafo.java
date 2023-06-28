package org.adt.core.adt.utils;

public class TPOPunto6Grafo {
    private static GraphPunto6 grafoAleatorio;

    private static double random;

    //private final static int TOTAL = 10;

    /*public static void addNodo(int n){
        int i;
        for(i=0; i<=n; i++){
            grafoAleatorio.addNode(i);
        }
    }
    public static void addArista(int n){
        int i;
        random= Math.random();
        for(i=0; i<n; i++) {
            if(random==0){
                return;
            }
            grafoAleatorio.addEdge(i, i + 1, random);
        }
    }

    public static void printGrafo(){
        int i=0;
        int i2=1;
        while(!grafoAleatorio.edgeExists(i,i2)){
            System.out.println("la probabilidad de la arista es:" + " " + grafoAleatorio.weight(i,i2));
            i++;
            i2++;
        }
    }*/



    public static void main(String[] args) {
        int i=0;
        grafoAleatorio = new GraphPunto6();
        grafoAleatorio.addNode(1);
        grafoAleatorio.addNode(2);
        grafoAleatorio.addNode(3);
        grafoAleatorio.addNode(4);
        grafoAleatorio.addNode(5);
        random = Math.random();
        if(random==0){

            }
            else {
                grafoAleatorio.addEdge(1, 2, random);
                System.out.println("la probabilidad de la arista es:" + " " + grafoAleatorio.weight(1, 2));
            }

    }
        /*addNodo(10);
        addArista(10);
        printGrafo();*/

}

