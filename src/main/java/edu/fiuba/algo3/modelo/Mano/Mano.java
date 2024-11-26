package edu.fiuba.algo3.modelo.Mano;

import edu.fiuba.algo3.MazoDeTarots;
import edu.fiuba.algo3.modelo.Jugada.Jugada;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.modelo.Mazo.Mazo;
import edu.fiuba.algo3.modelo.MazoDeComodines.MazoDeComodines;
import edu.fiuba.algo3.modelo.Ordenador.OrdenadorDeCartas;
import edu.fiuba.algo3.modelo.Tarot.Tarot;
import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.ArrayList;
import java.util.List;
public class Mano {

    private Mazo mazo;
    private List<Carta> cartas = new ArrayList<>();
    private Jugada jugada = new Jugada();
    private int descartes;
    //private MazoDeComodines comodines;

    public Mano(Mazo mazo) {
        this.cartas = mazo.repartirCartas();
        this.ordenarMano();
        this.descartes = 3;;

    }

    public Mano(Mazo mazo,int descartes) {
        //this.proveedor = proveedor;
        this.mazo = mazo;
        this.cartas = mazo.repartirCartas();
        this.descartes = descartes;         //constructor para poder elegir la cantidad de descartes
    }


    public boolean esManoCompleta() {
        return cartas.size() == 8;
    }


    private void ordenarMano(){
        OrdenadorDeCartas.ordenarCartas(this.cartas);
    }


    public List<Carta> verCartasEnMano(){
        return cartas;
    }

    public void seleccionarCarta(int posicionMano){
        Carta carta = this.cartas.get(posicionMano);
        jugada.seleccionar(carta);
        this.cartas.remove(carta);
    }

    public void desSeleccionarCarta(Carta carta){
        this.cartas.add(jugada.deseleccionar(carta));
        this.ordenarMano();
    }


    public int jugarCartas(MazoDeComodines comodines){
        ManoDePoker manoDePoker = jugada.jugar();  //se juegan las cartas seleccionadas y devuelve los puntos obtenidos
        comodines.aplicarA(manoDePoker);
        return manoDePoker.calcularPuntaje();
    }


    public void descartarCartas(){
        //verificar que hayan descartes
        this.descartes--;
        jugada.descartar();
        //comodines.actualizarPorDescarte();
    }
    //este le aplica a la mano que le corresponde
    public void aplicarTarot(Tarot tarot,ManoDePoker manoDePoker){
        this.jugada.aplicarTarotAMano(tarot,manoDePoker);
    }
}