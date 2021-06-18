package jugadores;

import java.util.Random;

public class VectorJugador {

    //Atributos
    private Random aleatorio = new Random();
    private int limite = 5;
    private Jugador[] jugadores = new Jugador[limite];
    private int jugador1seleccionado;
    private int jugador2seleccionado;

    //Cosntructores
    public VectorJugador(){
        jugador1seleccionado = -1;
        jugador2seleccionado = -1;
        llenarClientes();
    }

    //Metodos
    public void llenarClientes(){
        jugadores[0] = new Jugador(01, "Sparky");
        jugadores[1] = new Jugador(02, "Wolf");
        jugadores[2] = new Jugador(03, "Shulk");
        jugadores[3] = new Jugador(04, "Midna");
        jugadores[4] = new Jugador(05, "Byleth");
    }

    public void escogerPrimerJugador(){
        int seleccion = aleatorio.nextInt(5);
        jugador1seleccionado = seleccion;
        System.out.print("El primer jugador seleccionado es el: ");
        jugadores[jugador1seleccionado].getInformacion();
    }

    public void escogerSegundoJugador(){
        int seleccion;
        do {
            seleccion = aleatorio.nextInt(5);
        } while (seleccion == jugador1seleccionado);
        jugador2seleccionado = seleccion;
        System.out.print("El segundo jugador seleccionado es el: ");
        jugadores[jugador2seleccionado].getInformacion();
    }

    public void mostrarJugadores(){
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println(jugadores[i].getInformacion());
        }
    }

    //Geter y Setter
    public int getJugador1seleccionado() {
        return jugador1seleccionado;
    }

    public int getJugador2seleccionado() {
        return jugador2seleccionado;
    }
    
    
}
