package edu.fiuba.algo3.entrega_3.factoryDeComodinTest;


import edu.fiuba.algo3.controllers.Factory.FactoryComodines;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class factoryDeComodinTest {
    @Test
    public void test01SeCreanTodosLosComodinesYSeCuentan(){
        FactoryComodines factoryComodines = new FactoryComodines("src/main/resources/comodines.json");

        List<Comodin> listaComodines = factoryComodines.generarComodines();

        Assertions.assertEquals(40,listaComodines.size());
    }
}
