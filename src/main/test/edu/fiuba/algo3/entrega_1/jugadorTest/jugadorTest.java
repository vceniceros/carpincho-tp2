package edu.fiuba.algo3.entrega_1.jugadorTest;

import edu.fiuba.algo3.entrega_1.Jugada.Jugada;
import edu.fiuba.algo3.entrega_1.GeneradorDeCartas.GeneradorDeCartas;
import edu.fiuba.algo3.entrega_1.Jugador.Jugador;
import edu.fiuba.algo3.entrega_1.Mano.Mano;
import edu.fiuba.algo3.entrega_1.Mazo.Mazo;
import edu.fiuba.algo3.entrega_1.Palo.Diamante;
import edu.fiuba.algo3.entrega_1.Prooveedor.Proveedor;
import edu.fiuba.algo3.entrega_1.carta.Carta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class jugadorTest {
    Proveedor mazo;
    GeneradorDeCartas generadorDeCartas;
    List<Carta> cartasJugadas;

    @BeforeEach
    void setUp() {
    generadorDeCartas = new GeneradorDeCartas();
    cartasJugadas = generadorDeCartas.generarCartasPorLimite(new Diamante(), 2,9);
    mazo = mock(Mazo.class);
    when(mazo.repartirCartas()).thenReturn(cartasJugadas);
    }

    @Test
    public void test01aUnJugadorSeLeAsignaUnaJugada(){
    Jugador unJugador = new Jugador("martin");
    Mano mano = new Mano(mazo);

    unJugador.asignarMano(mano);

    Assertions.assertTrue(unJugador.puedeJugar());
    }

    @Test
    public void test02aUnJugadorSelecciona2CartasParaUnaJugada(){
        Jugador unJugador = new Jugador("martin");
        Mano mano = new Mano(mazo);
        unJugador.asignarMano(mano);
        Carta unaCarta = cartasJugadas.get(0);
        Carta unaCarta2 = cartasJugadas.get(1);
        List <Carta> cartasParaUsar = new ArrayList<>();
        cartasParaUsar.add(unaCarta);
        cartasParaUsar.add(unaCarta2);


        Jugada jugada = unJugador.armarJugada(cartasParaUsar);

        Assertions.assertEquals(3, jugada.jugar());
    }
}
