package edu.unicundi.carreraequipos;

/**
 * Esta clase GRUPO se encarga de indicar la distancia a correr por los participantes,
 * posee metodos set y get y pinta la salida por consola.
 *
 * @author Anderson Torres Q.
 * @author ayesidtorres@unicundi.edu.co
 * @version 1.0
 */

public class Grupo {
    //Defino contantes para pintar salida
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    
    //Creo variables de la clase para el constructor
    private String id;
    private int minimo;
    private int maximo;

    //Creo variables de operabilidad
    private int posicionA;
    private int posicionB;
    private int posicionC;

    //Constructor vacio
    public Grupo() {

    }

    //Constructor con parametros
    public Grupo(String id, int minimo, int maximo) {
        this.id = id;
        this.minimo = minimo;
        this.maximo = maximo;
        this.posicionA = 0;
        this.posicionB = 100;
        this.posicionC = 200;
    }
    
    //Metodo get del nombre del grupo
    public String getId() {
        return id;
    }
    //Metodo set del nombre del grupo
    public void setId(String id) {
        this.id = id;
    }

    //Metodo get de la posicion minima
    public int getMinimo() {
        return minimo;
    }

    //Metodo set de la posicion minima
    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }
    
    //Metodo get de la posicion maxima
    public int getMaximo() {
        return maximo;
    }

    //Metodo set de la posicion maxima
    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    //Metodo get de la posicion para 1
    public int getPosicionA() {
        return posicionA;
    }

    //Metodo set para la posicion para 1
    public void setPosicionA(int posicionA) {
        this.posicionA = posicionA;
    }

    //Metodo get para la posicion para 2
    public int getPosicionB() {
        return posicionB;
    }
    
    //Metodo set para la posicion para 2
    public void setPosicionB(int posicionB) {
        this.posicionB = posicionB;
    }

    //Metodo get para la posicion para 3
    public int getPosicionC() {
        return posicionC;
    }

    //Metodo set para la posicion para 3
    public void setPosicionC(int posicionC) {
        this.posicionC = posicionC;
    }
    
    //Metodo que imprime la posicion del corredor
    public synchronized String mostrar() {
        String camino = "Grupo corredor numero: "+id+" ";
        for (int i = minimo; i <= maximo; i++) {
            if (i == posicionA) {
                camino += ANSI_GREEN_BACKGROUND + ANSI_PURPLE + "X_X";
            } else if (i == posicionB) {
                camino += ANSI_YELLOW_BACKGROUND + ANSI_PURPLE + "Y_Y";
            } else if (i == posicionC) {
                camino += ANSI_BLUE_BACKGROUND + ANSI_PURPLE + "Z_Z";
            } else {
                camino += "--";
            }
        } return camino;    
    }
}
