package src.juego;

import src.tablero.*;
import java.util.*;

import src.tablero.Celda;

public class Juego {

    private Scanner scan = new Scanner(System.in);
    private Tablero tablero2 = new Tablero();
    private Celda celda = new Celda();
    private int fichascomidas1;
    private int fichascomidas2;
    private int columna;
    private int fila;
    private int columnamv;
    private int filamv;

    public Juego(Tablero tablero2) {
        this.tablero2 = tablero2;
        fichascomidas1 = 12;
        fichascomidas2 = 12;
    }

    public void moverFichas() {
        int turno = 1;
        System.out.println("Turno de blancas");
        do {
            tablero2.imprimirTablero();
            int retorno = SecuenciaJuego(turno);
            if (retorno == 1) {
                System.out.println("Perdiste tu turno");
            } else if (retorno == 4 & turno == 1) {
                String aux = tablero2.getCelda(columna, fila);
                tablero2.setCambio(columna, fila, celda.pintarCeldas(false));
                tablero2.setCambio(columnamv, filamv, aux);
                fichascomidas2--;
            } else if (retorno == 4 & turno == 2) {
                String aux = tablero2.getCelda(columna, fila);
                tablero2.setCambio(columna, fila, celda.pintarCeldas(false));
                tablero2.setCambio(columnamv, filamv, aux);
                fichascomidas1--;
            } else if (retorno == 2 & turno == 1) {
                String aux = tablero2.getCelda(columna, fila);
                tablero2.setCambio(columna, fila, celda.pintarCeldas(false));
                tablero2.setCambio(columnamv, filamv, aux);
            } else if (retorno == 2 & turno == 2) {
                String aux = tablero2.getCelda(columna, fila);
                tablero2.setCambio(columna, fila, celda.pintarCeldas(false));
                tablero2.setCambio(columnamv, filamv, aux);
            }
            if (turno == 1) {
                System.out.println("Turno de negras");
                turno = 2;
            } else {
                System.out.println("Turno de blancas");
                turno = 1;
            }
        } while (fichascomidas1 != 0 || fichascomidas2 != 0);
    }

    public int SecuenciaJuego(int num) {
        System.out.println("Ingresa el numero de columna y fila donde se encuentra la ficha a mover");
        columna = Integer.parseInt(scan.nextLine());
        fila = Integer.parseInt(scan.nextLine());
        if (verificar(columna, fila)) {
            if (verificarFicha(columna, fila)) {
                System.out.println("Ingrese el numero de columna y fila a donde desea mover la ficha");
                columnamv = Integer.parseInt(scan.nextLine());
                filamv = Integer.parseInt(scan.nextLine());
                if (verificar(columnamv, filamv)) {
                    if (num == 1) {
                        if (verificarmovimientoBlancas(columna, fila, columnamv, filamv)) {
                            return 2;
                        } else {
                            return 4;
                        }
                    } else {
                        if (verificarMovimientoNegras(columna, fila, columnamv, filamv)) {
                            return 2;
                        } else {
                            return 4;
                        }
                    }

                }
                return 1;
            }
            return 1;
        }
        return 1;

    }

    public boolean verificar(int columna, int fila) {
        if (columna < 0 | columna > 7) {
            System.err.println("La columna no existe");
            return false;
        } else if (fila < 0 | fila > 7) {
            System.out.println("La fila no existe");
            return false;
        }
        return true;
    }

