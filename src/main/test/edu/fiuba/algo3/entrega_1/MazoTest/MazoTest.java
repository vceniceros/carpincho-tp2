package edu.fiuba.algo3.entrega_1.MazoTest;
import edu.fiuba.algo3.modelo.GeneradorDeCartas.GeneradorDeCartas;
import edu.fiuba.algo3.modelo.Mazo.Mazo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MazoTest {
    GeneradorDeCartas generadorDeCartas;
    @BeforeEach
    void setUp(){
        generadorDeCartas = new GeneradorDeCartas();
    }
    @Test

    public void test01ElMazoDeCartasSeCreaConLaCantidadDeCartasCorrectas(){
        //arrange
        int cantidadCorrecta = 52;
        int cantidadCartas;
        Mazo maso = new Mazo(generadorDeCartas);

        //act

        cantidadCartas = maso.obtenerCantidadDeCartas();

        // assert
        Assertions.assertEquals(52, maso.obtenerCantidadDeCartas());
        //Assertions.assertEquals(cantidadCorrecta, cantidadCartas);
        //Assertions.assertTrue(cantidadDeCartas = cantidadCorrecta);
    }
}
