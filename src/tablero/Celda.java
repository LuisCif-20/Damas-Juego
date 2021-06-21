package src.tablero;

public class Celda {

    //Atributos
    private String celda;
    private String celdaBlanca = "\u001B[47m" + " " + "\u001B[0m";
    private String celdaAmarilla = "\u001B[45m" + " " + "\u001B[0m";
    private Piezas pieza = new Piezas();

    //Contructor
    public Celda(){

    }

    //Metodos
    public String pintarCeldas(boolean par){
        if (par) {
            celda = celdaBlanca + celdaBlanca + celdaBlanca;
        } else {
            celda = celdaAmarilla + celdaAmarilla + celdaAmarilla;
        }
        return celda;
    }

    public String pintarCeldaFicha(boolean color){
        if (color) {
            celda = celdaAmarilla + pieza.getPiezablanca() + celdaAmarilla;
        } else {
            celda = celdaAmarilla + pieza.getPiezanegra() + celdaAmarilla;
        }
        return celda;
    }

    public String getCeldaAmarilla() {
        return celdaAmarilla;
    }

    public String getCeldaBlanca() {
        return celdaBlanca;
    }





}
