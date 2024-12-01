package edu.fiuba.algo3.modelo.efectos;

import edu.fiuba.algo3.controllers.Parseados.EfectoParseado;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;

public class SumadorDePuntajeYMultiplicador extends Efecto {
    public SumadorDePuntajeYMultiplicador(EfectoParseado efecto) {
        super(efecto);
    }

    @Override
    public Puntaje aplicarEfecto(Puntaje puntaje) {
        puntaje.modificarMultiplicador(this.multiplicador);
        puntaje.modificarValor(this.puntos);
        return puntaje;
    }


}
