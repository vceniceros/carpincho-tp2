package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.MazoDeTarots;
import edu.fiuba.algo3.modelo.Mano.Mano;
import edu.fiuba.algo3.modelo.ManoDePoker.CartaMasAlta;
import edu.fiuba.algo3.modelo.Mazo.Mazo;
import edu.fiuba.algo3.modelo.MazoDeComodines.MazoDeComodines;
import edu.fiuba.algo3.modelo.Palo.Corazon;
import edu.fiuba.algo3.modelo.Palo.Diamante;
import edu.fiuba.algo3.modelo.Palo.Pica;
import edu.fiuba.algo3.modelo.Palo.Trebol;
import edu.fiuba.algo3.modelo.Tarot.Tarot;
import edu.fiuba.algo3.modelo.carta.Carta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BalatroTest {

    @Test
    void test01jugadorSeleccionaUnaCartaYJuegaSinComodines(){
        //arrange
        ArrayList<Carta> cartas = new ArrayList<Carta>();
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));

        Mazo mazoDeCartas = new Mazo(cartas);
        Mano manoDeLaRonda = new Mano(mazoDeCartas);
        MazoDeComodines comodines = new MazoDeComodines();

        //act
        //en estos casos voy a actuar como el jugador
        manoDeLaRonda.seleccionarCarta(2);
        int puntosObtenidos = manoDeLaRonda.jugarCartas(comodines);

        //assert
        assertEquals(7,puntosObtenidos);

    }

    @Test
    void test02jugadorSeleccionaUnaCartaYJuegaSinComodines(){
        //arrange
        ArrayList<Carta> cartas = new ArrayList<Carta>();
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 3,3,1));
        cartas.add( new Carta(new Pica(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 3,3,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 12,10,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));

        Mazo mazoDeCartas = new Mazo(cartas);
        Mano manoDeLaRonda = new Mano(mazoDeCartas);
        MazoDeComodines comodines = new MazoDeComodines();

        //act
        //en estos casos voy a actuar como el jugador
        manoDeLaRonda.seleccionarCarta(1);
        int puntosObtenidos = manoDeLaRonda.jugarCartas(comodines);

        //assert
        assertEquals(8,puntosObtenidos);

    }

    @Test
    void test03jugadorSeleccionaDosCartasDelMismoNumeroYJuegaSinComodines(){
        //arrange
        ArrayList<Carta> cartas = new ArrayList<Carta>();
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 3,3,1));
        cartas.add( new Carta(new Pica(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Trebol(), 4,4,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 12,10,1));
        cartas.add( new Carta(new Diamante(), 14,10,1));

        Mazo mazoDeCartas = new Mazo(cartas);
        Mano manoDeLaRonda = new Mano(mazoDeCartas);
        MazoDeComodines comodines = new MazoDeComodines();

        //act
        //en estos casos voy a actuar como el jugador
        manoDeLaRonda.seleccionarCarta(4);
        manoDeLaRonda.seleccionarCarta(6); //verificar mano porque no se puede seleccionar la posicion 7 //no se puede porque mientras se eligen, se van de la lista
        int puntosObtenidos = manoDeLaRonda.jugarCartas(comodines);

        //assert
        assertEquals(28,puntosObtenidos);

    }

    @Test
    void test04jugadorSeleccionaDosParesDeCartasMismoNumeroYJuegaSinComodines(){
        //arrange
        ArrayList<Carta> cartas = new ArrayList<Carta>();
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 3,3,1));
        cartas.add( new Carta(new Pica(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Trebol(), 4,4,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 12,10,1));
        cartas.add( new Carta(new Diamante(), 12,10,1));

        Mazo mazoDeCartas = new Mazo(cartas);
        Mano manoDeLaRonda = new Mano(mazoDeCartas);
        MazoDeComodines comodines = new MazoDeComodines();

        //act
        //en estos casos voy a actuar como el jugador
        manoDeLaRonda.seleccionarCarta(4);
        manoDeLaRonda.seleccionarCarta(6);
        manoDeLaRonda.seleccionarCarta(1);
        manoDeLaRonda.seleccionarCarta(0);
        int puntosObtenidos = manoDeLaRonda.jugarCartas(comodines);

        //assert
        assertEquals(88,puntosObtenidos);

    }

    @Test
    void test05jugadorSeleccionaEscaleraYJuegaSinComodines(){
        //arrange
        ArrayList<Carta> cartas = new ArrayList<Carta>();
        cartas.add( new Carta(new Corazon(), 5,5,1));
        cartas.add( new Carta(new Corazon(), 3,3,1));
        cartas.add( new Carta(new Pica(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Trebol(), 4,4,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 6,6,1));
        cartas.add( new Carta(new Diamante(), 12,10,1));

        Mazo mazoDeCartas = new Mazo(cartas);
        Mano manoDeLaRonda = new Mano(mazoDeCartas);
        MazoDeComodines comodines = new MazoDeComodines();

        //act
        //en estos casos voy a actuar como el jugador
        manoDeLaRonda.seleccionarCarta(5);   //{12,6,5,4,3,2,2,2} -> {12,6,5,4,3,2,2}
        manoDeLaRonda.seleccionarCarta(1);   //-> {12,5,4,3,2,2}
        manoDeLaRonda.desSeleccionarCarta(new Carta(new Pica(), 2,2,1)); //{12,5,4,3,2,2,2}
        manoDeLaRonda.seleccionarCarta(6); // -> {12,5,4,3,2,2}
        manoDeLaRonda.seleccionarCarta(1);  //-> {12,4,3,2,2}
        manoDeLaRonda.seleccionarCarta(2);  //-> {12,4,2,2}
        manoDeLaRonda.seleccionarCarta(1);  //-> {12,2,2}
        int puntosObtenidos = manoDeLaRonda.jugarCartas(comodines);

        //assert
        //6+5+4+3+2 de las cartas + 30 de la mano de poker (escalera simple)
        //multiplicado por el multiplicador de la mano de poker 4
        assertEquals(200,puntosObtenidos);

    }

    @Test
    void test06jugadorSeleccionaEscaleraColorYJuegaSinComodines(){
        //arrange
        ArrayList<Carta> cartas = new ArrayList<Carta>();
        cartas.add( new Carta(new Corazon(), 5,5,1));
        cartas.add( new Carta(new Corazon(), 3,3,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 4,4,1));
        cartas.add( new Carta(new Pica(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 6,6,1));
        cartas.add( new Carta(new Diamante(), 12,10,1));

        Mazo mazoDeCartas = new Mazo(cartas);
        Mano manoDeLaRonda = new Mano(mazoDeCartas);
        MazoDeComodines comodines = new MazoDeComodines();

        //act
        //en estos casos voy a actuar como el jugador
        manoDeLaRonda.seleccionarCarta(5);   //{12,6,5,4,3,2,2,2} -> {12,6,5,4,3,2,2}
        manoDeLaRonda.seleccionarCarta(1);   //-> {12,5,4,3,2,2}
        manoDeLaRonda.seleccionarCarta(1);  //-> {12,4,3,2,2}
        manoDeLaRonda.seleccionarCarta(2);  //-> {12,4,2,2}
        manoDeLaRonda.seleccionarCarta(1);  //-> {12,2,2}
        int puntosObtenidos = manoDeLaRonda.jugarCartas(comodines);

        //assert
        //6+5+4+3+2 de las cartas + 100 de la mano de poker (escalera color)
        //multiplicado por el multiplicador de la mano de poker 8
        assertEquals(960,puntosObtenidos);

    }

    @Test
    void test07jugadorSeleccionaEscaleraColorYJuegaSinComodines(){
        //arrange
        ArrayList<Carta> cartas = new ArrayList<Carta>();
        Carta cartaASacar = new Carta(new Pica(), 2,2,1);
        cartas.add( new Carta(new Corazon(), 5,5,1));
        cartas.add( new Carta(new Corazon(), 3,3,1));
        cartas.add( new Carta(new Pica(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 4,4,1));
        cartas.add( cartaASacar);
        cartas.add( new Carta(new Corazon(), 6,6,1));
        cartas.add( new Carta(new Diamante(), 12,10,1));

        Mazo mazoDeCartas = new Mazo(cartas);
        Mano manoDeLaRonda = new Mano(mazoDeCartas);
        MazoDeComodines comodines = new MazoDeComodines();

        //act
        //en estos casos voy a actuar como el jugador
        manoDeLaRonda.seleccionarCarta(7);   //{12,6,5,4,3,2,2,2} -> {12,6,5,4,3,2,2}
        manoDeLaRonda.seleccionarCarta(1);   //-> {12,5,4,3,2,2}
        manoDeLaRonda.seleccionarCarta(1);  //-> {12,4,3,2,2}
        manoDeLaRonda.desSeleccionarCarta(cartaASacar); //-> {12,4,3,2,2,2}
        manoDeLaRonda.seleccionarCarta(2);  //-> {12,4,2,2,2}
        manoDeLaRonda.seleccionarCarta(1);  //-> {12,2,2,2}
        manoDeLaRonda.seleccionarCarta(3);  //-> {12,2,2}
        int puntosObtenidos = manoDeLaRonda.jugarCartas(comodines);

        //assert
        //6+5+4+3+2 de las cartas + 100 de la mano de poker (escalera color)
        //multiplicado por el multiplicador de la mano de poker 8
        assertEquals(960,puntosObtenidos);

    }

    @Test
    void test08jugadorAplicaTarotAManoDePokerSeleccionaUnaCartaYJuegaSinComodines(){
        //arrange
        ArrayList<Carta> cartas = new ArrayList<Carta>();
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 3,3,1));
        cartas.add( new Carta(new Pica(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 3,3,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 12,10,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));

        Tarot tarot = new Tarot(10,2,new CartaMasAlta());
        /*MazoDeTarots tarots = new MazoDeTarots();
        tarots.agregar(tarot);*/

        Mazo mazoDeCartas = new Mazo(cartas);
        Mano manoDeLaRonda = new Mano(mazoDeCartas);
        MazoDeComodines comodines = new MazoDeComodines();

        //act
        //en estos casos voy a actuar como el jugador
        manoDeLaRonda.seleccionarCarta(1);
        manoDeLaRonda.aplicarTarot(tarot,new CartaMasAlta()); //provisorio
        int puntosObtenidos = manoDeLaRonda.jugarCartas(comodines);

        //assert
        assertEquals(26,puntosObtenidos);

    }
}
