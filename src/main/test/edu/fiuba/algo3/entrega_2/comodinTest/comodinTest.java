package edu.fiuba.algo3.entrega_2.comodinTest;


import edu.fiuba.algo3.controllers.Parseados.EfectoParseado;
import edu.fiuba.algo3.modelo.ManoDePoker.CartaMasAlta;
import edu.fiuba.algo3.modelo.ManoDePoker.EscaleraReal;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.activacion.Activacion;
import edu.fiuba.algo3.modelo.activacion.ActivacionManoDePoker;
import edu.fiuba.algo3.modelo.activacion.ActivacionProbabilidad;
import edu.fiuba.algo3.modelo.activacion.ActivacionSiempre;
import edu.fiuba.algo3.modelo.comodin.*;
import edu.fiuba.algo3.modelo.efectos.Efecto;
import edu.fiuba.algo3.modelo.efectos.SumadorDeMultiplicador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.modelo.ManoDePoker.Par;

public class comodinTest {
    EfectoParseado efectoTest1;
    EfectoParseado efectoTest2;

    @BeforeEach
    void setUp() {
        efectoTest1 = new EfectoParseado();
        efectoTest1.setPuntos(1);
        efectoTest1.setMultiplicador(8);

        efectoTest2 = new EfectoParseado();
        efectoTest2.setPuntos(1);
        efectoTest2.setMultiplicador(3);
    }
    @Test
    // Verificar que al tener un comodín que sume 8 al multiplicador se aplique correctamente
    public void testComodinAplicaMultiplicadorCorrectamente() {
        Activacion activaciones = new ActivacionSiempre();
        Efecto efectoSumar = new SumadorDeMultiplicador(efectoTest1);
        Comodin comodin = new Comodin("Comodín Multiplicador", "Suma 8 al multiplicador",efectoSumar ,  activaciones);

        ManoDePoker cartaAlta = new CartaMasAlta(); // valor: 5 multiplicador:8
        Puntaje puntajeFinal = comodin.aplicarA(cartaAlta);

        Assertions.assertEquals(9, puntajeFinal.getMultiplicador());
    }


    @Test
    //Verificar que el jugador recibe un aumento correspondiente si tiene el comodín que aumenta el multiplicador por 3 si juega una escalera
    public void testComodinAplicaAumentoPorManoDePoker() {
        ManoDePoker escaleraReal = new EscaleraReal();
        Activacion activaciones = new ActivacionManoDePoker(escaleraReal);
        Efecto efectoSumar = new SumadorDeMultiplicador(efectoTest2);
        Comodin comodin = new Comodin("Comodín Multiplicador", "Suma 3 al multiplicador por Escalera", efectoSumar, activaciones );

        ManoDePoker manoJugada = new EscaleraReal(); // (100,8) -- 8 + 3 ->  11
        Puntaje puntaje = new Puntaje(100,11);
        Puntaje puntajeFinal = comodin.aplicarA(manoJugada);

        Assertions.assertEquals(puntaje.getMultiplicador(), puntajeFinal.getMultiplicador());
    }

    @Test
    //Verificar que si el jugador posee un comodin que tiene chance 1 sobre 1000 de romperse se rompa correctamente.
    public void testComodinProbabilidadSeRompe() {
        ActivacionProbabilidad activacionProba = new ActivacionProbabilidad(1000);
        ManoDePoker manoJugada = new Par();
        activacionProba.esActivable(manoJugada);
        Assertions.assertTrue(activacionProba.estaRoto());
    }

//    @Test
//    // El jugador activa un comodín con una combinación de efectos
//    // bonus de mano jugada + puntaje aumentado + activación aleatoria
//    //"descripcion": "x15  Mult. 1 en 6 de probabilidad y +100  fichas si la mano jugada contiene un trio",
//    public void testComodinCombinacionesDeEfectos() {
//        ManoDePoker trio = new Trio();
//        List<Activacion> activaciones = new ArrayList<>();
//        activaciones.add(new ActivacionProbabilidad(1));
//        activaciones.add(new ActivacionManoDePoker(trio));
//        Activacion activacion = new ActivacionMultiple(activaciones);
//        Comodin comodin = new Comodin("Comodín Combinado", "x15  Mult. 1 en 6 de probabilidad y +100  fichas si la mano jugada contiene un trio", 100, 15,activacion );
//        ManoDePoker manoJugada = new Trio(); // (30,3) -
//
//        Puntaje puntaje = new Puntaje(130,18);
//        Puntaje puntajeFinal = comodin.aplicarA(manoJugada);
//        // 100 +30 * 3 + 15
//        Assertions.assertEquals(puntaje.calcularPuntaje(), puntajeFinal.calcularPuntaje());
//    }

}


