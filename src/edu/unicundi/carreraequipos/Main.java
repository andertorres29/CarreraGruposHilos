package edu.unicundi.carreraequipos;

/**
 * Esta clase MAIN es la clase principal del programa
 *
 * @author Anderson Torres Q.
 * @author ayesidtorres@unicundi.edu.co
 * @version 1.0
 */

//Inicia clase principal
public class Main {
    
    //Inicio variables para pintar salida
    public static final String ANSI_RED = "\u001B[31m";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(ANSI_RED+"INICIA CARRERA DE 300 METROS");
        System.out.println("");
        System.out.println(ANSI_RED+"Preparados ... Listo ... YAAAAAAA!!");
        Carrera c1 = new Carrera();
        c1.cargar();
    }

}

