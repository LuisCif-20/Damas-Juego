package src.jugadores;

import java.util.Random;


public class VectorJugador {

    //Atributos
    private Random aleatorio = new Random();
    private PiedraPapelTijera jugar = new PiedraPapelTijera();
    private int limite = 10;
    private Jugador[] jugadores = new Jugador[limite];
    private int[] victorias = new int[limite];
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
        jugadores[0] = new Jugador(1, "Sparky");
        jugadores[1] = new Jugador(2, "Wolf");
        jugadores[2] = new Jugador(3, "Shulk");
        jugadores[3] = new Jugador(4, "Midna");
        jugadores[4] = new Jugador(5, "Byleth");
        jugadores[5] = new Jugador(6, "Robin");
        jugadores[6] = new Jugador(7, "Cletus");
        jugadores[7] = new Jugador(8, "Crash");
        jugadores[8] = new Jugador(9, "KBOOM");
        jugadores[9] = new Jugador(10, "KlintX");
    }

    public void escogerPrimerJugador(){
        int seleccion = aleatorio.nextInt(10);
        jugador1seleccionado = seleccion;
        System.out.println("El primer jugador seleccionado es el: " + jugadores[jugador1seleccionado].getInformacion());
    }

    public void escogerSegundoJugador(){
        int seleccion;
        do {
            seleccion = aleatorio.nextInt(10);
        } while (seleccion == jugador1seleccionado);
        jugador2seleccionado = seleccion;
        System.out.println("El segundo jugador seleccionado es el: " + jugadores[jugador2seleccionado].getInformacion());
    }

    public void mostrarJugadores(){
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println(jugadores[i].getInformacion());
        }
    }

    public void mostrarJugadoresVictorias(){
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println(jugadores[i].getInformacion() + " Ha ganado: " + victorias[i] + " veces");
        }
    }

    public int buscarBlancas(){
        if (jugadores[jugador1seleccionado].getColor().equals("Juega Blancas")) {
            return jugador1seleccionado;
        } else if (jugadores[jugador2seleccionado].getColor().equals("Juega Blancas")) {
            return jugador2seleccionado;
        }
        return 0;
    }

    public int buscarNegras(){
        if (jugadores[jugador1seleccionado].getColor().equals("Juega Negras")) {
            return jugador1seleccionado;
        } else if (jugadores[jugador2seleccionado].getColor().equals("Juega Negras")) {
            return jugador2seleccionado;
        }
        return 0;
    }

    public void mostrarColores(){
        if (jugar.competir() == 1) {
            jugadores[jugador1seleccionado].setColor("Juega Blancas");
            jugadores[jugador2seleccionado].setColor("Juega Negras");
        } else {
            jugadores[jugador1seleccionado].setColor("Juega Negras");
            jugadores[jugador2seleccionado].setColor("Juega Blancas");
        }
    }

    public void mostrarjugadoresSeleccionados(){
        System.out.println(jugadores[jugador1seleccionado].getInformacion());
        System.out.println(jugadores[jugador2seleccionado].getInformacion());
    }

    public void mostrarVictorias(int incrementar){
        victorias[incrementar]++;
    }

    public void ordenarPuntos(){
        for (int i = 1; i < jugadores.length -1; i++) {
            for (int j = 0; j < jugadores.length -1 - i; j++) {
                if (victorias[j] < victorias[j+1]) {
                    Jugador aux1 = jugadores[j];
                    jugadores[j] = jugadores[j+1];
                    jugadores[j+1] = aux1;
                    int aux = victorias[j];
                    victorias[j] = victorias[j+1];
                    victorias[j+1] = aux;

                }
            }
        }
    }

    //Geter y Setter
    public void setearColores(String player1, String player2){
        jugadores[jugador1seleccionado].setColor(player1);
        jugadores[jugador2seleccionado].setColor(player2);
    }

    public int getJugador1seleccionado() {
        return jugador1seleccionado;
    }

    public int getJugador2seleccionado() {
        return jugador2seleccionado;
    }
    
    
}
