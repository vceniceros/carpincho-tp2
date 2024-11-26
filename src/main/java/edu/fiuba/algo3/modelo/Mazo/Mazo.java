package edu.fiuba.algo3.modelo.Mazo;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import edu.fiuba.algo3.modelo.Prooveedor.Proveedor;
import edu.fiuba.algo3.modelo.carta.Carta;

public class Mazo implements Proveedor {
    final int TAMANIOMANO = 8;
    private List<Carta> cartas;

    public Mazo(Proveedor proveedor) {
        this.cartas = proveedor.generarCartas();
        this.mezclar();
    }

    public Mazo(ArrayList<Carta> cartas){
        this.cartas = cartas;
    }

    public void mezclar() {
        Collections.shuffle(this.cartas);
    }

    public List<Carta> generarCartas() {
        List<Carta> cartasJugador = new ArrayList<>();

        for (int i = 0; i < TAMANIOMANO; i++) {
            cartasJugador.add(cartas.get(i));
        }
        cartas.subList(0, TAMANIOMANO).clear();

        return cartasJugador;
    }

    public List<Carta> repartirCartas() {        //Nunca usamos repartir en mano
        this.mezclar();
        return this.generarCartas();
    }

    private void repartirConUnaCantidad(List<Carta> cartasJugador) {
        int cantidadDeCartas;

        cantidadDeCartas = TAMANIOMANO - cartasJugador.size();

        if (cantidadDeCartas > this.cartas.size()) {
            throw new TamanioMazoInsuficiente();
        }
        this.mezclar();
        List<Carta> manoJugador = new ArrayList<>(this.cartas.subList(0, cantidadDeCartas));

        cartasJugador.addAll(manoJugador);
    }

    public void reponer(List<Carta> cartasJugador) {
        repartirConUnaCantidad(cartasJugador);
    }

    public int obtenerCantidadDeCartas() {
        return this.cartas.size();
    }

    public void agregarAlMazo(Carta carta){
        this.cartas.add(carta);
    }
}
