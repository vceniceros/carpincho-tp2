package edu.fiuba.algo3.entrega_3.RondaTestIntegrador;

import edu.fiuba.algo3.controllers.Factory.FactoryDeMaso;
import edu.fiuba.algo3.controllers.Factory.FactoryDeTarot;
import edu.fiuba.algo3.controllers.Factory.FactoryRondas;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mano.Mano;
import edu.fiuba.algo3.modelo.Mazo.Mazo;
import edu.fiuba.algo3.modelo.MazoDeComodines.MazoDeComodines;
import edu.fiuba.algo3.modelo.Modificable.Modificador;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Tarot.Tarot;
import edu.fiuba.algo3.modelo.ronda.Ronda;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class RondaTestIntegrador {
    @Test
    public void testIntegradorRondaJugador() {
        Jugador unJugador = new Jugador("martin");
        Mazo mazo = new Mazo(new FactoryDeMaso("src/main/resources/mazo.json"));
        Mano mano = new Mano(mazo, 3,new MazoDeComodines());
        unJugador.asignarMano(mano);
        Tarot tarot = new Tarot("prueba", "prueba", new Puntaje(4, 2.0), new Modificador("puntaje"));

        List<Ronda> rondas = null;
        FactoryDeMaso factoryDeMaso = new FactoryDeMaso("src/main/resources/mazo.json");
        FactoryDeTarot factoryDeTarot = new FactoryDeTarot("src/main/resources/tarots.json");
        FactoryRondas factoryRondas = new FactoryRondas("src/main/resources/balatro.json",factoryDeTarot, factoryDeMaso );

        try {
            rondas = factoryRondas.generarRondas();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Ronda ronda = rondas.get(0);
        Ronda ronda2 = rondas.get(1);

        ronda.asignarJugador(unJugador);
        ronda.asignarMazo(mazo);
        ronda.jugar();
        Puntaje puntaje = ronda.seleccionar(2);
        puntaje = ronda.seleccionar(3);
        puntaje = ronda.seleccionar(4,tarot);
        puntaje = ronda.seleccionar(5);
        puntaje = ronda.seleccionar(6);
        Assertions.assertThrows(IllegalStateException.class, () -> {
            ronda.seleccionar(7);
        }, "Ya se han seleccionado las cartas máximas permitidas (5 cartas).");
    }
}
