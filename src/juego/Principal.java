package juego;

import jugadores.VectorJugador;
import tablero.Tablero;

public class Principal {
    
    public static void main(String[] args) {
        Principal principal = new Principal();
    }

    //Atributos
    private VectorJugador jugadores = new VectorJugador();
    private Tablero tablero = new Tablero();

    public Principal(){
        tablero.pintarTablero();
    }


}
