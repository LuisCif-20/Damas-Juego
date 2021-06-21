package src.tablero;

public class Tablero {

    // Atributos
    private String[][] tablero = new String[8][8];
    private Celda celda = new Celda();

    // Contructor
    public Tablero() {

    }

    // Metodos

    public void pintarTableroDamas() {
        for (int i = 0; i < tablero.length; i++) {
            int par2 = i % 2;
            System.out.println("");
            for (int j = 0; j < tablero[i].length; j++) {
                int par1 = j % 2;
                if (par2 == 0) {
                    if (par1 != 0) {
                        System.out.print(celda.pintarCeldas(true));
                    } else {
                        System.out.print(celda.pintarCeldas(false));
                    }
                } else {
                    if (par1 == 0) {
                        System.out.print(celda.pintarCeldas(true));
                    } else {
                        System.out.print(celda.pintarCeldas(false));
                    }
                }
            }
        }
    }

    public void llenarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                int par1 = j % 2;
                int par2 = i % 2;
                if (i < 3) {
                    if (par2 == 0) {
                        if (par1 != 0) {
                            tablero[i][j] = celda.pintarCeldas(true);
                        } else {
                            tablero[i][j] = celda.pintarCeldaFicha(true);
                        }
                    } else {
                        if (par1 == 0) {
                            tablero[i][j] = celda.pintarCeldas(true);
                        } else {
                            tablero[i][j] = celda.pintarCeldaFicha(true);
                        }
                    }
                } else if (i > 4) {
                    if (par2 == 0) {
                        if (par1 != 0) {
                            tablero[i][j] = celda.pintarCeldas(true);
                        } else {
                            tablero[i][j] = celda.pintarCeldaFicha(false);
                        }
                    } else {
                        if (par1 == 0) {
                            tablero[i][j] = celda.pintarCeldas(true);
                        } else {
                            tablero[i][j] = celda.pintarCeldaFicha(false);
                        }
                    }
                } else {
                    if (par2 == 0) {
                        if (par1 != 0) {
                            tablero[i][j] = celda.pintarCeldas(true);
                        } else {
                            tablero[i][j] = celda.pintarCeldas(false);
                        }
                    } else {
                        if (par1 == 0) {
                            tablero[i][j] = celda.pintarCeldas(true);
                        } else {
                            tablero[i][j] = celda.pintarCeldas(false);
                        }
                    }
                }
            }
        }
    }

    public void imprimirTablero(){
        System.out.print("   ");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.println("");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(" " + i + " ");
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println("");
        }
    }

    // Getter y Setter

    public void setCambio(int columna, int fila, String cambio){
        tablero[columna][fila] = cambio;
    }

    public String getCelda (int columna, int fila){
        return tablero[columna][fila];
    }

    public String[][] getTablero() {
        return tablero;
    }

    public void setTablero(String[][] tablero) {
        this.tablero = tablero;
    }
}
