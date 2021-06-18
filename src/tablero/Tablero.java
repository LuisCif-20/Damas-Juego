package tablero;

public class Tablero {
    
    //Atributos
    private String[][] tablero = new String[5][5];


    //Contructor
    public Tablero(){

    }
    //Metodos
    public void pintarTablero(){
        for (int i = 0; i < tablero.length; i++) {
            System.out.println((i+1) + "|     |");
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print("|     |");
            }
        }
    }
    //Getter y Setter
}
