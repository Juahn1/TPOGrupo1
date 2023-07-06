package org.adt.core.adt.utils;
import org.adt.core.adt.implementation.normal.Set;

public class Montecarlo {
    private Set almacenar;

    private int count = 0;

    public Montecarlo() {
        almacenar = new Set();
    }

    public boolean verificar(int xPos, int yPos, int cuadradaX, int cuadradaY) {
        if (cuadradaX < xPos || cuadradaY < yPos) {
            System.out.println("Las coordenadas dadas están fuera del rango del cuadrante");
            return false;
        } else {
            return true;
        }
    }

    public Set colaCoordenadas(int x, int y) {
        this.almacenar.add(x);
        this.almacenar.add(y);
        return this.almacenar;
    }

    public double aproximarPi(int n) {
        int numPointsInsideCircle = 0;
        int numPointsTotal=0;
        for (int i = 0; i < n; i++) {
            double x = TPOPunto5.randomSetX().choose();
            double y = TPOPunto5.randomSetY().choose();
            /*double x = this.almacenar.choose();
            double y = this.almacenar.choose();*/
            if (estaEnCiruclo(x, y)) {
                numPointsInsideCircle++;
            }

            numPointsTotal++;
        }

        double pi = 4.0 * (double) numPointsInsideCircle / (double) numPointsTotal;
        return pi;
    }

    private static boolean estaEnCiruclo(double x, double y) {
        double distance = Math.sqrt(x * x + y * y);
        return distance <= 1000;
    }
}
