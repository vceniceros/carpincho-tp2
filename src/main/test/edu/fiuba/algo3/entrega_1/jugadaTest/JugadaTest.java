package edu.fiuba.algo3.entrega_2.jugadaTest;


import edu.fiuba.algo3.modelo.Jugada.Jugada;
import edu.fiuba.algo3.modelo.ManoDePoker.CartaMasAlta;
import edu.fiuba.algo3.modelo.ManoDePoker.EscaleraSimple;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.modelo.ManoDePoker.Par;
import edu.fiuba.algo3.modelo.Palo.Corazon;
import edu.fiuba.algo3.modelo.Palo.Diamante;
import edu.fiuba.algo3.modelo.Palo.Pica;
import edu.fiuba.algo3.modelo.Palo.Trebol;
import edu.fiuba.algo3.modelo.carta.Carta;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JugadaTest {
    @Test
    void test01agregoDosCartasALaJugada(){
        //arrange
        Jugada jugada = new Jugada();
        Carta otraCarta = new Carta(new Corazon(), 4,4,1);
        Carta unaCarta = new Carta(new Corazon(), 3,3,1);

        //act
        jugada.seleccionar(unaCarta);
        jugada.seleccionar(otraCarta);

        //assert
        assertEquals(2,jugada.cantidadDeCartas());
    }

    @Test
    void test02juegoLaJugadaConUnaCartaConValor2YDevuelve7Puntos(){
        //arrange
        Jugada jugada = new Jugada();
        Carta carta = new Carta(new Corazon(), 2,2,1);;

        //act
        jugada.seleccionar(carta);
        ManoDePoker manoObtenida = jugada.jugar();
        double puntosObtenidos = manoObtenida.calcularPuntaje();

        //assert
        assertEquals(7,puntosObtenidos);
    }

    @Test
    void test03seleccionoUn2DeCorazonesYUn2DeDiamanteParaJugarYDa28Puntos(){
        //arrange
        Jugada jugada = new Jugada();
        Carta carta = new Carta(new Corazon(), 2,2,1);
        Carta carta2 = new Carta(new Diamante(),2,2,1);

        //act
        jugada.seleccionar(carta);
        jugada.seleccionar(carta2);
        ManoDePoker manoObtenida = jugada.jugar();
        double puntosObtenidos = manoObtenida.calcularPuntaje();

        //assert
        assertEquals(28,puntosObtenidos);
    }

    @Test
    void test04seleccionoUn2DeCorazonesYJugadaTieneComoManoDePokerCartaMasAlta(){
        //arrange
        Jugada jugada = new Jugada();
        Carta carta = new Carta(new Corazon(), 2,2,1);
        ManoDePoker manoEsperada = new CartaMasAlta();

        //act
        jugada.seleccionar(carta);

        //assert
        assertTrue(jugada.tieneMano(manoEsperada));
    }
    @Test
    void test05seleccionoUn2DeCorazonesYLuegoUn2DePicasYJugadaTieneComoManoDePokerPar(){
        //arrange
        Jugada jugada = new Jugada();
        Carta carta = new Carta(new Corazon(), 2,2,1);
        Carta otraCarta = new Carta(new Pica(), 2,2,1);
        ManoDePoker manoEsperada = new Par();

        //act
        jugada.seleccionar(carta);
        jugada.seleccionar(otraCarta);

        //assert
        assertTrue(jugada.tieneMano(manoEsperada));
    }
    @Test
    void test06seleccionoUn2DeCorazonesYUn2DePicasYDeseleccionoYJugadaTieneComoManoDePokerCartaMasAlta(){
        //arrange
        Jugada jugada = new Jugada();
        Carta carta = new Carta(new Corazon(), 2,2,1);
        Carta otraCarta = new Carta(new Pica(), 2,2,1);
        ManoDePoker manoEsperada = new CartaMasAlta();

        //act
        jugada.seleccionar(carta);
        jugada.seleccionar(otraCarta);
        jugada.deseleccionar(carta);

        //assert
        assertTrue(jugada.tieneMano(manoEsperada));
    }

    @Test
    void test07agregoUnaEscaleraALaJugadaDesordenadasYMeDevuelveEscalera(){
        //arrange
        Jugada jugada = new Jugada();
        ManoDePoker manoEsperada = new EscaleraSimple();
        Carta carta1 = new Carta(new Corazon(), 2,2,1);
        Carta carta2 = new Carta(new Pica(), 3,3,1);
        Carta carta3 = new Carta(new Corazon(), 6,6,1);
        Carta carta4 = new Carta(new Corazon(), 4,4,1);
        Carta carta5 = new Carta(new Trebol(), 5,5,1);

        //act
        jugada.seleccionar(carta1);
        jugada.seleccionar(carta2);
        jugada.seleccionar(carta3);
        jugada.seleccionar(carta4);
        jugada.seleccionar(carta5);

        //assert
        assertTrue(jugada.tieneMano(manoEsperada));
    }

}
