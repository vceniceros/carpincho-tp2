package edu.fiuba.algo3.modelo.efectos;

import edu.fiuba.algo3.controllers.Parseados.EfectoParseado;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;

public class MultiplicadorDePuntaje extends Efecto {
    public MultiplicadorDePuntaje(EfectoParseado efecto) {
        super(efecto);
    }

    @Override
    public Puntaje aplicarEfecto(Puntaje puntaje) {
        puntaje.multiplicarValor(this.puntos);
        return puntaje;
    }
}
