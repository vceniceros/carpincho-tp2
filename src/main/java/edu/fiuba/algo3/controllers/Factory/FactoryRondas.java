package edu.fiuba.algo3.controllers.Factory;
import edu.fiuba.algo3.controllers.Parseados.*;
import edu.fiuba.algo3.controllers.Parser.ParserMazo;
import edu.fiuba.algo3.controllers.Parser.ParserJuego;
import edu.fiuba.algo3.modelo.Tarot.Tarot;
import edu.fiuba.algo3.modelo.ronda.Ronda;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.ronda.Tienda;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FactoryRondas {
    String ruta;
    FactoryDeTarot factoryDeTarot;
    FactoryDeMaso factoryDeMaso;

    public FactoryRondas(String ruta, FactoryDeTarot factoryDeTarot, FactoryDeMaso factoryDeMaso) {
        this.ruta = ruta;
        this.factoryDeTarot = factoryDeTarot;
        this.factoryDeMaso = factoryDeMaso;
    }

    public List<Ronda> generarRondas() throws IOException {
        List<Ronda> rondas = new ArrayList<>();
        List<RondaParseada> rondasFake = ParserJuego.parseRondas(this.ruta);
        for (RondaParseada fakeRonda: rondasFake) {
            TiendaParseado tiendaFake = fakeRonda.getTienda();
            List<ComodinParseado> comodinesFake = tiendaFake.getComodines();
            List<TarotParseado> tarotsFake = tiendaFake.getTarots();
            List<CartaParseada> cartasFake = tiendaFake.getCartas();
            if (cartasFake == null) {
                cartasFake = new ArrayList<>();
            }
            List<Tarot> tarots = this.factoryDeTarot.generarTarots(tarotsFake);
            List<Carta> cartas = this.factoryDeMaso.generarCartas(cartasFake);
            Tienda tienda = new Tienda(tarots, comodinesFake, cartas);
            Ronda ronda = ParserJuego.parsearDeFakeRondaARonda(fakeRonda, tienda);
            rondas.add(ronda);
        }
        return rondas;
    }


}
