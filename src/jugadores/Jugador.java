package src.jugadores;

public class Jugador {

    //Atributos
    private String nombre;
    private int numeroJugador;

    //Constructor
    public Jugador( int numeroJugador, String nombre){
        this.numeroJugador = numeroJugador;
        this.nombre = nombre;
    }



    //Getter y Setter
    public String getNombre() {
        return nombre;
    }

    public int getNumeroJugador() {
        return numeroJugador;
    }

    public String getInformacion(){
        return "No. " + getNumeroJugador() + " Nombre: " + getNombre();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroJugador(int numeroJugador) {
        this.numeroJugador = numeroJugador;
    }
}
