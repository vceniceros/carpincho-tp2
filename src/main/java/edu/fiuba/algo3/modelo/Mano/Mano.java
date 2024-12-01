package edu.fiuba.algo3.modelo.Mano;
import edu.fiuba.algo3.modelo.Jugada.Jugada;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.modelo.MazoDeComodines.MazoDeComodines;
import edu.fiuba.algo3.modelo.Ordenador.OrdenadorDeCartas;
import edu.fiuba.algo3.modelo.Prooveedor.ProveedorDeCartas;
import edu.fiuba.algo3.modelo.Tarot.Tarot;
import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.ArrayList;
import java.util.List;
public class Mano {
    private ProveedorDeCartas proveedorDeCartas;
    private List<Carta> cartas = new ArrayList();
    private Jugada jugada = new Jugada();
    private int descartes;
    //private MazoDeComodines comodines;


    public Mano(ProveedorDeCartas proveedorDeCartas, int descartes, MazoDeComodines comodines) {
        this.proveedorDeCartas = proveedorDeCartas;
        this.cartas = proveedorDeCartas.generarCartas();
        this.descartes = descartes;         //constructor para poder elegir la cantidad de descartes
        //this.comodines = comodines;         //y para darle los comodines
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

    public ManoDePoker seleccionarCarta(int posicionMano){
        Carta carta = this.cartas.get(posicionMano);
        this.cartas.remove(carta);
        return jugada.seleccionar(carta);
    }

    public ManoDePoker seleccionarCarta(int posicionMano, Tarot tarot){
        Carta carta = this.cartas.get(posicionMano);
        this.cartas.remove(carta);
        tarot.aplicarA(carta);
        return jugada.seleccionar(carta);
    }


    public void desSeleccionarCarta(Carta carta){
        this.cartas.add(jugada.deseleccionar(carta));
        this.ordenarMano();
    }

    public int jugarCartas(){
        ManoDePoker manoDePoker = jugada.jugar();  //se juegan las cartas seleccionadas y devuelve los puntos obtenidos
        //comodines.aplicar(manoDePoker);
        return manoDePoker.calcularPuntaje();
    }

    public void descartarCartas(){
        //verificar que hayan descartes
        this.descartes--;
        jugada.descartar();
        //comodines.actualizarPorDescarte();
    }
}