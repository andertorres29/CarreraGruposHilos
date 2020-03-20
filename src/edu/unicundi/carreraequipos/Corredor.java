package edu.unicundi.carreraequipos;

/**
 * Esta clase CORREDOR heredara del la clase HILOS y se encargara de enviar los
 * parametros para cada corredor, validara el obj para dara orden a los hilos y 
 * por ultimo utilizara el metodo que permitira calcular y avanzar las posiciones.
 *
 * @author Anderson Torres Q.
 * @author ayesidtorres@unicundi.edu.co
 * @version 1.0
 */
import java.util.logging.Level;
import java.util.logging.Logger;

//Inicio clase corredor
public class Corredor extends Thread {
    
    //Inicio variables para pintar salida
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    //Creo variables de la clase para constructor
    private int id;
    private String nombre;
    private int minimo;
    private int maximo;
    private ObjetoComun obj;
    private Grupo gru;
    private Grupo grupo;

    //Creo variables de operabilidad
    private static int cont = 1;
    private int distancia = 0;
    private String equipoUno;
    private String equipoDos;
    private String equipoTres;

    //Constructor Vacio
    public Corredor() {

    }

    //Constructor con parametros
    public Corredor(int id, String nombre, int minimo, int maximo, Grupo grupo, ObjetoComun obj) {
        this.id = id;
        this.nombre = nombre;
        this.minimo = minimo;
        this.maximo = maximo;
        this.grupo = grupo;
        this.obj = obj;
    }
    
    //Sobrescribo metodo RUN para arrancar hilos
    @Override
    public void run() {
        if (minimo == 0) {
            while (true) {
                int posActual = avanzar(1);
                if (posActual >= 100) {
                    grupo.setPosicionA(100);
                    synchronized (grupo) {
                        grupo.notifyAll();
                        minimo = 100;
                        cont++;
                    }
                    break;
                }
            }
        } else {
            synchronized (grupo) {
                try {
                    grupo.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (minimo == 100) {
            while (true) {
                int pasoActual = avanzar(2);
                if (pasoActual >= 200) {
                    grupo.setPosicionB(200);
                    synchronized (grupo) {
                        grupo.notify();
                        cont++;
                    }
                    break;
                }
            }
        } else {
            synchronized (grupo) {
                try {
                    grupo.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        if (minimo == 200) {
            while (true) {
                int pasoActual = avanzar(3);
                if (pasoActual >= 300) {
                    grupo.setPosicionC(300);
                    System.out.println(ANSI_RED+"!!!!!! :D Grupo corredor ganador: "+ grupo.getId());
                    System.out.println(ANSI_RED+"FIN DE LA CARRERA GRACIAS POR PARTICIPAR.");
                    System.exit(0);
                    break;
                }
            }
        } else {
            synchronized (grupo) {
                try {
                    grupo.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    //Metodo que retorna el numero de posiciones que avanzara el jugador
    public static int lanzarPosicion() {
        System.out.println("");
        double i = Math.random() * 100;
        int k = (int) i;
        if (k < 25) {
            k = 0;
        } else if (k >= 25 && k < 50) {
            k = 1;
        } else if (k >= 50 && k < 75) {
            k = 2;
        } else if (k >= 75) {
            k = 3;
        }
        return k;
    }

    //Metodo que inidica las posiciones a avanzar por participante
    public int avanzar(int estadoPos) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
        }
        int valorAvance = lanzarPosicion();
        if (estadoPos == 1) {
            grupo.setPosicionA(grupo.getPosicionA() + valorAvance);
            if (grupo.mostrar().contains("1")) {
                equipoUno = grupo.mostrar();
            } else if (grupo.mostrar().contains("2")) {
                equipoTres = grupo.mostrar();
            } else if (grupo.mostrar().contains("3")) {
                equipoDos = grupo.mostrar();
            }
            if (equipoUno != null) {
                System.out.println(equipoUno);
            }
            if (equipoDos != null) {
                System.out.println(equipoDos);
            }
            if (equipoTres != null) {
                System.out.println(equipoTres);
            }
            return grupo.getPosicionA();
        }
        if (estadoPos == 2) {
            grupo.setPosicionB(grupo.getPosicionB() + valorAvance);
            if (grupo.mostrar().contains("1")) {
                equipoUno = grupo.mostrar();
            } else if (grupo.mostrar().contains("2")) {
                equipoTres = grupo.mostrar();
            } else if (grupo.mostrar().contains("3")) {
                equipoDos = grupo.mostrar();
            }
            if (equipoUno != null) {
                System.out.println(equipoUno);
            }
            if (equipoDos != null) {
                System.out.println(equipoDos);
            }
            if (equipoTres != null) {
                System.out.println(equipoTres);
            }
            return grupo.getPosicionB();
        }
        if (estadoPos == 3) {
            grupo.setPosicionC(grupo.getPosicionC() + valorAvance);
            if (grupo.mostrar().contains("1")) {
                equipoUno = grupo.mostrar();
            } else if (grupo.mostrar().contains("2")) {
                equipoTres = grupo.mostrar();
            } else if (grupo.mostrar().contains("3")) {
                equipoDos = grupo.mostrar();
            }
            if (equipoUno != null) {
                System.out.println(equipoUno);
            }
            if (equipoDos != null) {
                System.out.println(equipoDos);
            }
            if (equipoTres != null) {
                System.out.println(equipoTres);
            }
            return grupo.getPosicionC();
        }
        return 0;
    }
}

