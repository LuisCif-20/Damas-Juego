package src.juego;

import java.util.*;
import src.jugadores.VectorJugador;
import src.tablero.Celda;
import src.tablero.Tablero;

public class Principal {

    public static void main(String[] args) {
        Principal principal = new Principal();
    }

    Scanner scanner = new Scanner(System.in);
    private VectorJugador jugadores = new VectorJugador();
    private Tablero tablero = new Tablero();
    private Celda celda = new Celda();

    public Principal() {
        int menu;
        do {
            System.out.println("\nDamas Chinas\n");
            System.out.println("¿Qué deseas hacer");
            System.out.println("1) Jugar");
            System.out.println("2) Ver Tablero");
            System.out.println("3) Ver posicion de fichas");
            System.out.println("4) Mostrar Jugadores");
            System.out.println("5) Mostrar visualizacion de Partida");
            System.out.println("6) Reportes");
            System.out.println("7) Salir\n");
            menu = Integer.parseInt(scanner.nextLine());
            if (menu == 1) {
                System.out.println("Aun no esta disponible esta opcion");
            } else if (menu == 2) {
                tablero.pintarTableroDamas();
                //tablero.pintarTablero();
            } else if (menu == 3) {
                tablero.llenarTablero();
                tablero.imprimirTablero();
            } else if (menu == 4) {
                jugadores.mostrarJugadores();
            } else if (menu == 5) {
                jugadores.escogerPrimerJugador();
                jugadores.escogerSegundoJugador();
                tablero.llenarTablero();
            } else if (menu == 6) {
                System.out.println("Esta opcion aun no esta lista");
            } else {
                System.out.println("Hasta Pronto");
            }
        } while (menu >= 1 & menu <= 6);

    }

}
