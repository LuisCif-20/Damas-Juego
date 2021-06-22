package src.juego;

import src.tablero.*;
import java.util.*;

import src.tablero.Celda;

public class Juego {

    private Scanner scan = new Scanner(System.in);
    private Tablero tablero2 = new Tablero();
    private Celda celda = new Celda();
    private int columna;
    private int fila;
    private int columnamv;
    private int filamv;

    public Juego(Tablero tablero2) {
        this.tablero2 = tablero2;
    }

    public boolean buscarFichasTablero(int num) {
        boolean bandera = false;
        if (num == 2) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (tablero2.getCelda(i, j).equals(celda.pintarCeldaFicha(true))) {
                        bandera = true;
                        break;
                    } 
                }
            }
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (tablero2.getCelda(i, j) .equals(celda.pintarCeldaFicha(false))) {
                        bandera = true;
                        break;
                    } 
                }
            } 
        }
        return bandera;
    }

    public int moverFichas() {
        boolean bandera = false;
        int turno = 1;
        do {
            if (turno == 1) {
                System.out.println("Turno de Blancas");
            } else {
                System.out.println("Turno de Negras");
            }
            tablero2.imprimirTablero();
            int retorno = SecuenciaJuego(turno);
            if (retorno == 1) {
                System.out.println("Perdiste tu turno");
            } else if (retorno == 4 & turno == 1) {
                String aux = tablero2.getCelda(columna, fila);
                tablero2.setCambio(columna, fila, celda.pintarCeldas(false));
                tablero2.setCambio(columnamv, filamv, aux);
                turno = 2;
            } else if (retorno == 4 & turno == 2) {
                String aux = tablero2.getCelda(columna, fila);
                tablero2.setCambio(columna, fila, celda.pintarCeldas(false));
                tablero2.setCambio(columnamv, filamv, aux);
                turno = 1;
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
               turno =2; 
            } else {
                turno =1;
            }
            bandera = buscarFichasTablero(turno);

        } while (bandera == true);
        if (turno == 1) {
            System.out.println("Ganaron Blancas");
            turno = 2;
        } else {
            System.out.println("Ganaron Negras");
            turno = 1;
        }
        return turno;
    }

    public int SecuenciaJuego(int num) {
        System.out.println("Ingresa el numero de columna y fila donde se encuentra la ficha a mover");
        columna = Integer.parseInt(scan.nextLine());
        fila = Integer.parseInt(scan.nextLine());
        if (verificar(columna, fila)) {
            if (verificarFicha(columna, fila)) {
                if (verificarMover() == 1) {
                    System.out.println("Ingrese el numero de columna y fila a donde desea mover la ficha");
                    columnamv = Integer.parseInt(scan.nextLine());
                    filamv = Integer.parseInt(scan.nextLine());
                    if (num == 1) {
                        if (verificarmovimientoBlancas(columna, fila, columnamv, filamv)) {
                            return 2;
                        }
                        return 1;
                    } else {
                        if (verificarMovimientoNegras(columna, fila, columnamv, filamv)) {
                            return 2;
                        }
                        return 1;
                    }
                } else {
                    System.out.println("Ingrese el numero de columna y fila a donde desea mover la ficha");
                    columnamv = Integer.parseInt(scan.nextLine());
                    filamv = Integer.parseInt(scan.nextLine());
                    if (num == 1) {
                        if (verificarFichaParaComerBlanca(columna, fila, columnamv, filamv)) {
                            return 4;
                        }
                        return 1;
                    } else {
                        if (verificarFichaParaComerNEgra(columna, fila, columnamv, filamv)) {
                            return 4;
                        }
                        return 1;
                    }
                }
            }
            return 1;
        }
        return 1;

    }

    public int verificarMover() {
        System.out.println("Que vas a hacer");
        System.out.println("1) Mover");
        System.out.println("2) Comer");
        int opcion = Integer.parseInt(scan.nextLine());
        return opcion;
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
            if (filamv == fila + 1) {
                return true;
            } else {
                return false;
            }
        } else if (fila == 7) {
            if (filamv == fila - 1) {
                return true;
            } else {
                return false;
            }
        } else {
            if (filamv == fila + 1 || filamv == fila - 1) {
                return true;
            } else {
                return false;
            }
        }

    }

    public boolean verificarMovimientoNegras(int columna, int fila, int columnamv, int filamv) {
        if (fila == 0) {
            if (filamv == fila + 1) {
                return true;
            } else {
                return false;
            }
        } else if (fila == 7) {
            if (filamv == fila - 1) {
                return true;
            } else {
                return false;
            }
        } else {
            if (filamv == fila + 1 || filamv == fila - 1) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean verificarFichaParaComerBlanca(int columna, int fila, int columnamv, int filamv) {
        if (fila == 0 | fila == 1) {
            if (tablero2.getCelda(columna + 1, fila + 1).equals(celda.pintarCeldaFicha(false))) {
                tablero2.setCambio(columna + 1, fila + 1, celda.pintarCeldas(false));
                return true;
            }
        } else if (fila == 7 | fila == 6) {
            if (tablero2.getCelda(columna + 1, fila - 1).equals(celda.pintarCeldaFicha(false))) {
                tablero2.setCambio(columna + 1, fila - 1, celda.pintarCeldas(false));
                return true;
            }
        } else if (fila > 1 & fila < 6) {
            if (tablero2.getCelda(columna + 1, fila + 1).equals(celda.pintarCeldaFicha(false))) {
                tablero2.setCambio(columna + 1, fila + 1, celda.pintarCeldas(false));
                return true;
            } else if (tablero2.getCelda(columna + 1, fila - 1).equals(celda.pintarCeldaFicha(false))) {
                tablero2.setCambio(columna + 1, fila - 1, celda.pintarCeldas(false));
                return true;
            }
        }
        return false;
    }

    public boolean verificarFichaParaComerNEgra(int columna, int fila, int columnamv, int filamv) {
        if (fila == 0 | fila == 1) {
            if (tablero2.getCelda(columna - 1, fila + 1).equals(celda.pintarCeldaFicha(true))) {
                tablero2.setCambio(columna - 1, fila + 1, celda.pintarCeldas(false));
                return true;
            }
            return false;
        } else if (fila == 7 | fila == 6) {
            if (tablero2.getCelda(columna - 1, fila - 1).equals(celda.pintarCeldaFicha(true))) {
                tablero2.setCambio(columna - 1, fila - 1, celda.pintarCeldas(false));
                return true;
            }
            return false;
        } else if (fila > 1 & fila < 6) {
            if (tablero2.getCelda(columna - 1, fila + 1).equals(celda.pintarCeldaFicha(true))) {
                tablero2.setCambio(columna - 1, fila + 1, celda.pintarCeldas(false));
                return true;
            } else if (tablero2.getCelda(columna - 1, fila - 1).equals(celda.pintarCeldaFicha(true))) {
                tablero2.setCambio(columna - 1, fila - 1, celda.pintarCeldas(false));
                return true;
            }
            return false;
        }
        return false;
    }
}
