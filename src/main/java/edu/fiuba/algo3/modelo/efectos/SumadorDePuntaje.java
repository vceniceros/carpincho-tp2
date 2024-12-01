package edu.fiuba.algo3.modelo.efectos;

import edu.fiuba.algo3.controllers.Parseados.EfectoParseado;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;

public class SumadorDePuntaje extends Efecto {
    public SumadorDePuntaje(EfectoParseado efecto) {
        super(efecto);
    }

    @Override
    public Puntaje aplicarEfecto(Puntaje puntaje) {
         puntaje.modificarValor(this.puntos);
         return puntaje;
    }


}
