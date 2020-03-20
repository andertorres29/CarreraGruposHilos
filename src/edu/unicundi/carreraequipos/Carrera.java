package edu.unicundi.carreraequipos;

/**
 * Esta clase CARRERA creara los 3 grupos y con estos grupos los 3 participantes
 * de cada grupo, tambien inicia todos los hilos participantes.
 *
 * @author Anderson Torres Q.
 * @author ayesidtorres@unicundi.edu.co
 * @version 1.0
 */
//Metodo Carrera 
public class Carrera {
    //Metodo que crea y llama todos los hilos
    public void cargar() {
        ObjetoComun obj = new ObjetoComun();
        Grupo gru = new Grupo();
        //Se crean los grupos y los corredores del grupo 1
        Grupo grupo1 = new Grupo("1", 0, 300);
        Corredor Corredor1 = new Corredor(1, "Camilo", 0, 100, grupo1, obj);
        Corredor Corredor4 = new Corredor(1, "Andres", 100, 200, grupo1, obj);
        Corredor Corredor7 = new Corredor(1, "Juan", 200, 300, grupo1, obj);
        //Se crean los grupos y los corredores del grupo 2  
        Grupo grupo2 = new Grupo("2", 0, 300);
        Corredor Corredor2 = new Corredor(2, "Roberto", 0, 100, grupo2, obj);
        Corredor Corredor5 = new Corredor(2, "David", 100, 200, grupo2, obj);
        Corredor Corredor8 = new Corredor(2, "Ivan", 200, 300, grupo2, obj);
        //Se crean los grupos y los corredores del grupo 3
        Grupo grupo3 = new Grupo("3", 0, 300);
        Corredor Corredor3 = new Corredor(3, "Nicolas", 0, 100, grupo3, obj);
        Corredor Corredor6 = new Corredor(3, "Stiven", 100, 200, grupo3, obj);
        Corredor Corredor9 = new Corredor(3, "Maicol", 200, 300, grupo3, obj);

        //Inicio Hilos
        Corredor1.start();
        Corredor2.start();
        Corredor3.start();
        Corredor4.start();
        Corredor5.start();
        Corredor6.start();
        Corredor7.start();
        Corredor8.start();
        Corredor9.start();
    }
}
