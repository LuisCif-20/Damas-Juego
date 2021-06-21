package src.jugadores;

public class Jugador {

    //Atributos
    private String nombre;
    private String color;
    private int numeroJugador;

    //Constructor
    public Jugador( int numeroJugador, String nombre){
        this.numeroJugador = numeroJugador;
        this.nombre = nombre;
        color = "Aun no tiene";
    }



    //Getter y Setter
    public String getNombre() {
        return nombre;
    }

    public int getNumeroJugador() {
        return numeroJugador;
    }

    public String getInformacion(){
        return "No. " + getNumeroJugador() + " Nombre: " + getNombre() + " Color De Fichas: " + getColor();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroJugador(int numeroJugador) {
        this.numeroJugador = numeroJugador;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
