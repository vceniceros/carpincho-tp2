package edu.fiuba.algo3.controllers.Factory;

import edu.fiuba.algo3.controllers.Parseados.EfectoParseado;
import edu.fiuba.algo3.controllers.Parser.ErrorAlParsearJson;
import edu.fiuba.algo3.modelo.efectos.*;

public class EfectoFactory {


    public static Efecto crearEfecto(String descripcion, EfectoParseado efecto) {
        Efecto efectoGenerado;
        if (descripcion.charAt(0) == '+' && efecto.getPuntos() > 1) {
            efectoGenerado = new SumadorDePuntaje(efecto);
        } else if (descripcion.charAt(0) == 'x' && efecto.getPuntos() < 1) {
            efectoGenerado = new MultiplicadorDePuntaje(efecto);
        } else if (descripcion.charAt(0) == '+' && efecto.getMultiplicador() > 1) {
            efectoGenerado = new SumadorDeMultiplicador(efecto);
        } else if (descripcion.charAt(0) == 'x' && efecto.getMultiplicador() < 1) {
            efectoGenerado = new MultiplicadorDeMultiplicador(efecto);
        } else if (descripcion.charAt(0) == '+' && efecto.getPuntos() > 1 && efecto.getMultiplicador() > 1) {
            efectoGenerado = new SumadorDePuntajeYMultiplicador(efecto);
        } else {
            throw new ErrorAlParsearJson();
        }

        return efectoGenerado;
    }
}