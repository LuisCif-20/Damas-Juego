package src.tablero;

public class Piezas {

    private String piezablanca = "\u001B[45m" + "\u001B[37m" + "+" + "\u001B[0m";
    private String piezanegra = "\u001B[45m" + "\u001B[30m" + "+" + "\u001B[0m";

    public Piezas() {

    }

    public String getPiezablanca() {
        return piezablanca;
    }

    public String getPiezanegra() {
        return piezanegra;
    }
}
