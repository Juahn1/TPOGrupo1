package org.adt.core.adt.utils;

public class CoordenadaEnPlano {

    private int x;
    private int y;
    private int xPos;

    private int yPos;

    public CoordenadaEnPlano(){

    }

    public int getX() {
        return this.xPos;
    }

    public int getY() {
        return this.yPos;
    }

    public void setX(int x) {
        this.xPos = x;
    }

    public void setY(int y) {
        this.yPos = y;
    }

    public boolean regiónCuadrada(int x, int y){
        if(x % y != 0){
            System.out.println("Tiene que ser una región cuadrada");
            return false;
        }
        if (x<0 || y<0){
            System.out.println("Las coordenadas deben estar en el primer cuadrante(X e Y positivos)");
            return false;
        }
        if(xPos>x && yPos>y){
            System.out.println("Las coordenadas tienen que ser mayores a las inicialmente dadas");
            return false;
        }
        return true;
    }
}
