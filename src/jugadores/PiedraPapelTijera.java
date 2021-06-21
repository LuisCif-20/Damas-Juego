package src.jugadores;

import java.util.*;

public class PiedraPapelTijera {

    Random ale = new Random();
    private int resultadoplayer1;
    private int resultadoplayer2;

    public PiedraPapelTijera() {

    }

    public int competir() { 
        int piedra = 0;
        int papel = 1;
        int tijera =2;
        do {
            resultadoplayer1 = ale.nextInt(3);
            resultadoplayer2 = ale.nextInt(3);
        } while (resultadoplayer1 == resultadoplayer2);
        if (resultadoplayer1 == piedra & resultadoplayer2== tijera) {
            System.out.println("Jugador 1 saco piedra y jugador 2 saco tijeras");
            System.out.println("Jugador 1 usa blancas");
            return 1;
        } else if (resultadoplayer1 == papel & resultadoplayer2 == piedra){
            System.out.println("Jugador 1 saco papel, y jugador 2 saco piedra");
            System.out.println("Jugador 1 usa blancas");
            return 1;
        } else if (resultadoplayer1 == tijera & resultadoplayer2 == papel){
            System.out.println("Jugador 1 saco tijera, y jugador 2 saco papel");
            System.out.println("Jugador 1 usa blancas");
            return 1;
        } else if (resultadoplayer2 == piedra & resultadoplayer1== tijera) {
            System.out.println("Jugador 2 saco piedra y jugador 1 saco tijeras");
            System.out.println("Jugador 2 usa blancas");
            return 2;
        } else if (resultadoplayer2 == papel & resultadoplayer1 == piedra){
            System.out.println("Jugador 2 saco papel, y jugador 1 saco piedra");
            System.out.println("Jugador 2 usa blancas");
            return 2;
        } else if (resultadoplayer2 == tijera & resultadoplayer1 == papel){
            System.out.println("Jugador 2 saco tijera, y jugador 1 saco papel");
            System.out.println("Jugador 2 usa blancas");
            return 2;
        }
        return 0;
    }

}
