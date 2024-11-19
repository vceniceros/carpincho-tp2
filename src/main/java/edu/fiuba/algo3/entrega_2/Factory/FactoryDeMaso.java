package edu.fiuba.algo3.entrega_2.Factory;

import edu.fiuba.algo3.entrega_1.Prooveedor.Proveedor;
import edu.fiuba.algo3.entrega_1.carta.Carta;
import edu.fiuba.algo3.entrega_2.Parser.CartaParseada;
import edu.fiuba.algo3.entrega_2.Parser.ParserMazo;

import java.util.List;

public class FactoryDeMaso implements Proveedor {
    String ruta;

    public FactoryDeMaso(String ruta) {
        this.ruta = ruta;
    }


    @Override
    public List<Carta> repartirCartas() {
        List<CartaParseada> cartasFake = ParserMazo.convertirDeJsonAFakeCartas(this.ruta);
        List<Carta> cartas = ParserMazo.parsearDeFakeCartaACarta(cartasFake);
        return cartas;
    }
}
