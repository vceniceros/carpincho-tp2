package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.GeneradorDeCartas.GeneradorDeCartas;
import edu.fiuba.algo3.modelo.Jugada.Jugada;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mano.Mano;
import edu.fiuba.algo3.modelo.MazoDeComodines.MazoDeComodines;
import edu.fiuba.algo3.modelo.Palo.Corazon;
import edu.fiuba.algo3.modelo.Palo.Diamante;
import edu.fiuba.algo3.modelo.Palo.Pica;
import edu.fiuba.algo3.modelo.Palo.Trebol;
import edu.fiuba.algo3.modelo.carta.Carta;
import static org.mockito.Mockito.*;
import edu.fiuba.algo3.modelo.Mazo.Mazo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class testDeIntegracionEntrega1{
    GeneradorDeCartas generadorDeCartas;
    Mazo mazo;
    Mano mano;
    List<Carta> cartaDePrueba = new ArrayList<>();

    @BeforeEach
    public void setUp(){
        cartaDePrueba.add(new Carta(new Corazon(),2,2,1));
        cartaDePrueba.add(new Carta(new Corazon(),3,3,1));
        cartaDePrueba.add(new Carta(new Corazon(),4,4,1));
        cartaDePrueba.add(new Carta(new Diamante(),10,10,1));
        cartaDePrueba.add(new Carta(new Diamante(),11,10,1));
        cartaDePrueba.add(new Carta(new Trebol(),5,10,1));
        cartaDePrueba.add(new Carta(new Trebol(),6,6,1));
        cartaDePrueba.add(new Carta(new Pica(),7,7,1));

        mazo = Mockito.mock(Mazo.class);
        mano = new Mano(mazo, 3, new MazoDeComodines());

        when(mazo.generarCartas()).thenReturn(cartaDePrueba);
    }
    @Test
        public void test01SeVerificaQueUnJugadorCuentaConCartasSuficientesParaIniciarElJuegoEnSuMaso() {
            Jugador jugador = new Jugador("Manuel");

            jugador.asignarMano(mano);

            assert(jugador.puedeJugar());

        }
    /*@Test

    public void test02UnJugadorJuegaUnaManoDelMazo(){
        Jugador jugador = new Jugador("Manuel");
        jugador.asignarMano(mano);
        List<Carta> cartasDePrueba = new ArrayList<>();
        cartasDePrueba.add(new Carta(new Corazon(),2,2,1));
        cartasDePrueba.add(new Carta(new Corazon(),3,3,1));
        Jugada jugada = jugador.armarJugada(cartasDePrueba);

        Assertions.assertEquals(20, jugada.jugar());

    }*/
    }