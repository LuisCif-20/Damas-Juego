package src.juego;

import src.jugadores.VectorJugador;
import src.tablero.Tablero;

public class Principal {

    public static void main(String[] args) {
        Principal principal = new Principal()
;    }

    private VectorJugador jugadores = new VectorJugador();
    private Tablero tablero = new Tablero();

    public Principal(){
        System.out.println("\nDamas Chinas\n");
        jugadores.escogerPrimerJugador();
        jugadores.escogerSegundoJugador();
        System.out.println("");
        tablero.pintarTablero();
    }

}
