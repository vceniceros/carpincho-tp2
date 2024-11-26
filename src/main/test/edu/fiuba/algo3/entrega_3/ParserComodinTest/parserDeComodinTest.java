package edu.fiuba.algo3.entrega_3.ParserComodinTest;

import edu.fiuba.algo3.controllers.Factory.FactoryDeComodines;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class parserDeComodinTest {
    @Test
    public void test01SeGeneranTodosLosComodinesYSeCuentanLosMismos(){
        FactoryDeComodines factoryDeComodines = new FactoryDeComodines("src/main/resources/comodines.json");

        List<Comodin> comodines = factoryDeComodines.generarComodines();

        Assertions.assertEquals(40, comodines.size());
    }
}
