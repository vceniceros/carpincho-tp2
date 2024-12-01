package edu.fiuba.algo3.modelo.efectos;

import edu.fiuba.algo3.controllers.Parseados.EfectoParseado;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;

public abstract class Efecto {
    protected int puntos;
    protected double multiplicador;

    public Efecto(EfectoParseado efectoParseado){
       this.puntos = efectoParseado.getPuntos();
       this.multiplicador = efectoParseado.getMultiplicador();
    }

    public abstract Puntaje aplicarEfecto(Puntaje puntaje);
}
