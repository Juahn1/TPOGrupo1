package org.adt.core.adt.utils;

import org.adt.core.adt.definition.ISet;
import org.adt.core.adt.implementation.normal.Set;

import java.util.Random;

public class TPOPunto5 {
    private final static int MIN = 0;
    private final static int MAX = 1000;
    private final static int TOTAL = 1000;

    private static ISet setX = new Set();
    private static ISet setY = new Set();

    private static int randomInteger() {

        return (new Random()).nextInt(MIN, MAX);
    }
    /*public static ISet randomSet() {
        ISet set= new Set();
        for (int i = 0; i < TOTAL; i++) {
            set.add(randomInteger());
        }
        return set;
    }*/
    public static ISet randomSetX() {
        ISet set= new Set();
        for (int i = 0; i < TOTAL; i++) {
            set.add(randomInteger());
        }
        return set;
    }
    public static ISet randomSetY() {
        ISet set= new Set();
        for (int i = 0; i < TOTAL; i++) {
            set.add(randomInteger());
        }
        return set;
    }

    public static void main(String[] args) {
        Montecarlo montecarlo = new Montecarlo();
        CoordenadaEnPlano coordenada = new CoordenadaEnPlano();
        coordenada.setX(77);
        coordenada.setY(32);
        setX.add(coordenada.getX()); //Cambiar el setX y setY a set si no anda
        setY.add(coordenada.getY());
        setX = randomSetX();
        setY =randomSetY();
        double pi;
        if(coordenada.regiónCuadrada(1000,1000)) {
            while (!setX.isEmpty() && !setY.isEmpty()) {
                int randomX = setX.choose();
                int randomY = setY.choose();
                if (montecarlo.verificar(randomX, randomY, 1000, 1000)) {
                    montecarlo.colaCoordenadas(randomX, randomY);
                }
                setX.remove(randomX);
                setY.remove(randomY);
            }
            pi = montecarlo.aproximarPi(1000);
            System.out.println("La aproximación de pi es:" + " " + pi);
        }
    }
}
