package edu.fiuba.algo3.entrega_2.parserTest;

import edu.fiuba.algo3.entrega_1.Prooveedor.Proveedor;
import edu.fiuba.algo3.entrega_1.carta.Carta;
import edu.fiuba.algo3.entrega_2.Factory.FactoryDeMaso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class parserMazoTest{
    @Test
    public void test01SeParseaUnMazoYSeVerificaLaCantidadDeCartas(){
        Proveedor factoryDeMazo = new FactoryDeMaso("src/main/resources/mazo.json");

        List<Carta> cartas = factoryDeMazo.repartirCartas();

        Assertions.assertEquals(52, cartas.size());
    }
}
