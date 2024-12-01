package edu.fiuba.algo3.modelo.efectos;

import edu.fiuba.algo3.controllers.Parseados.EfectoParseado;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;

public class MultiplicadorDeMultiplicador extends Efecto {
    public MultiplicadorDeMultiplicador(EfectoParseado efecto) {
        super(efecto);
    }

    @Override
    public Puntaje aplicarEfecto(Puntaje puntaje) {
        puntaje.multiplicarMultiplicador(this.multiplicador);
        return puntaje;
    }

}
