package edu.fiuba.algo3.entrega_1.Mano;

import edu.fiuba.algo3.entrega_1.Jugada.Jugada;
import edu.fiuba.algo3.entrega_1.Mazo.Mazo;
import edu.fiuba.algo3.entrega_1.Ordenador.OrdenadorDeCartas;
import edu.fiuba.algo3.entrega_1.Prooveedor.Proveedor;
import edu.fiuba.algo3.entrega_1.carta.Carta;

import java.util.ArrayList;
import java.util.List;
public class Mano {
    //private Proveedor proveedor;
    private Mazo mazo;
    private List<Carta> cartas = new ArrayList();
    private Jugada jugada = new Jugada();
/*
    public Mano(Proveedor proveedor) {
        this.proveedor = proveedor;
        this.cartas = proveedor.generarCartas();
    }
*/

    public Mano(Mazo mazo){
        this.mazo = mazo;
        this.cartas = mazo.repartirCartas();
    }

    public boolean esManoCompleta() {
        return cartas.size() == 8;
    }

    public List<Carta> jugarCartas(List<Carta> cartasRecibidas) {;
        cartas.removeAll(cartasRecibidas);
        return cartasRecibidas;
    }

    public void ordenarMano(){
        OrdenadorDeCartas.ordenarCartas(this.cartas);
    }

    public List<Carta> verCartasEnMano(){
        return cartas;
    }

    public Carta agarrarCarta(int posicionMano){
        return this.cartas.get(posicionMano);
    }
   //descartar debe: agarrar la carta
    // repartir
    // agregar al mazo la carta descartada

    public void descartar(int posicionMano){
        Carta carta = agarrarCarta(posicionMano);
        this.cartas.remove(carta);
        // ponele que reponer me devuelve una lista con cartas nuevas, debo concatenar con cartas
        this.cartas.addAll(this.mazo.reponer(this.cartas));
        this.mazo.agregarCarta(carta);
    }

    public void descartar(){
        jugada.descartar();
    }

    public void seleccionarCarta(int posicionMano){
        Carta carta = this.cartas.get(posicionMano);
        jugada.seleccionar(carta);
    }
}