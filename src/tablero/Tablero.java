package src.tablero;

public class Tablero {
    
    //Atributos
    private String[][] tablero = new String[8][8];


    //Contructor
    public Tablero(){

    }
    //Metodos
    public void pintarTablero(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                int par1 = j%2;
                int par2 = i%2;
                if (par2 == 0) {
                    if (par1 != 0) {
                        System.out.print("\u001B[47m" +"    " + "\u001B[0m");
                    } else {
                        System.out.print("\u001B[41m"+"    " + "\u001B[0m");
                    }
                } else {
                    if (par1 == 0) {
                        System.out.print("\u001B[47m" +"    " + "\u001B[0m");
                    } else {
                        System.out.print("\u001B[41m"+"    " + "\u001B[0m");
                    }
                }
            }
            System.out.println("");
        }
    }

    public void pintarFichasTablero(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                int par1 = j%2;
                int par2 = i%2;
                if (i < 2) {
                    if (par2 == 0) {
                        if (par1 != 0) {
                            System.out.print("\u001B[47m" +"    " + "\u001B[0m");
                        } else {
                            System.out.print("\u001B[41m" + "\u001B[37m" + "  * " + "\u001B[0m");
                        }
                    } else {
                        if (par1 == 0) {
                            System.out.print("\u001B[47m" +"    " + "\u001B[0m");
                        } else {
                            System.out.print("\u001B[41m" + "\u001B[37m" + "  * " + "\u001B[0m");
                        }
                    }
                } else if (i > 5) {
                    if (par2 == 0) {
                        if (par1 != 0) {
                            System.out.print("\u001B[47m" +"    " + "\u001B[0m");
                        } else {
                            System.out.print("\u001B[41m" + "\u001B[30m" + "  * " + "\u001B[0m");
                        }
                    } else {
                        if (par1 == 0) {
                            System.out.print("\u001B[47m" +"    " + "\u001B[0m");
                        } else {
                            System.out.print("\u001B[41m" + "\u001B[30m" + "  * " + "\u001B[0m");
                        }
                    }
                } else {
                    if (par2 == 0) {
                        if (par1 != 0) {
                            System.out.print("\u001B[47m" +"    " + "\u001B[0m");
                        } else {
                            System.out.print("\u001B[41m" + "\u001B[30m" + "    " + "\u001B[0m");
                        }
                    } else {
                        if (par1 == 0) {
                            System.out.print("\u001B[47m" +"    " + "\u001B[0m");
                        } else {
                            System.out.print("\u001B[41m" + "\u001B[30m" + "    " + "\u001B[0m");
                        }
                    } 
                }
            }
            System.out.println("");
        }
    }

    //Getter y Setter
}
