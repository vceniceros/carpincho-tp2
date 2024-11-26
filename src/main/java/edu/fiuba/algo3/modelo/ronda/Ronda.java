package edu.fiuba.algo3.modelo.ronda;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mano.Mano;
import edu.fiuba.algo3.modelo.Mazo.Mazo;
import edu.fiuba.algo3.modelo.MazoDeComodines.MazoDeComodines;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Tarot.Tarot;

public class Ronda {
    private Jugador jugador;
    private Tienda tienda;
    private Mazo mazo;
    private int nro;
    private int manos;
    private int descartes;
    private int puntajeASuperar;

    public Ronda(Tienda tienda, int nro, int manos, int descartes, int puntajeASuperar) {
        this.tienda = tienda;
        this.nro = nro;
        this.manos = manos;
        this.descartes = descartes;
        this.puntajeASuperar = puntajeASuperar;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void asignarJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Jugador getJugador() {return this.jugador; }

    public void asignarMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    public Puntaje seleccionar(int posicionCarta) {
        return this.jugador.getMano().seleccionarCarta(posicionCarta).devolverPuntaje();
    }

    public Puntaje seleccionar(int posicionCarta, Tarot tarot) {
        return this.jugador.getMano().seleccionarCarta(posicionCarta,tarot).devolverPuntaje();
    }

    public void jugar() {
        if( this.manos >= 1 ){
        Mano mano = new Mano(mazo,3, new MazoDeComodines());
        this.jugador.asignarMano(mano);
        this.manos = this.manos - 1;
        }  else {
        throw new IllegalStateException("No hay manos disponibles para jugar.");
        }
    }


}