    public boolean verificarFicha(int columna, int fila) {
        if (tablero2.getCelda(columna, fila).equals(celda.pintarCeldaFicha(true))) {
            return true;
        } else if (tablero2.getCelda(columna, fila).equals(celda.pintarCeldaFicha(false))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verificarmovimientoBlancas(int columna, int fila, int columnamv, int filamv) {
        if (fila == 0) {
            if (filamv == fila+2) {
                return verificarFichaParaComerBlanca(columna, fila, columnamv, filamv);
            } else if (filamv == fila+1){
                return true;
            }
        } else if (fila == 7) {
            if (filamv == fila-2) {
                return verificarFichaParaComerBlanca(columna, fila, columnamv, filamv);
            } else if (filamv == fila-1){
                return true;
            }
        } else if (fila >0 & fila < 7 ) {
            if (filamv == fila-2 || filamv == fila+2) {
                return verificarFichaParaComerBlanca(columna, fila, columnamv, filamv);
            } else if (filamv == fila-1){
                return true;
            }
        }
        return false;
    }

    public boolean verificarMovimientoNegras(int columna, int fila, int columnamv, int filamv) {
        if (fila == 0 ) {
            if (filamv == fila+2) {
                return verificarFichaParaComerNEgra(columna, fila, columnamv, filamv);
            } else if (filamv == fila+1){
                return true;
            }
        } else if (fila == 7 ) {
            if (filamv == fila-2) {
                return verificarFichaParaComerNEgra(columna, fila, columnamv, filamv);
            } else if (filamv == fila-1){
                return true;
            }
        } else if (fila >0 & fila < 7 ) {
            if (filamv == fila-2 || filamv == fila+2) {
                return verificarFichaParaComerNEgra(columna, fila, columnamv, filamv);
            } else if (filamv == fila-1){
                return true;
            }
        }
        return false;
    }

    public boolean verificarFichaParaComerBlanca(int columna, int fila, int columnamv, int filamv) {
        if (fila == 0 | fila == 1) {
            if (tablero2.getCelda(columna + 1, fila + 1).equals(celda.pintarCeldaFicha(false))) {
                tablero2.setCambio(columna + 1, fila + 1, celda.pintarCeldas(false));
                fichascomidas2--;
                return false;
            }
        } else if (fila == 7 | fila ==6){
            if (tablero2.getCelda(columna + 1, fila - 1).equals(celda.pintarCeldaFicha(false))) {
                tablero2.setCambio(columna + 1, fila - 1, celda.pintarCeldas(false));
                fichascomidas2--;
                return false;
            }
        } else if (fila > 1 & fila < 6){
            if (tablero2.getCelda(columna + 1, fila + 1).equals(celda.pintarCeldaFicha(false))) {
                tablero2.setCambio(columna + 1, fila + 1, celda.pintarCeldas(false));
                fichascomidas2--;
                return false;
            } else if (tablero2.getCelda(columna + 1, fila - 1).equals(celda.pintarCeldaFicha(false))) {
                tablero2.setCambio(columna + 1, fila - 1, celda.pintarCeldas(false));
                fichascomidas2--;
                return false;
            }
        }
        return true;
    }

    public boolean verificarFichaParaComerNEgra(int columna, int fila, int columnamv, int filamv) {
        if (fila == 0 | fila == 1) {
            if (tablero2.getCelda(columna - 1, fila + 1).equals(celda.pintarCeldaFicha(true))) {
                tablero2.setCambio(columna - 1, fila + 1, celda.pintarCeldas(false));
                fichascomidas1--;
                return false;
            }
        } else if (fila == 7 | fila == 6){
            if (tablero2.getCelda(columna - 1, fila - 1).equals(celda.pintarCeldaFicha(true))) {
                tablero2.setCambio(columna - 1, fila - 1, celda.pintarCeldas(false));
                fichascomidas1--;
                return false;
            }
        } else if (fila > 1 & fila < 6){
            if (tablero2.getCelda(columna - 1, fila + 1).equals(celda.pintarCeldaFicha(true))) {
                tablero2.setCambio(columna - 1, fila + 1, celda.pintarCeldas(false));
                fichascomidas1--;
                return false;
            } else if (tablero2.getCelda(columna - 1, fila - 1).equals(celda.pintarCeldaFicha(true))) {
                tablero2.setCambio(columna - 1, fila - 1, celda.pintarCeldas(false));
                fichascomidas1--;
                return false;
            }
        }
        return true;
    }
}
