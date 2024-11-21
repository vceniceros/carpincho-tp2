package edu.fiuba.algo3.entrega_2.parserRonda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.util.List;

public class ParserRondaTest {
    @Test
   public void test01SeParseanLasRondasTiendasComodinesyTarots(){
        List<Ronda> rondas = null;
        try {
             rondas = parserRonda.parseRondas("src/main/resources/balatro.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(8, rondas.size() );
    }
}